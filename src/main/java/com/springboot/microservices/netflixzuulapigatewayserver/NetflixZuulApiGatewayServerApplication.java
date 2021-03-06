package com.springboot.microservices.netflixzuulapigatewayserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    /*@Configuration
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers("/*currency-converter/**").hasRole("User")
                    .antMatchers("/*currency-converter/**").hasRole("Admin");
        }
    }*/
}
