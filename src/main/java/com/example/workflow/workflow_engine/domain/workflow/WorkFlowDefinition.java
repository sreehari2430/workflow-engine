package com.example.workflow.workflow_engine.domain.workflow;

import com.example.workflow.workflow_engine.domain.step.Step;

import java.util.List;
import java.util.Objects;

public class WorkFlowDefinition {

    private final String name;
    private final List<Step> steps;

    public WorkFlowDefinition(String name, List<Step> steps) {
        this.name = Objects.requireNonNull(name);
        this.steps = List.copyOf(steps); // immutability
    }

    public String getName() {
        return name;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
