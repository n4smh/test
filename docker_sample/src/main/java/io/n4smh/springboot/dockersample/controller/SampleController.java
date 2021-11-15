package io.n4smh.springboot.dockersample.controller;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/samplecontroller")
public class SampleController {

	@Autowired
	Environment env;

	@GetMapping("/info")
	public String getInfo() throws Exception {

		System.out.println("------------------------------ Entred ------------------------------");

		String hostName = InetAddress.getLocalHost().getHostName();
		String hostAddress = InetAddress.getLocalHost().getHostAddress();

		String resMsg = "Response -> " + hostName + " : " + hostAddress + " : " + LocalDateTime.now();
		System.out.println(resMsg);

		System.out.println("------------------------------ Exiting ------------------------------");

		return resMsg;
	}

	@GetMapping("/properties/{name}")
	public String getAllProperties(@PathVariable("name") String propertyName) {
		
		System.out.println("------------------------------ Entred ------------------------------");
		
		String resMsg = "Response -> " + propertyName + " : " + env.getProperty(propertyName);

		System.out.println("------------------------------ Exiting ------------------------------");

		return resMsg;
	}
}
