package com.endproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/end")
public class EndProductController {
	@Autowired
	EndProductService endProductService;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getUpperCase")
	public String getUpperCase() {
		
		String url ="http://localhost:8080/prod/getString";
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		String s =response.getBody();
		return s.toUpperCase();	
	}	
	
	@GetMapping("/getEndProduct")
	public List<EndProduct> getEndProduct(){
		String url1 = "http://localhost:8080/prod/getAll";
		String url2="http://localhost:8081/gst/getDisByHsn/";
		ResponseEntity <List<EndProduct>> response = restTemplate.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference <List<EndProduct>>() {});
		List<EndProduct> ep= response.getBody();
		ep.forEach(x->{
			int hsn=x.getHsn();
			ResponseEntity<Integer> r2 = restTemplate.exchange(url2+hsn, HttpMethod.GET, null, Integer.class);
			int d = r2.getBody();
			x.setPrice(x.getPrice()-x.getPrice()*d/100);
		});
		return ep;
		
	}
	
	@PostMapping("/postUpdate")
	public String postUpdate() {
		return  endProductService.postUpdate(getEndProduct());
		
	}



}
