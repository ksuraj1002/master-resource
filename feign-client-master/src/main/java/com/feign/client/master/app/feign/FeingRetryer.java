package com.feign.client.master.app.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.RetryableException;
import feign.Retryer;

@Component
public class FeingRetryer extends Retryer.Default {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private int retryMaxAttempt;
	private long retryInterval;
	private int attempt=1;
	
	public FeingRetryer() {
		this(3, 2000L);
	}
	
	public FeingRetryer(int retryMaxAttempt,Long retryInterval) {
		this.retryMaxAttempt = retryMaxAttempt;
		this.retryInterval = retryInterval;
	} 
	
	@Override
	public void continueOrPropagate(RetryableException e) {
		logger.info("Feign retry attempt {} due to {} ",attempt,e.getMessage());
		if(attempt ++ ==retryMaxAttempt) {
			throw e;
		}
		try {
			Thread.sleep(retryInterval);
		}catch(InterruptedException ignored) {
			Thread.currentThread().interrupt();
		}
	}
	
	@Override
	public Retryer clone() {
		return new FeingRetryer(retryMaxAttempt,retryInterval);
	}
	
}
