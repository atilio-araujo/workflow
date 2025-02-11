package dev.atilioaraujo.workflow.model.step.actions;

import dev.atilioaraujo.workflow.model.step.Step;
import dev.atilioaraujo.workflow.model.workflow.WorkflowContext;
import lombok.extern.java.Log;

@Log
public class FinishAction implements StepAction {

    @Override
    public void execute(WorkflowContext context) {
        log.info("FINISHING");
    }

    @Override
    public Step step() {
        return Step.FINALIZE;
    }

    @Override
    public boolean hasCallback() {
        return false;
    }

}