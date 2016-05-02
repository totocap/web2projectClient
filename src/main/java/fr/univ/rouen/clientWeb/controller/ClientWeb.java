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
	
	private String uri;
	
	private final static ClientWeb instance =  new ClientWeb();
	
	private ClientWeb() {
		uri = "http://rocky-gorge-86159.herokuapp.com/";
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFrontPage()
	{
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(getInstance().getUri() + "/", String.class);
	     
	    return result;
	}
	
	public StbListVO getResumePage()
	{
	    RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<StbListVO> response = restTemplate.exchange(getInstance().getUri() + "/resume", 
				HttpMethod.GET, entity, StbListVO.class);
		StbListVO result = response.getBody();

	    return result;
	}
	
	public StbModelVO getSTBById(String id)
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<StbModelVO> response = restTemplate.exchange(getInstance().getUri() + "/resume/{id}", 
				HttpMethod.GET, entity, StbModelVO.class, id);
		StbModelVO result = response.getBody();
		
	    return result;
	}
	
	public String postStb(StbModelVO stb) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<StbModelVO> entity = new HttpEntity<StbModelVO>(stb, headers);
		ResponseEntity<String> response = restTemplate.exchange(getInstance().getUri() + "/depot",
				HttpMethod.POST, entity, String.class);
		String result = response.getBody();
		
	    return result;
	}
	
	public static ClientWeb getInstance() {
		return instance;
	}
	
	
	public static void main(String[] args){
		// http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
		System.out.println(ClientWeb.getInstance().getResumePage());
	
	}

}
