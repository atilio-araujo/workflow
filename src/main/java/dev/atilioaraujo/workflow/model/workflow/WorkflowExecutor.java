package dev.atilioaraujo.workflow.model.workflow;

import dev.atilioaraujo.workflow.model.step.StepMemento;
import lombok.extern.java.Log;

import java.util.Optional;

@Log
public class WorkflowExecutor {

    private final WorkflowHistory history;
    private final WorkflowTemplate template;

    public WorkflowExecutor(WorkflowTemplate template) {
        this.history = template.getHistory();
        this.template = template;
    }

    public void execute(WorkflowContext context) {
        try {
            this.template.executeWorkflow(context);
        } catch (Exception ex) {
            log.info("Workflow has failed. Retrying...");
            this.retry(context);
        }
    }

    public void retry(WorkflowContext context) {
        Optional<StepMemento> stepMemento = this.history.lastStepState();
        if (stepMemento.isPresent()) {
            log.info("Restarting workflow from step: " + context.memento().lastCompletedStep().name());
            this.template.executeWorkflow(context);
        } else {
            log.info("There is no saved state. Restarting from the beginning...");
        }
    }
}
