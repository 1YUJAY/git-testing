package com.sheridan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car tests")
public class CarTest {

    @Test
    @DisplayName("Refuel increases fuel level")
    public void testRefuelIncreasesFuelLevel() {
        Car car = new Car("Honda", "Civic", 2015, 15.0);
        car.refuel(20.0);
        assertEquals(20.0, car.getFuelLevel(), 1e-3,
                "Fuel level should increase by the refueled amount.");
    }

    @Test
    @DisplayName("Invalid refuel amount does not change fuel")
    public void testRefuelWithInvalidAmountDoesNotChangeFuel() {
        Car car = new Car("Honda", "Civic", 2015, 15.0);
        car.refuel(-5.0);
        assertEquals(0.0, car.getFuelLevel(), 1e-3,
                "Fuel level should not change with invalid refuel amount.");
    }

    @Test
    @DisplayName("Drive consumes fuel correctly")
    public void testDriveConsumesFuelCorrectly() {
        Car car = new Car("Honda", "Civic", 2015, 15.0);
        car.refuel(15.0);
        car.drive(150.0);
        assertEquals(5.0, car.getFuelLevel(), 1e-3,
                "Driving should consume correct amount of fuel.");
    }

    @Test
    @DisplayName("Drive fails if not enough fuel")
    public void testDriveFailsIfNotEnoughFuel() {
        Car car = new Car("Honda", "Civic", 2015, 15.0);
        car.refuel(2.0);
        car.drive(100.0);
        assertEquals(2.0, car.getFuelLevel(), 0.001,
                "Fuel should remain unchanged if not enough to complete drive.");
    }

    @Nested
    class WhenFuelEfficiencyEqualsZero {

        @Test
        public void testDisplayInfoMinimumFuelEfficiencyIs0() {
            Car car = new Car("Honda", "Civic", 2015, 0);
            assertThrows(RuntimeException.class, ()-> car.refuel(20.0));
        }
    }
}
