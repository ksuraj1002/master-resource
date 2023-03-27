package com.master.core.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SearchQueryParam {

	@Parameter(name = "name",schema=@Schema(type="string"), required=false, description = "valid source app id", in =ParameterIn.QUERY)
    private String name;
	
	@Parameter(name = "notificationType",schema=@Schema(type="string",allowableValues = {"EMAIL","SMS","KAFKA"}), required=false, description = "valid source app id",example = "EMAIL", in =ParameterIn.QUERY)
	private String notificationType;
	
	@Parameter(name = "startDate",schema=@Schema(type="string",format = "date-time"), required=false, description = "valid source app id",example = "EMAIL", in =ParameterIn.QUERY)
	private String startDate;

}
