package example.logger.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@NoArgsConstructor
@PropertySource("classpath:logger.properties")
public class LoggerProperties {
    @Value("${example.logger.enabled}")
    private boolean enabled;
}