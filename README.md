# API Gateways (Netflix Zuul)
* Provides the following common features by acting as an interceptor.
* Authentication, Authorization and security
* Rate Limits.
* Fault Tolerance.
* Service Aggregation.
* Since all requests go via an API gateway, this is a great place for debugging and Analytics.
* Enabled using Annotation @EnableZuulProxy.
* Microservice can use "http://localhost:8765/{application-name}/{uri}" to route requests via API gateway. Ex: http://localhost:8765/currency-exchange-service/currency-exchange/from/AUD/to/INR
