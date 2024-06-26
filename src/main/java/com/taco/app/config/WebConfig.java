package com.taco.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * WebMvcConfigurer defines several methods for configuring Spring MVC. Even
	 * though it’s an interface, it provides default implementations of all the
	 * methods, so you need to override only the methods you need. In this case, you
	 * override addViewControllers().
	 */

	/*
	 * The addViewControllers() method is given a ViewControllerRegistry that you
	 * can use to register one or more view controllers. Here, you call
	 * addViewController() on the registry, passing in “/”, which is the path for
	 * which your view controller will handle GET requests. That method returns a
	 * ViewControllerRegistration object, on which you immediately call
	 * setViewName() to specify home as the view that a request for “/” should be
	 * forwarded to
	 */

	/*
	 * And just like that, you’ve been able to replace HomeController with a few
	 * lines in a configuration class.
	 */

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

}
