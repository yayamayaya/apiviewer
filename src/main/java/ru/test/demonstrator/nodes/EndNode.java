package ru.test.demonstrator.nodes;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("END")
public class EndNode extends CfgNode{
    @Column(name = "previous_id")
    Integer prev;

    public EndNode() {
    }

    public EndNode(Integer id, Integer prev) {
        super(id);

        this.prev = prev;
    }

    public Integer getPrev()
    {
        return this.prev;
    }
}
