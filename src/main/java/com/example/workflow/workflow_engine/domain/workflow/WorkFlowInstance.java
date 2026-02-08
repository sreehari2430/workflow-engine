package com.example.workflow.workflow_engine.domain.workflow;

import com.example.workflow.workflow_engine.domain.execution.ExecutionStatus;
import com.example.workflow.workflow_engine.domain.workflow.WorkFlowDefinition;

import java.util.Objects;
import java.util.UUID;

public class WorkFlowInstance {

    private final UUID id;
    private final WorkFlowDefinition definition;
    private ExecutionStatus status;

    public WorkFlowInstance(WorkFlowDefinition definition) {
        this.id = UUID.randomUUID();
        this.definition = Objects.requireNonNull(definition);
        this.status = ExecutionStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public WorkFlowDefinition getDefinition() {
        return definition;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void transitionTo(ExecutionStatus next) {
        if (!status.canTransitionTo(next)) {
            throw new IllegalStateException(
                    "Invalid status transition: " + status + " → " + next
            );
        }
        this.status = next;
    }

}
