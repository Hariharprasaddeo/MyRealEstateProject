package com.ourProperty.config;

import com.ourProperty.filters.PropertyApprovalFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<PropertyApprovalFilter> propertyApprovalFilter(){
        FilterRegistrationBean<PropertyApprovalFilter> registrationBean = new FilterRegistrationBean<PropertyApprovalFilter>();
        registrationBean.setFilter(new PropertyApprovalFilter());
        registrationBean.addUrlPatterns("/api/properties/*"); // Apply the filter to specific url patterns

        return registrationBean;

    }
}
