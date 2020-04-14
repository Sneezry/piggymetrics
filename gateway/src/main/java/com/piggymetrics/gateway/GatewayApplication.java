package com.piggymetrics.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayApplication {
    int myID = 0;
    // Necessary because our Leak class is non-static
    public Leak createLeak()
    {
        return new Leak();
    }

    // Mass Manufactured Leak class
    public class Leak
    {//Again for a little data.
       int size = 1;
    }

	public static Leak[] myHoles;

	public static void main(String[] args) {
		myHoles = new Leak[1000];

        for (int i = 0; i < 1000; i++)
        {//Store them in the class member
            myHoles[i] = new GatewayApplication().createLeak();
        }
		
		SpringApplication.run(GatewayApplication.class, args);
	}
}
