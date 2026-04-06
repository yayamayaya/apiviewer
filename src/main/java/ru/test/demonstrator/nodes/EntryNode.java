package ru.test.demonstrator.nodes;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ENTRY")
public class EntryNode extends CfgNode {
    @Column(name = "next_id")
    Integer next;

    public EntryNode() {
    }

    public EntryNode(Integer id, Integer next) {
        super(id);

        this.next = next;
    }

    public Integer getNext() {
        return this.next;
    }

}
