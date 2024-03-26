package example.logger.config;

import example.logger.aspect.LoggableAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("example.logger.aspect")
public class LoggerAutoConfiguration {

    @Bean
    public LoggableAspect loggableAspect() {
        return new LoggableAspect();
    }
}
