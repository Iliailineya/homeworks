package spring;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class HomeworksApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HomeworksApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
