package com.midas.app.activities.impl;

import com.midas.app.activities.AccountActivity;
import com.midas.app.models.Account;
import com.midas.app.providers.external.stripe.StripeConfiguration;
import com.midas.app.providers.external.stripe.StripePaymentProvider;
import com.midas.app.providers.payment.CreateAccount;
import com.midas.app.providers.payment.PaymentProvider;
import com.stripe.exception.StripeException;
import io.temporal.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountActivityImpl implements AccountActivity {

  @Autowired StripeConfiguration stripeConfiguration;

  @Override
  public Account createPaymentAccount(Account account) {
    try {
      PaymentProvider paymentProvider = new StripePaymentProvider(stripeConfiguration);
      return paymentProvider.createAccount(
          CreateAccount.builder()
              .email(account.getEmail())
              .firstName(account.getFirstName())
              .lastName(account.getLastName())
              .build());
    } catch (StripeException e) {
      throw Activity.wrap(e);
    }
  }

  @Override
  public Account saveAccount(Account account) {
    return null;
  }
}
