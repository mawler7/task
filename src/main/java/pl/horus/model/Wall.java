package pl.horus.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Wall implements Structure {

    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        List<Block> basicBlocks = blocks.stream()
                .filter(BasicBlock.class::isInstance)
                .filter(b -> b.getMaterial().equals(material))
                .toList();

        List<Block> compositeBlocks = blocks.stream()
                .filter(CompositeBasicBlock.class::isInstance)
                .map(block -> ((CompositeBasicBlock) block).getBlocks())
                .flatMap(List::stream)
                .filter(b -> b.getMaterial().equals(material))
                .toList();

        return Stream.concat(basicBlocks.stream(),compositeBlocks.stream())
                .toList();
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }

}
