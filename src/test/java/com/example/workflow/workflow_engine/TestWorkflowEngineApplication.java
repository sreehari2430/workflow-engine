package com.example.workflow.workflow_engine;

import org.springframework.boot.SpringApplication;

public class TestWorkflowEngineApplication {

	public static void main(String[] args) {
		SpringApplication.from(WorkflowEngineApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
