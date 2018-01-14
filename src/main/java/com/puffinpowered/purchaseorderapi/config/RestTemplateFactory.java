package com.puffinpowered.purchaseorderapi.config;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@Component
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {

    @Value("${hostName}")
    private String hostName;
    @Value("${port}")
    private int port;
    @Value("${scheme}")
    private String scheme;

    @Value("${remoteUserName}")
    private String remoteUsername;
    @Value("${remotePass}")
    private String remotePassword;

    private RestTemplate restTemplate;

    public RestTemplate getObject() {
        return restTemplate;
    }

    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }

    public boolean isSingleton(){
        return true;
    }

    public void afterPropertiesSet(){
        HttpHost host = new HttpHost(hostName, port, scheme);
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(host)) ;
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(remoteUsername, remotePassword));
    }

}
