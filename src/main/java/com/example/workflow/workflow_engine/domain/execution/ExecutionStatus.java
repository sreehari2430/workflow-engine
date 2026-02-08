package com.example.workflow.workflow_engine.domain.execution;

public enum ExecutionStatus {

    PENDING,
    RUNNING,
    COMPLETED,
    FAILED,
    CANCELLED;

    public boolean isTerminal() {
        return this == COMPLETED || this == FAILED || this == CANCELLED;
    }

    public boolean canTransitionTo(ExecutionStatus next) {
        return switch (this) {
            case PENDING ->  next == RUNNING || next == CANCELLED;
            case RUNNING -> next == COMPLETED || next == FAILED || next == CANCELLED;
            case COMPLETED, FAILED, CANCELLED -> false;
        };
    }
}
