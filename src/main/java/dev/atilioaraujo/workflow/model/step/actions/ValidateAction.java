package dev.atilioaraujo.workflow.model.step.actions;

import dev.atilioaraujo.workflow.model.step.Step;
import dev.atilioaraujo.workflow.model.workflow.WorkflowContext;
import lombok.extern.java.Log;

@Log
public class ValidateAction implements StepAction {

    @Override
    public void execute(WorkflowContext context) {
        log.info("VALIDATING");
    }

    @Override
    public Step step() {
        return Step.VALIDATE;
    }

    @Override
    public boolean hasCallback() {
        return false;
    }

}
