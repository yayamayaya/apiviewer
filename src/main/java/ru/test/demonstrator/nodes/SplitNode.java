package ru.test.demonstrator.nodes;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SPLIT")
public class SplitNode extends CfgNode{
    @Column(name = "previous_id")
    Integer prev;

    @ElementCollection
    @CollectionTable(name = "next_index", joinColumns = @JoinColumn(name = "node_id"))
    @Column(name = "next_id")
    Integer[] next;

    public SplitNode() {
    }

    public SplitNode(Integer id, Integer prev, Integer[] next) {
        super(id);

        this.prev = prev;

        if (next.length != 2) {
            throw new IllegalArgumentException("Bad split exception");
        }
        this.next = next;
    }

    public Integer getPrev() {
        return this.prev;
    }

    public Integer[] getNext() {
        return this.next;
    }
}
