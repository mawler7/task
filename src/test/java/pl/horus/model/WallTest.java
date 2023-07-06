package pl.horus.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.horus.fixtures.WallFixtures;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class WallTest {

    private Wall wall;

    @BeforeEach
    void setUp() {
        wall = WallFixtures.createValidWall();
    }

    @Test
    void shouldFindBlockByExistingColor() {
        Optional<Block> result = wall.findBlockByColor("Blue");
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Blue", result.get().getColor());

    }

    @Test
    void shouldNotFindBlockByNonExistingColor() {
        Optional<Block> result = wall.findBlockByColor("Yellow");
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void shouldFindBlocksByExistingMaterial() {
        List<Block> result = wall.findBlocksByMaterial("Bricks");
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void shouldReturnEmptyListIfNonExistingMaterialProvided() {
        List<Block> result = wall.findBlocksByMaterial("Coal");
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void shouldCountTotalNumberOfBlocks() {
        int result = wall.count();
        Assertions.assertEquals(9, result);
    }

    @Test
    void shouldGetListOfMaterialsFromCompositeBasicBlock() {
        List<String> result =  new ArrayList<>();
        wall.getBlocks().stream()
                .filter(b -> b instanceof CompositeBasicBlock)
                .forEach(block -> {
                    ((CompositeBasicBlock) block).getBlocks().forEach(b ->
                            result.add(b.getMaterial()));
                });
        Assertions.assertEquals(6, result.size());
    }

    @Test
    void toStringMethodShouldReturnValidString() {
        List<Block> blocks = new ArrayList<>();

        blocks.add(new BasicBlock("Blue", "Wood"));
        blocks.add(new BasicBlock("Green", "Bricks"));
        Wall wall = new Wall();
        wall.setBlocks(blocks);

        String expectedString = "Wall(blocks=" + blocks + ")";
        Assertions.assertEquals(expectedString, wall.toString());
    }

    @Test
    void equalsAndHashCodeShouldWorkCorrectly() {
        List<Block> blocks1 = new ArrayList<>();
        List<Block> blocks2 = new ArrayList<>();
        blocks1.add(new BasicBlock("Blue", "Wood"));
        blocks1.add(new BasicBlock("Green", "Bricks"));

        blocks2.add(new BasicBlock("Yellow", "Wood"));
        blocks2.add(new BasicBlock("Purple", "Bricks"));
        Wall wall1 = new Wall(blocks1);
        Wall wall2 = new Wall(blocks1);
        Wall wall3 = new Wall(blocks2);

        Assertions.assertEquals(wall1, wall2);
        Assertions.assertEquals(wall1.hashCode(), wall2.hashCode());
        Assertions.assertNotEquals(wall1, wall3);
        Assertions.assertNotEquals(wall1.hashCode(), wall3.hashCode());

    }

}
