package com.example.workflow.workflow_engine.domain.execution;

import com.example.workflow.workflow_engine.domain.step.Step;

import java.time.Instant;
import java.util.Objects;

public class StepExecution {

    private final Step step;
    private ExecutionStatus status;
    private int attempts;
    private Instant lastUpdated;

    public StepExecution(Step step) {
        this.step = Objects.requireNonNull(step);
        this.status = ExecutionStatus.PENDING;
        this.attempts = 0;
        this.lastUpdated = Instant.now();
    }

    public void start() {
        transitionTo(ExecutionStatus.RUNNING);
        attempts++;
    }

    public void complete() {
        transitionTo(ExecutionStatus.COMPLETED);
    }

    public void fail() {
        if (attempts >= step.getMaxRetrices()) {
            transitionTo(ExecutionStatus.FAILED);
        } else {
            transitionTo(ExecutionStatus.PENDING);
        }
    }

    private void transitionTo(ExecutionStatus next) {
        if (!status.canTransitionTo(next)) {
            throw new IllegalStateException(
                    "Invalid step transition: " + status + " → " + next
            );
        }
        this.status = next;
        this.lastUpdated = Instant.now();
    }
}
