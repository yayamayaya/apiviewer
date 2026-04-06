<script lang="ts">
    import { Handle, Position, type NodeProps } from "@xyflow/svelte";

    import type { BlockNode } from "../../data/nodes.js";

    let { data }: NodeProps = $props();

    const node = data as unknown as BlockNode;
</script>

<Handle type="target" position={Position.Top} class={"invisible"} />
<div class="instructions">
    {#each node.instructions as instr}<p>{instr}</p>{/each}
</div>
<Handle type="source" position={Position.Bottom} class={"invisible"} />
