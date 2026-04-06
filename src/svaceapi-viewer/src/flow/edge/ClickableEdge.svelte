<script lang="ts">
    import {
        BaseEdge,
        getSmoothStepPath,
        useSvelteFlow,
        type EdgeProps,
    } from "@xyflow/svelte";

    let {
        id,
        sourceX,
        sourceY,
        targetX,
        targetY,
        target,
        markerEnd,
    }: EdgeProps = $props();
    const { getNode, fitView } = useSvelteFlow();

    let [path] = $derived(
        getSmoothStepPath({
            sourceX,
            sourceY,
            targetX,
            targetY,
        }),
    );

    function focusEnd() {
        const node = getNode(target);
        if (node === undefined) {
            return;
        }
        fitView({ nodes: [node], duration: 300 });
    }
</script>

<BaseEdge {id} {path} onclick={focusEnd} {markerEnd} />
