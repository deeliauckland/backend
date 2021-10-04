package com.example.demo.service;



import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


	
	@CrossOrigin(origins = "*", maxAge = 3600)//cross origin configuration
	@RestController
	public class LoanServices {	
	
		@PostMapping("fullPayment")
		public String fullPayment(@RequestBody FullPaymentRequest fullPaymentRequest)  {
			Float fPv=new Float(fullPaymentRequest.getPv());
			Float fFv=new Float(fullPaymentRequest.getFv());
			Float fRate=new Float(fullPaymentRequest.getRate());
			fRate = fRate/1200;
			Float fTerm=new Float(fullPaymentRequest.getTerm());
			
			Double result=(fPv-fFv/Math.pow((1+fRate),fTerm))
					*(fRate/(1-Math.pow(1+fRate,-1*fTerm)));
			
			DecimalFormat df = new DecimalFormat("0.00");
			
			return String.valueOf(df.format(result));
		}
		
		@PostMapping("login")
		public String login(@RequestBody LoginRequest loginRequest)throws Exception {
			String username=new String(loginRequest.getUsername());
			String password=new String(loginRequest.getPassword());
			if(username.equals(".\\interview")&&password.equals("Rain2016")) {
				return "true";
			}else {
				
				throw new HttpUnauthorizedException();
			}
			
		}
		
		
		
	
	

	
	
	

}
