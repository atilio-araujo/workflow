package dev.atilioaraujo.workflow.model.workflow;

import dev.atilioaraujo.workflow.model.step.Step;
import dev.atilioaraujo.workflow.model.step.StepMemento;
import dev.mccue.guava.collect.ImmutableMap;
import lombok.Getter;

import java.util.Map;

public class WorkflowContext {

    @Getter
    private final ImmutableMap<String, Object> data;
    private StepMemento memento;

    public WorkflowContext(Step currentStep, Map<String, Object> data) {
        this.data = ImmutableMap.copyOf(data);
        this.memento = new StepMemento(currentStep);
    }

    public StepMemento memento() {
        return this.memento;
    }

    public void setMemento(Step step) {
        this.memento = new StepMemento(step);
    }
}
