package ru.test.demonstrator;

import jakarta.persistence.*;
import ru.test.demonstrator.nodes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "CFG")
public class CFG {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "container_id")
    @OrderColumn(name = "node_index")
    CfgNode[] allNodes;

    @Transient
    CfgNode start;

    @Transient
    CfgNode end;

    public CFG() {}

    public CFG(CfgNode[] nodes) {
        this.allNodes = nodes;

        List<CfgNode> start = Arrays.stream(nodes).filter(node  -> node instanceof EntryNode).collect(Collectors.toList());
        if (start.size() != 1) {
            throw new IllegalArgumentException("several start in cfg");
        }
        this.start = start.getFirst();

        List<CfgNode> end = Arrays.stream(nodes).filter(node  -> node instanceof EndNode).collect(Collectors.toList());
        if (end.size() != 1) {
            throw new IllegalArgumentException("several end in cfg");
        }
        this.end = end.getFirst();
    }

    public CfgNode getStart() {
        return start;
    }

    public CfgNode getEnd() {
        return end;
    }

    public CfgNode[] getAllNodes() {
        return allNodes;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CFG{" +
                "allNodes=" + Arrays.toString(allNodes) +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
