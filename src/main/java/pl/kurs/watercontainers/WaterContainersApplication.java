package pl.kurs.watercontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kurs.watercontainers.models.WaterContainer;
import pl.kurs.watercontainers.services.WaterContainerService;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WaterContainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterContainersApplication.class, args);

        WaterContainer waterContainer = WaterContainer.create("Beczka",100,50);
        System.out.println(waterContainer);


        List<WaterContainer> waterContainerList = Arrays.asList(
                WaterContainer.create("Beczka 1", 200, 50),
                WaterContainer.create("Beczka 2", 400, 10),
                null
        );
        WaterContainerService waterContainerService = new WaterContainerService();
        System.out.println(waterContainerService.findTheMostFilledContainer(null).orElseThrow());
    }


}
