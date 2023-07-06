package pl.horus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompositeBasicBlock implements CompositeBlock {

    private List<Block> blocks;

    @Override
    public String getColor() {
        return blocks.stream()
                .findFirst()
                .map(Block::getColor)
                .orElse(null);
    }

    @Override
    public String getMaterial() {
        return blocks.stream()
                .findFirst()
                .map(Block::getMaterial)
                .orElse(null);
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }


}
