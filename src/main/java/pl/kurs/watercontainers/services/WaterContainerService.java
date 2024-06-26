package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.*;

public class WaterContainerService {


    public Optional<WaterContainer> findTheMostFilledContainer(List<WaterContainer> waterContainerList) {
       return Optional.ofNullable(waterContainerList)
               .orElseGet(Collections::emptyList)
               .stream()
               .filter(Objects::nonNull)
               .max(Comparator.comparingDouble(WaterContainer::getWaterLevel));
    }

    public Optional<WaterContainer> findTheMostPercentageFilledContainer(List<WaterContainer> waterContainerList){
        return Optional.ofNullable(waterContainerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(c -> c.getWaterLevel() / c.getMaxCapacity()));
    }

}
