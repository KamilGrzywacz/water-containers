package pl.kurs.watercontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kurs.watercontainers.models.WaterContainer;

@SpringBootApplication
public class WaterContainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterContainersApplication.class, args);

        WaterContainer beczka = WaterContainer.create("Beczka",100,50);
        System.out.println(beczka);


        beczka.addWater(30);
        System.out.println(beczka);


        WaterContainer mazuer = WaterContainer.create("mauzer",1000,150);

        try {
            mazuer.pourWater(beczka, 120);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(mazuer);

        System.out.println(beczka);
    }

}
