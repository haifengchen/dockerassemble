package com.haifeng.namechoose;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
public class InitInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        print(request);
        return true;
    }

    private void print(HttpServletRequest request) {
        request.setAttribute("startTime", System.currentTimeMillis());
        String uri = request.getRequestURI();
        log.info("REQUEST BEGIN ======================" + uri + " | METHOD ::" + request.getMethod()+" "+request.getRemoteUser());
        log.info("REQUEST URL ======================" + request.getRequestURL() + " | HOST ::" + request.getRemoteHost());
        log.info("REQUEST LocalName ======================" + request.getLocalName() + " | IP ::" + request.getLocalAddr());
        log.info("REQUEST RemoteName ======================" + request.getRemoteHost() + " | IP ::" + request.getRemoteAddr());
        Enumeration<String> em = request.getHeaderNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getHeader(name);
            log.info(name + "=" + value);
        }
        request.getHeader("Referer");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        log.info("REQUEST END ::::: " + " TIME ::  " + executeTime + "ms" + " | URL ::" + request.getRequestURI());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
