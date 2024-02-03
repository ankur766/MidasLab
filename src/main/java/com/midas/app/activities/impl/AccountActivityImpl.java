package com.midas.app.activities.impl;

import com.midas.app.activities.AccountActivity;
import com.midas.app.models.Account;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import io.temporal.activity.Activity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AccountActivityImpl implements AccountActivity {
  @Override
  public Account createPaymentAccount(Account account) {
    try {
      Map<String, Object> mapOfAccount = new HashMap<>();
      mapOfAccount.put("email", account.getEmail());
      mapOfAccount.put(
          "name", String.join(" ", List.of(account.getFirstName(), account.getLastName())));
      Customer customer = Customer.create(mapOfAccount);
      account.setId(UUID.fromString(customer.getId()));
      return account;
    } catch (StripeException e) {
      throw Activity.wrap(e);
    }
  }

  @Override
  public Account saveAccount(Account account) {
    return null;
  }
}
