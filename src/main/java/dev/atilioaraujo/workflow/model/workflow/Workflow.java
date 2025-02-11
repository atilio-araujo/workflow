package dev.atilioaraujo.workflow.model.workflow;

import dev.atilioaraujo.workflow.model.step.actions.StepAction;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Stack;

@Log
public class Workflow extends WorkflowTemplate {

    public Workflow(WorkflowHistory history, List<StepAction> actions) {
        super(history, actions);
    }

    public static Workflow freshStart(WorkflowBuilder builder) {
        WorkflowHistory history = new WorkflowHistory(new Stack<>());
        return new Workflow(history, builder.actions());
    }
}
