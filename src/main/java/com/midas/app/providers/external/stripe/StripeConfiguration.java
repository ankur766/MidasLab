package com.midas.app.providers.external.stripe;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Configuration
@ConfigurationProperties("stripe")
@Component
public class StripeConfiguration {

  @NonNull private String apiKey;
}
