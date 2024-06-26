package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidCapacityException;
import pl.kurs.watercontainers.exceptions.InvalidLevelException;
import pl.kurs.watercontainers.exceptions.InvalidWaterAmountException;

import java.io.Serializable;
import java.util.Objects;

public class WaterContainer implements Serializable, Comparable<WaterContainer> {

    private String name;
    private double maxCapacity;
    private double waterLevel;

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }


    public static WaterContainer create(String name, double maxCapacity, double waterLevel) {
        if (maxCapacity <= 0)
            throw new InvalidCapacityException("Max capacity must be more than zero");
        if (waterLevel < 0 || waterLevel > maxCapacity)
            throw new InvalidLevelException("Invalid water level value");
        return new WaterContainer(name, maxCapacity, waterLevel);
    }

    public String getName() {
        return name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(that.maxCapacity, maxCapacity) == 0 && Double.compare(that.waterLevel, waterLevel) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, waterLevel);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }

    @Override
    public int compareTo(WaterContainer o) {
        int result = Double.compare(o.waterLevel, waterLevel);
        if (result == 0) {
            result = Double.compare(o.maxCapacity, maxCapacity);
        }
        if (result == 0) {
            result = name.compareTo(o.name);
        }
        return result;
    }


    public void addWater(double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Value should be more than 0!");
        }
        if (waterLevel + value > maxCapacity) {
            throw new InvalidWaterAmountException("Too much water to add!");
        }
        waterLevel += value;
    }

    public void pourOutWater(double value) {
        if (value <= 0) {
            throw new InvalidLevelException("Value should be more than zero");
        }
        if (waterLevel - value < 0) {
            throw new InvalidWaterAmountException("Too much water to subtract");
        }
        waterLevel -= value;


    }


}
