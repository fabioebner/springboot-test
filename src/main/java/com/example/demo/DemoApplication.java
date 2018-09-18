package com.example.demo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
		return (tomcat) -> {
			tomcat.addConnectorCustomizers((connector) ->
					((AbstractHttp11Protocol<?>)connector.getProtocolHandler()).setRelaxedQueryChars("[]"));
		};
	}
}
