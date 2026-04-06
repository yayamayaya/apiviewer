<script lang="ts">
    import {
        ControlButton,
        Controls,
        useNodes,
        useSvelteFlow,
    } from "@xyflow/svelte";
    import { Plus, Minus, CornersOut, ArrowDown } from "phosphor-svelte";
    import { findStartId } from "./utils";

    const { zoomIn, zoomOut, fitView } = useSvelteFlow();
    const nodes = useNodes();

    function plus() {
        zoomIn({ duration: 100 });
    }

    function minus() {
        zoomOut({ duration: 100 });
    }

    function fit() {
        fitView({ duration: 1000 });
    }

    function start() {
        let node = findStartId(nodes.current);
        if (node) {
            fitView({ nodes: [node], duration: 1000 });
        }
    }
</script>

<Controls showZoom={false} showFitView={false} showLock={false}>
    <ControlButton onclick={plus}><Plus size="100%" /></ControlButton>
    <ControlButton onclick={minus}><Minus size="100%" /></ControlButton>
    <ControlButton onclick={fit}><CornersOut size="100%" /></ControlButton>
    <ControlButton onclick={start}><ArrowDown size="100%" /></ControlButton>
</Controls>
