package com.master.core.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class SearchQueryParam {

	@Parameter
    private String name;

}
