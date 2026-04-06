package ru.test.demonstrator.nodes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import ru.test.demonstrator.CFG;

@Entity
@Table(name = "NODES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "node_type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
public class CfgNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public CfgNode() {}

    CfgNode(int num) {
    }

    public Integer getId() {
        return this.id;
    }
}
