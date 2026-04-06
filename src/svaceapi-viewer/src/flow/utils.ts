import type { Node } from "@xyflow/svelte";

function wait(ms: number): Promise<void> {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

function findStartId(nodes: Node[]): Node | undefined {
  return nodes.find((node) => node.type === "EntryNode");
}

export { wait, findStartId };
