package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.*;
import java.util.stream.Collectors;

public class WaterContainerService {


    public Optional<WaterContainer> findTheMostFilledContainer(List<WaterContainer> waterContainerList) {
        return Optional.ofNullable(waterContainerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(WaterContainer::getWaterLevel));
    }

    public Optional<WaterContainer> findTheMostPercentageFilledContainer(List<WaterContainer> waterContainerList) {
        return Optional.ofNullable(waterContainerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(c -> c.getWaterLevel() / c.getMaxCapacity()));
    }


    public List<WaterContainer> findEmptyContainers(List<WaterContainer> waterContainerList) {
        return Optional.ofNullable(waterContainerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getWaterLevel() == 0)
                .collect(Collectors.toList());


    }
}
