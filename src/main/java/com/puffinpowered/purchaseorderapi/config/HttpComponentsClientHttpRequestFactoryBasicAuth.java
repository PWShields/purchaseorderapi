package com.puffinpowered.purchaseorderapi.config;

import org.apache.http.HttpHost;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;

import java.net.URI;

/**
 * Automatically manage authorisation of HTTP header as an alternative to manually creating
 * header. RestTemplate will still need an Interceptor with username and password before use;
 * e.g. restTemplate.getInterceptors().add() new BasicAuthorizationInterceptor("username", "password")
 */

public class HttpComponentsClientHttpRequestFactoryBasicAuth extends HttpComponentsAsyncClientHttpRequestFactory {

     HttpHost host;

     public HttpComponentsClientHttpRequestFactoryBasicAuth(HttpHost host) {
         super();
         this.host = host;
     }

     protected HttpContext createHttpContext (HttpMethod httpMethod, URI uri){
         return createHttpContext();
     }

     private HttpContext createHttpContext() {
         AuthCache authCache = new BasicAuthCache();

         BasicScheme basicAuth = new BasicScheme();
         authCache.put(host, basicAuth);

         BasicHttpContext localcontext = new BasicHttpContext();
         localcontext.setAttribute(HttpClientContext.AUTH_CACHE, authCache);
         return localcontext;


     }

}
