package ru.test.demonstrator.nodes;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@DiscriminatorValue("BLOCK")
public class BlockNode extends CfgNode{
    @Column(name = "next_id")
    Integer next;

    @Column(name = "previous_id")
    Integer prev;

    @ElementCollection
    @CollectionTable(name = "node_tags", joinColumns = @JoinColumn(name = "node_id"))
    @OrderColumn(name = "list_index")
    @Column(name = "tag_value")
    List<String> instructions;

    public BlockNode() {}

    public BlockNode(Integer id, Integer next, Integer prev, String[] instructions) {
        super(id);

        this.next = next;
        this.prev = prev;
//        this.instructions = Arrays.stream(instructions).map(inst -> {return new BlockInstr(inst);}).collect(Collectors.toList());
        this.instructions = Arrays.stream(instructions).toList();
    }

    public Integer getNext() {
        return this.next;
    }

    public Integer getPrev() {
        return this.prev;
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
