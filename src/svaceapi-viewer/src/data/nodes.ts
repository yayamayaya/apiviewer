import type { Node, XYPosition } from "@xyflow/svelte"

export abstract class CFGNode implements Node {
    id: string;
    position: XYPosition;
    type: string;
    data: any;
    selectable?: boolean = true;

    constructor(id: string, type: string) {
        this.id = id;
        this.position = { x: 0, y: 0 };
        this.type = type;
        this.data = this;
    }
}

export class BlockNode extends CFGNode {
    instructions: string[] = [];
    prev!: number;
    next!: number;
}

export class EntryNode extends CFGNode {
    next!: number;
}

export class EndNode extends CFGNode {
    prev!: number;
}

export class SplitNode extends CFGNode {
    prev!: number;
    next!: number[];
    selectable?: boolean = false;
}

export class JoinNode extends CFGNode {
    prev!: number[];
    next!: number;
    selectable?: boolean = false;
}