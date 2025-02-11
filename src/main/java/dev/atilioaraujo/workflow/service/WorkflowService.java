package dev.atilioaraujo.workflow.service;

import dev.atilioaraujo.workflow.model.core.ProductRequest;
import dev.atilioaraujo.workflow.model.step.Step;
import dev.atilioaraujo.workflow.model.step.actions.*;
import dev.atilioaraujo.workflow.model.workflow.Workflow;
import dev.atilioaraujo.workflow.model.workflow.WorkflowBuilder;
import dev.atilioaraujo.workflow.model.workflow.WorkflowContext;
import dev.atilioaraujo.workflow.model.workflow.WorkflowExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowService {

    public void startWorkflow(ProductRequest data) {

        Workflow workflow = Workflow.freshStart(workflowBuilder());
        WorkflowContext context = new WorkflowContext(Step.INITIALIZE, data.toMap());
        WorkflowExecutor executor = new WorkflowExecutor(workflow);

        executor.execute(context);
    }

    //Retrieve from database instead
    private WorkflowBuilder workflowBuilder() {
        List<StepAction> actions = List.of(
                new InitializeAction(),
                new ValidateAction(),
                new ProcessAction(),
                new FinishAction()
        );

        return new WorkflowBuilder(actions);
    }

}
