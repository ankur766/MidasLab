package configuration;

import com.midas.app.workflows.impl.CreateAccountWorkflowImpl;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

  @Autowired private WorkerFactory workerFactory;

  @Bean
  public void startTemporalWorker() {
    Worker worker = workerFactory.newWorker("stripe-task-queue");
    worker.registerWorkflowImplementationTypes(CreateAccountWorkflowImpl.class);
    worker.registerActivitiesImplementations(new CreateAccountWorkflowImpl());
    workerFactory.start();
  }
}
