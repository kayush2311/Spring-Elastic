package com.ayush.app.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ElasticClientConfiguration {

	@Value("${elasticsearch.host}")
	private String host;
	@Value("${elasticsearch.port}")
	private int port;
	
	public String getHost() {
		return host;
	}
	public int getPort() {
		return port;
	}
	
	@Bean(destroyMethod = "close")
	public RestClient elasticClient() {
		return RestClient.builder(new HttpHost(host, port)).build();
	}
}
