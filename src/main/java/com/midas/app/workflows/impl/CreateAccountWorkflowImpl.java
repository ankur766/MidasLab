package com.midas.app.workflows.impl;

import com.midas.app.activities.AccountActivity;
import com.midas.app.models.Account;
import com.midas.app.workflows.CreateAccountWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class CreateAccountWorkflowImpl implements CreateAccountWorkflow {

  private final AccountActivity stripeActivitiy =
      Workflow.newActivityStub(AccountActivity.class, ActivityOptions.newBuilder().build());

  @Override
  public Account createAccount(Account details) {
    return stripeActivitiy.createPaymentAccount(details);
  }
}
