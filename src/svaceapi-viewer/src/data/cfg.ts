import { Type } from "class-transformer";
import "reflect-metadata";

import { CFGNode, BlockNode, EntryNode, EndNode, SplitNode, JoinNode } from "./nodes";

export class CFG {
    @Type(() => CFGNode, {
        keepDiscriminatorProperty: true,
        discriminator: {
            property: "type",
            subTypes: [
                { value: EntryNode, name: "EntryNode" },
                { value: BlockNode, name: "BlockNode" },
                { value: SplitNode, name: "SplitNode" },
                { value: JoinNode, name: "JoinNode" },
                { value: EndNode, name: "EndNode" },
            ],
        },
    })
    allNodes: CFGNode[] = [];
}
