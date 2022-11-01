package resttemplatems.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration // con esto, spring viene hacia aca para ejecutar esto antes de levantar por completo la app
public class RestTemplateConfig {

    // Es importante para instancia RestTemplate ya que no lo encontrara de otra manera
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
