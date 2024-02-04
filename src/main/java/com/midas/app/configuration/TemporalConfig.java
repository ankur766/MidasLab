package com.midas.app.configuration;

import com.midas.app.activities.impl.AccountActivityImpl;
import com.midas.app.workflows.CreateAccountWorkflow;
import com.midas.app.workflows.impl.CreateAccountWorkflowImpl;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

  @Autowired private WorkerFactory workerFactory;

  @Autowired AccountActivityImpl accountActivity;

  @Bean
  public Worker startTemporalWorker() {
    Worker worker = workerFactory.newWorker(CreateAccountWorkflow.QUEUE_NAME);
    worker.registerWorkflowImplementationTypes(CreateAccountWorkflowImpl.class);
    worker.registerActivitiesImplementations(accountActivity);
    workerFactory.start();
    return worker;
  }
}
