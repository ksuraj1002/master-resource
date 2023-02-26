package com.feign.client.master.app.feign;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feign.client.master.app.exception.DuplicateFoundException;
import com.google.common.io.CharStreams;
import com.master.core.dto.ErrorDetail;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	private ErrorDecoder errorDecoder = new Default();

	@SuppressWarnings("deprecation")
	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
		ErrorDetail errorDetail;
		try {
			//InputStream input = response.body().asInputStream();
			Object errorResponse = CharStreams.toString(response.body().asReader());
			errorDetail = mapper.readValue(errorResponse.toString(), ErrorDetail.class);
		} catch (IOException e) {
			return errorDecoder.decode(methodKey, response);
		}
		switch (response.status()) {
		case 409:
			return new DuplicateFoundException(errorDetail.getMessage());
		default:
			return errorDecoder.decode(methodKey, response);
		}
	}

}
