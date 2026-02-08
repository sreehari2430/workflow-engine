package com.example.workflow.workflow_engine.domain.step;

import java.util.Objects;

public class Step {

    private final String name;
    private final int maxRetrices;

    public Step(String name, int maxRetrices) {
        this.name = Objects.requireNonNull(name);
        this.maxRetrices = maxRetrices;
    }

    public String getName() {
        return name;
    }

    public int getMaxRetrices() {
        return maxRetrices;
    }
}
