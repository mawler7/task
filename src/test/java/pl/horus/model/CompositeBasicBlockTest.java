package pl.horus.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CompositeBasicBlockTest {

    @Test
    void shouldGetCorrectMaterialFromFirstBlock() {
        CompositeBasicBlock compositeBasicBlock = new CompositeBasicBlock();
        BasicBlock block1 = new BasicBlock();
        String expectedMaterial = "Wood";
        block1.setMaterial(expectedMaterial);

        BasicBlock block2 = new BasicBlock();
        block2.setMaterial("Bricks");

        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);

        compositeBasicBlock.setBlocks(blocks);

        String actualMaterial = compositeBasicBlock.getMaterial();

        Assertions.assertEquals(expectedMaterial, actualMaterial);
    }

}
