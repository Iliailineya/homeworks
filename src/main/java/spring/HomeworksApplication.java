package spring;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HomeworksApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HomeworksApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
