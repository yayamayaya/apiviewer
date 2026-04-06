package ru.test.demonstrator.nodes;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("JOIN")
public class JoinNode extends CfgNode{
    @ElementCollection
    @CollectionTable(name = "prev_index", joinColumns = @JoinColumn(name = "node_id"))
    @Column(name = "previous_id")
    Integer[] prev;

    @Column(name = "next_id")
    Integer next;

    public JoinNode() {
    }

    public JoinNode(Integer id, Integer[] prev, Integer next) {
        super(id);

        this.next = next;

        if (prev.length != 2) {
            throw new IllegalArgumentException("Bad join exception");
        }
        this.prev = prev;
    }

    public Integer[] getPrev() {
        return this.prev;
    }

    public Integer getNext() {
        return this.next;
    }
}
