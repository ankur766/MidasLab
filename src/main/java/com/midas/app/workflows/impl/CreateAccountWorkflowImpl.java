package com.midas.app.workflows.impl;

import com.midas.app.activities.AccountActivity;
import com.midas.app.models.Account;
import com.midas.app.workflows.CreateAccountWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;

public class CreateAccountWorkflowImpl implements CreateAccountWorkflow {

  private final AccountActivity stripeActivity =
      Workflow.newActivityStub(
          AccountActivity.class,
          ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofMinutes(5)).build());

  @Override
  public Account createAccount(Account details) {
    return stripeActivity.createPaymentAccount(details);
  }
}
