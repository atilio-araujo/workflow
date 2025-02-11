package dev.atilioaraujo.workflow.model.step.actions;

import dev.atilioaraujo.workflow.model.step.Step;
import dev.atilioaraujo.workflow.model.workflow.WorkflowContext;

public interface StepAction {

    void execute(WorkflowContext context);
    Step step();
    boolean hasCallback();

}
