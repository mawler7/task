package pl.horus.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BlockTest {

    @Test
    void shouldReturnCorrectColor() {
        BasicBlock block = new BasicBlock();
        String expectedColor = "Red";
        block.setColor(expectedColor);
        String actualColor = block.getColor();
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void shouldReturnCorrectMaterial() {
        BasicBlock block = new BasicBlock();
        String expectedMaterial = "Wood";
        block.setMaterial(expectedMaterial);
        String actualMaterial = block.getMaterial();
        Assertions.assertEquals(expectedMaterial, actualMaterial);
    }


}
