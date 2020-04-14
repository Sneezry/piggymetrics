package com.piggymetrics.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

public class LeakFactory
{//Just so that we have some data to leak
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
}

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayApplication {

	public Leak[] myHoles;

	public static void main(String[] args) {
		myHoles = new Leak[1000];

        for (int i = 0; i++; i<1000)
        {//Store them in the class member
            myHoles[i] = new LeakFactory().createLeak();
        }
		
		SpringApplication.run(GatewayApplication.class, args);
	}
}
