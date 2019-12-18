package edu.cityu.ds.report.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by starice on 2019-12-18.
 */

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.components(new Components())
			.info(new Info().title("Contact Application API").description(
				"SDSC5003 Course Project Documents using springdoc-openapi and OpenAPI 3."));
	}
}
