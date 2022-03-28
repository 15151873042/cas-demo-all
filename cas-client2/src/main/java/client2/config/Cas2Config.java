package client2.config;


import client2.properties.CasProperties;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CasProperties.class)
public class Cas2Config {


    @Autowired
    private CasProperties casProperties;


    @Bean
    public FilterRegistrationBean casFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AuthenticationFilter());
        registrationBean.setName("AuthenticationFilter");
        registrationBean.addInitParameter("casServerLoginUrl",casProperties.getCasServerLoginUrl());
        registrationBean.addInitParameter("serverName",casProperties.getServerName());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(3);
        return registrationBean;
    }


    @Bean
    public FilterRegistrationBean casValidationFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new Cas20ProxyReceivingTicketValidationFilter());
        registrationBean.setName("TicketValidationFilter");
        registrationBean.addInitParameter("casServerUrlPrefix",casProperties.getCasServerUrlPrefix());
        registrationBean.addInitParameter("serverName",casProperties.getServerName());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(4);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean casHttpWrapperFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HttpServletRequestWrapperFilter());
        registrationBean.setName("CAS HttpServletRequest Wrapper Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(5);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean casAssertionLocalFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AssertionThreadLocalFilter());
        registrationBean.setName("CAS Assertion Thread Local Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(6);
        return registrationBean;
    }


}
