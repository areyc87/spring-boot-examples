package co.edu.unbosque.programacion2.examen.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "mapper")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
