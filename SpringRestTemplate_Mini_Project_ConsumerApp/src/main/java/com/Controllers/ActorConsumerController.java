package com.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.Model.Actor;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Controller
public class ActorConsumerController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/actor_report")
	public String fetchAllActors(Map<String, Object> map) throws Exception {
	    /*
	     * provider url :: http://localhost:2020/SpringRestProj16-ProviderApp-Actor/actor/api/report
	     * req method/mode :: GET
	     * path variables :: no
	     * response content type :: application/json (default)
	     * request headers :: no
	     * request body type :: no
	     */

	    String serviceUrl = env.getProperty("fetchAllActors.serviceurl");

	    //invoke Provider -RestController operation/method using exchange(...) of RestTemplate
	    ResponseEntity<String> response = template.exchange(
	        serviceUrl,
	        HttpMethod.GET,
	        null,
	        String.class
	    );

	    // get json response from response obj
	    String jsonBody = response.getBody();

	    //convert json body into List<Actor> object
	    ObjectMapper mapper = new ObjectMapper();
	    List<Actor> list = mapper.readValue(
	        jsonBody,
	        new TypeReference<List<Actor>>() {}
	    );

	    //add result to map object (Shared Memory b/w Controller, DS and View comps)
	    map.put("actorsInfo", list);

	    //return LVN
	    return "show_report";
	}
}
