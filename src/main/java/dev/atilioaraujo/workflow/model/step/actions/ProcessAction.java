package dev.atilioaraujo.workflow.model.step.actions;

import dev.atilioaraujo.workflow.model.step.Step;
import dev.atilioaraujo.workflow.model.workflow.WorkflowContext;
import lombok.extern.java.Log;

@Log
public class ProcessAction implements StepAction {

    @Override
    public void execute(WorkflowContext context) {
        log.info("PROCESSING");
    }

    @Override
    public Step step() {
        return Step.PROCESS;
    }

    @Override
    public boolean hasCallback() {
        return false;
    }

}
