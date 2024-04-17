package aze.Abbasov;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
@SpringBootApplication(scanBasePackages = {"aze.Abbasov.abstractions", "aze.Abbasov", "aze.Abbasov.controllers"})
@EntityScan("aze.Abbasov.models")
public class Main {
    public static void main(String[] args) {
        Init.migrate();
//        SpringApplication.run(Main.class, args);
        ApplicationContext context = SpringApplication.run(Main.class, args);
        /*var ownerController = context.getBean(OwnerController.class);
        ownerController.addOwner(new OwnerDto(LocalDate.now(),new ArrayList<CatDto>(), "h"));*/
    }
}

