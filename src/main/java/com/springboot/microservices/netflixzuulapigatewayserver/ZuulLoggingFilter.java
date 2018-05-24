package com.springboot.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        /** pre - Before the request is execute
         *  post - After the request has been executed
         *  Error - Executed only when there is an error
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {}, request uri -> {}", request, request.getRequestURI());
        return null;
    }
}
