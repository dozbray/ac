package com.girllee.ac.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by boot on 7/9/16.
 */
public class WebMvcApplicationInitializer implements WebApplicationInitializer{

    /**
     * Configure the given {@link ServletContext} with any servlets, filters, listeners
     * context-params and attributes necessary for initializing this web application. See
     * examples {@linkplain WebApplicationInitializer above}.
     *
     * @param servletContext the {@code ServletContext} to initialize
     * @throws ServletException if any call against the given {@code ServletContext}
     *                          throws a {@code ServletException}
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        if(servletContext != null){
            servletContext.setInitParameter("contextConfigLocation","classpath:applicationContext.xml");
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            servletContext.addListener(new ContextLoaderListener(context));

            ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", new DispatcherServlet(context));
            registration.setLoadOnStartup(1);
            registration.addMapping("/*");
        }

    }
}
