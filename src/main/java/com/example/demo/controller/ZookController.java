package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zook")
public class ZookController {
	
	@Value("${spring.application.name}")
	private String instanceName;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private Environment environment;

    public String getZook() {
        return "";
    }

    @RequestMapping("/getServices")
    public String discoveryClent() {
    	List<ServiceInstance> list = client.getInstances(instanceName);
        List<String> services = new ArrayList<>();
        if (list != null && list.size() > 0 ) {
            list.forEach(serviceInstance -> {
                services.add(serviceInstance.getUri().toString());
            });
        }
        return services.toString();
    }

    @GetMapping("/env2")
    public String test2() {
    	//获取实例化的注册节点
        List<ServiceInstance> list = client.getInstances("CONSUL-CLIENT");

        //获取实例化的服务
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0 ) {
            sb.append(list.get(0).getUri()+",");
        }
        return "hello world  "+sb.toString();

    }
    @GetMapping("/env")
    public String test() {
    	String[] profiles = environment.getActiveProfiles();
    	System.out.println("profiles>>>>>>>" + profiles.length);
    	for (String item : profiles) {
    		System.out.println("item>>>>>>>>>>>>>>>" + item);
    	}
    	
    	String name = environment.getProperty("url");
    	System.out.println(name);
    	
    	return "Hello," + name;
    }
}
