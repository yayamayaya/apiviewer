import type { Edge } from "@xyflow/svelte";
import { CFGNode, BlockNode, EntryNode, EndNode, SplitNode, JoinNode } from "../../data/nodes";

function mapEdges(nodes: CFGNode[]): Edge[] {
  return nodes
    .entries()
    .flatMap(([_, node]) => {
      function makeEdge(curr: string, next: string): Edge {
        return {
          id: `${curr}-${next}`,
          type: "clickable",
          source: curr,
          target: next,
        };
      }

      switch (true) {
        case node instanceof BlockNode:
        case node instanceof JoinNode:
        case node instanceof EntryNode:
          console.log("found");
          return [makeEdge(node.id, node.next.toString())];

        case node instanceof SplitNode:
          return node.next.map((next) => makeEdge(node.id, next.toString()));

        case node instanceof EndNode:
          return [];
      }

      return [];
    })
    .toArray();
}

export { mapEdges };
