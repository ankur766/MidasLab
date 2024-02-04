# Getting Started

## Introduction

Backend Engineer Code Assessment - **MidasAssignment**

## How to Run and What's added

1. Start the temporal
2. Run the spring boot application
3. APIs are documented in Swagger UI. Once the application is up, swagger UI can be accessed from 127.0.0.1:8080/swagger-ui/index.html
   1. springdoc-openapi-starter-webmvc-ui dependency is added for Swagger
   2. SwaggerConfig class is providing the configuration of it
   3. APIs can be tested from Swagger UI
4. Workflow Implementations are added
5. Tempoarl Configuration class is added in configration directory
6. Account Activity implementation class is added for temporal workflow activity
7. AccountController is updated with GetMapping & PostMapping
8. Account entity is updated. providerType and providerId feilds are added.
9. Stripe api key has been added for test env
10. StripePaymentProvider class is updated with implementation of Stripe api.
    1. createAccount has the implementation of customer creation in Stripe
    2. Stripe generated user ID is now saved in providerId field of Account table
11. Autowiring of components are fixed in the code.
