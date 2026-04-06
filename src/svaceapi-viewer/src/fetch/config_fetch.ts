import { plainToInstance } from "class-transformer";

import { CFG } from "../data/cfg";
import type { CFGNode } from "../data/nodes";

async function fetchData(): Promise<CFGNode[]> {
  const res = await fetch("/api/cfgs");
  const rawGraphs = await res.json();

  for (const graph of rawGraphs) {
    const cfg = plainToInstance(CFG, graph);
    return cfg.allNodes;
  }

  return [];
}

export { fetchData };
