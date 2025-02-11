package dev.atilioaraujo.workflow.model.step;

public enum Step {

    INITIALIZE("Initialize"),
    VALIDATE("Validate"),
    PROCESS("Process"),
    FINALIZE("Finalize");

    Step(String name) {
        this.name = name;
    }

    final String name;
}
