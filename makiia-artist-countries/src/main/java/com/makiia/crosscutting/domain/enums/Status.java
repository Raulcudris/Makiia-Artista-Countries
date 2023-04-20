package com.makiia.crosscutting.domain.enums;

public enum Status {
    OK("OK", "SUCCESSFUL"),
    FAIL("FALLO", "FAILED"),
    INITIAL("INITIAL", "SUCCESSFUL");

    private final String description;
    private final String label;

    Status(final String description, final String label) {
        this.description = description;
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }
}
