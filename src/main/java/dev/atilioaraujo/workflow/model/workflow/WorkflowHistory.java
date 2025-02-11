package dev.atilioaraujo.workflow.model.workflow;

import dev.atilioaraujo.workflow.model.step.StepMemento;

import java.util.Optional;
import java.util.Stack;

public record WorkflowHistory(
        Stack<StepMemento> history
) {

    public void addStep(StepMemento stepMemento) {
        this.history.push(stepMemento);
    }

    public Optional<StepMemento> lastStepState() {
        if (!this.history.empty()) {
            return Optional.of(this.history.pop());
        } else {
            return Optional.empty();
        }
    }

}
