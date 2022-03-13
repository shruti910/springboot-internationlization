package com.international.project;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {

	/** We use the LocaleResolver interface for
	 * resolving the locale of a user from the incoming request.
	 * Default Locale is set to US.
	 * @return LocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		/* For session based Locale Resolver*/
		/*
		 * SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		 * sessionLocaleResolver.setDefaultLocale(Locale.US); 
		 * return sessionLocaleResolver;
		 */

		/* For Accept Header based Locale Resolver */
		final AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
	}

	/**It will switch to a new locale based on the value of the 'language' parameter 
	 * appended to an HTTP request URL. (For session based Locale Resolver).
	 * For Ex: the application will switch to a French locale, when the HTTP URL
	 * of the web application is http://localhost:8080/index?language=fr.
	 * @return LocaleChangeInterceptor
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}


	/**
	 *LocaleChangeInterceptor bean needs to be added to the application's interceptor registry.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	

	/**
	 * Resolves text messages from properties file based on different locales.
	 * @return ResourceBundleMessageSource
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("internationalisation/messages"); /*sets the path of messages.properties file under src/main/resources/ */
		source.setDefaultEncoding("UTF-8");
		return source;
	}


}
