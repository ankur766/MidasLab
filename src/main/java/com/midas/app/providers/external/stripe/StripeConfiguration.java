package com.midas.app.providers.external.stripe;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("stripe")
public class StripeConfiguration {

  @Value("${stripe.api-key}")
  @NonNull private String apiKey;
}
