## Internationalization in Spring Boot
### Internationalization is the process of making an application adaptable to multiple languages and regions without major changes in the source code.

In this project, we are taking example of sending response in different languages (English, French and German).
English (US) is the default response language.

We will be using `AcceptHeaderLocaleResolver` to resolve the locale using an accept-language HTTP header retrieved from an HTTP request.

