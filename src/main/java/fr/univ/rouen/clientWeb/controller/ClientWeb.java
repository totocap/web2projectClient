package fr.univ.rouen.clientWeb.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.univ.rouen.clientWeb.model.StbListVO;
import fr.univ.rouen.clientWeb.model.StbModelVO;

public class ClientWeb {
	
	public String uri;
	
	public final static ClientWeb instance =  new ClientWeb();
	
	private ClientWeb() {
		uri = "http://rocky-gorge-86159.herokuapp.com/";
	}

	public static String getFrontPage()
	{
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(instance.uri + "/", String.class);
	     
	    return result;
	}
	
	public static StbListVO getResumePage()
	{
	    RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<StbListVO> response = restTemplate.exchange(instance.uri + "/stbs", 
				HttpMethod.GET, entity, StbListVO.class);
		StbListVO result = response.getBody();
	     
	    return result;
	}
	
	public static StbModelVO getSTBById(String id)
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<StbModelVO> response = restTemplate.exchange(instance.uri + "/stbs/{id}", 
				HttpMethod.GET, entity, StbModelVO.class, id);
		StbModelVO result = response.getBody();
		
	    return result;
	}
	
	/*private static String postStb(StbModelVO stb) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_XML);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange(uri + "/depot", 
				HttpMethod.POST, entity, String.class);
		String result = response.getBody();
	 
	    return result;
	}*/
	
	
	public static void main(String[] args){
		// http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
		getSTBById("1");
		for(StbModelVO s :  getResumePage().getStb()) {
			//System.out.println(s);
		}
	}

}
