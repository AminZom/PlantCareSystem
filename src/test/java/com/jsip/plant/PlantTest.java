package com.jsip.plant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlantTest {

    @Test
    void testGreen() {
        Plant plant = new Plant("Jasmine", "5 days ago", "Every 7 days");
        Status status = plant.getStatus();
        assertEquals(Status.Green, status);
    }

    @Test
    void testLightGreen1() {
        Plant plant = new Plant("Jasmine", "6 days ago", "Every 7 days");
        Status status = plant.getStatus();
        assertEquals(Status.LightGreen, status);
    }

    @Test
    void testLightGreen2() {
        Plant plant = new Plant("Jasmine", "7 days ago", "Every 7 days");
        Status status = plant.getStatus();
        assertEquals(Status.LightGreen, status);
    }

    @Test
    void testYellow1() {
        Plant plant = new Plant("Jasmine", "8 days ago", "Every 7 days");
        Status status = plant.getStatus();
        assertEquals(Status.Yellow, status);
    }

    @Test
    void testYellow2() {
        Plant plant = new Plant("Jasmine", "9 days ago", "Every 7 days");
        Status status = plant.getStatus();
        assertEquals(Status.Yellow, status);
    }

    @Test
    void testRed() {
        Plant plant = new Plant("Jasmine", "10 days ago", "Every 7 days");
        Status status = plant.getStatus();
        assertEquals(Status.Red, status);
    }
}