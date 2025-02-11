package dev.atilioaraujo.workflow.model.workflow;

import dev.atilioaraujo.workflow.model.step.StepMemento;
import dev.atilioaraujo.workflow.model.step.actions.StepAction;
import dev.mccue.guava.collect.ImmutableList;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;


@Log
public abstract class WorkflowTemplate {

    @Getter
    private final WorkflowHistory history;
    private final ImmutableList<StepAction> actions;

    public WorkflowTemplate(WorkflowHistory history, List<StepAction> actions) {
        if (Objects.isNull(actions)) {
            actions = new ArrayList<>();
        }

        if (Objects.isNull(history)) {
            history = new WorkflowHistory(new Stack<>());
        }

        this.history = history;
        this.actions = ImmutableList.copyOf(actions);
    }

    public final void executeWorkflow(WorkflowContext context) {
        try {
            for (int i = 0; i < this.actions.size() - 1; i++) {
                StepAction action = this.actions.get(0);
                log.info("Executing step: " + action.step() + " with data: " + context.getData().toString());
                context.setMemento(action.step());
                action.execute(context);
                this.history.addStep(context.memento());

                if (checkCallback(action, i)) {
                    log.info("Asynchronous step:" + action.step().name() + ". It will continue on next flow restart");
                    break;
                }
            }
        } catch (Exception e) {
            log.info("Error while executing step: " + e.getMessage());
            this.history.addStep(context.memento());
            throw e;
        }
    }

    private boolean checkCallback(StepAction action, int actionIndex) {
        boolean hasCallback = false;
        if (action.hasCallback()) {
            if (actionIndex < this.actions.size() - 1) {
                StepAction nextAction = this.actions.get(actionIndex + 1);
                this.history.addStep(new StepMemento(nextAction.step()));
                hasCallback = true;
            }
        }

        return hasCallback;
    }

}
