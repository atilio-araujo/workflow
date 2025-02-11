package dev.atilioaraujo.workflow.model.step;

public enum StepResult {
    SUCCESS("Sucess"),
    FAILED("Failed");

    StepResult(String name) {
        this.name = name;
    }

    final String name;
}
