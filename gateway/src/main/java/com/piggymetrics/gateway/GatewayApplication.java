package com.piggymetrics.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayApplication {
    @Override
    protected void finalize() throws Throwable {
        while (true) {
            Thread.yield();
        }
    }

	public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            GatewayApplication f = new GatewayApplication();
        }
		SpringApplication.run(GatewayApplication.class, args);
	}
}
