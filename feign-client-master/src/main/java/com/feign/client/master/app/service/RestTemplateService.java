package com.feign.client.master.app.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory; 
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestTemplateService {
	
	private RestTemplate restTemplate;
	ObjectMapper mapper = new ObjectMapper();
	
	public RestTemplateService() {
		restTemplate = new RestTemplate(new CustomHttpComponentsClientsHttpRequestFactory());
	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json"));
		return headers;
	}
	
	public JsonNode getResponseOnRestCall(String pathParam,MultiValueMap<String, String> queryParam,Map<String,String> requestBody, String accessToken) throws JsonProcessingException {
		ResponseEntity<String> response = null;
		try {
			Map<String,String> pathVariable = new HashMap<String, String>();
			pathVariable.put("tenantId", pathParam);
			String registryUrl = "url/{tenantId}";
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(registryUrl).queryParams(queryParam);
			HttpEntity<String> reqEntity = new HttpEntity<String>(mapper.writeValueAsString(requestBody),getHttpHeaders());
			
			response=this.restTemplate.exchange(builder.buildAndExpand(pathVariable).toUri(), HttpMethod.GET,reqEntity,String.class);
		}catch(HttpStatusCodeException e) {
			
		}
		return mapper.readValue(response.getBody(), JsonNode.class);
	}
	
	
	
	private static final class CustomHttpComponentsClientsHttpRequestFactory extends 
								HttpComponentsClientHttpRequestFactory{
		public HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
			if(HttpMethod.GET.equals(httpMethod)) {
				return new HttpEntityEnclosingGetRequestBase(uri);
			}
			return super.createHttpUriRequest(httpMethod, uri);
		}
	}
	
	private static final class HttpEntityEnclosingGetRequestBase extends HttpEntityEnclosingRequestBase{

		private HttpEntityEnclosingGetRequestBase(final URI uri) {
			super.setURI(uri);
		}
		
		@Override
		public String getMethod() {
			return HttpMethod.GET.name();
		}
		
	}
	
}
