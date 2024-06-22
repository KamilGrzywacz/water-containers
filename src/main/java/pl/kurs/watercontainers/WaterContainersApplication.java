package pl.kurs.watercontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kurs.watercontainers.models.WaterContainer;

@SpringBootApplication
public class WaterContainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterContainersApplication.class, args);

        WaterContainer waterContainer = WaterContainer.create("Beczka",100,50);
        System.out.println(waterContainer);


        waterContainer.addWater(50);
        System.out.println(waterContainer);


    }

}
