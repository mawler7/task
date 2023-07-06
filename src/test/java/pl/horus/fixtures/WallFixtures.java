package pl.horus.fixtures;

import pl.horus.model.BasicBlock;
import pl.horus.model.Block;
import pl.horus.model.CompositeBasicBlock;
import pl.horus.model.Wall;

import java.util.Arrays;
import java.util.List;


public class WallFixtures {

    public static Wall createValidWall() {
        List<Block> blocks = Arrays.asList(
                new BasicBlock("Red", "Bricks"),
                new BasicBlock("Green", "Wood"),
                new BasicBlock("Blue", "Stone"),
                new CompositeBasicBlock(
                        Arrays.asList(
                                new BasicBlock("Red", "Bricks"),
                                new BasicBlock("Green", "Wood"),
                                new BasicBlock("Blue", "Stone")
                        )
                ),
                new CompositeBasicBlock(
                        Arrays.asList(
                                new BasicBlock("Red", "Wood"),
                                new BasicBlock("Green", "Stone"),
                                new BasicBlock("Blue", "Bricks")
                        )
                )
        );
        return new Wall(blocks);
    }
}
