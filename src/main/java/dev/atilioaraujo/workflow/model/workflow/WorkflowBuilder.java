package dev.atilioaraujo.workflow.model.workflow;

import dev.atilioaraujo.workflow.model.step.actions.StepAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkflowBuilder {

    private List<StepAction> actions;

    public WorkflowBuilder() {}
    public WorkflowBuilder(List<StepAction> actions) {
        this.actions = actions;
    }

    public void addAction(StepAction action) {
        this.actions.add(action);
    }

    public List<StepAction> actions() {
        if (!Objects.isNull(this.actions)) {
            return this.actions;
        } else {
            return new ArrayList<>();
        }
    }
}
