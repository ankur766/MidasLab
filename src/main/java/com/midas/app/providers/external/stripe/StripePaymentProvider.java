package com.midas.app.providers.external.stripe;

import com.midas.app.constant.Constants;
import com.midas.app.models.Account;
import com.midas.app.providers.payment.CreateAccount;
import com.midas.app.providers.payment.PaymentProvider;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class StripePaymentProvider implements PaymentProvider {
  private final Logger logger = LoggerFactory.getLogger(StripePaymentProvider.class);

  @Autowired private final StripeConfiguration configuration;

  public StripePaymentProvider(StripeConfiguration configuration) {
    this.configuration = configuration;
    Stripe.apiKey = configuration.getApiKey();
  }

  /** providerName is the name of the payment provider */
  @Override
  public String providerName() {
    return Constants.STRIPE;
  }

  /**
   * createAccount creates a new account in the payment provider.
   *
   * @param details is the details of the account to be created.
   * @return Account
   */
  @Override
  public Account createAccount(CreateAccount details) throws StripeException {
    Map<String, Object> mapOfAccount = new HashMap<>();
    mapOfAccount.put(Constants.EMAIL, details.getEmail());
    mapOfAccount.put(
        Constants.NAME, String.join(" ", List.of(details.getFirstName(), details.getLastName())));
    Customer customer = Customer.create(mapOfAccount);
    details.setUserId(customer.getId());

    return ((Object) Account.builder())
        .firstName(details.getFirstName())
        .lastName(details.getLastName())
        .email(details.getEmail())
        .providerType(providerName())
        .providerId(details.getUserId())
        .build();
  }
}
