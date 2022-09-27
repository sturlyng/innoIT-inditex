package com.inditex.endpoint.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*import com.inditex.endpoint.adapter.in.rest.PriceRestService;
*/
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
public class EndpointBoot {

	public static void main(String[] args) {
		SpringApplication.run(EndpointBoot.class, args);
	}

}
