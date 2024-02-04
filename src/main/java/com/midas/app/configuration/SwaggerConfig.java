package com.midas.app.configuration;

import com.midas.app.constant.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info =
        @Info(
            title = Constants.API_INFO_TITLE,
            description = Constants.API_INFO_DESCRIPTION,
            version = Constants.API_INFO_VERSION))
@Configuration
public class SwaggerConfig {}
