<script lang="ts">
    import {
        SvelteFlow,
        Background,
        type Node,
        type Edge,
        type NodeTypes,
        useSvelteFlow,
        useNodesInitialized,
    } from "@xyflow/svelte";

    import "@xyflow/svelte/dist/style.css";

    import FlowControls from "./FlowControls.svelte";
    import ClickableEdge from "./edge/ClickableEdge.svelte";
    import EdgeMarkers from "./edge/EdgeMarkers.svelte";

    import { onMount } from "svelte";
    import { fetchData } from "../fetch/config_fetch";
    import { mapEdges } from "./edge/edge_mapping";
    import { getLayoutedElements } from "./layout";
    import { wait } from "./utils";

    import EntryNodeFlow from "./nodes/EntryNode.svelte";
    import ExitNodeFlow from "./nodes/EndNode.svelte";
    import SplitNodeFlow from "./nodes/SplitNode.svelte";
    import BlockNodeFlow from "./nodes/BlockNode.svelte";
    import JoinNodeFlow from "./nodes/JoinNode.svelte";

    const { fitView } = useSvelteFlow();

    const nodeTypes = {
        BlockNode: BlockNodeFlow,
        EntryNode: EntryNodeFlow,
        EndNode: ExitNodeFlow,
        SplitNode: SplitNodeFlow,
        JoinNode: JoinNodeFlow,
    } as unknown as NodeTypes;

    const edgeTypes = {
        clickable: ClickableEdge,
    };

    const defaultEdgeOptions = {
        type: "clickable",
        selectable: false,
        // Unset z-index on element to control it with style
        // This way hovered edge can be brought to front of
        // inactive to color it from start to end.
        // Unfortunately stuffing string in number
        // is the only way to hack this in
        zIndex: "" as unknown as number,
    };

    function applyLayout() {
        const layout = getLayoutedElements(nodes, edges);

        nodes = [...layout.nodes];
        edges = [...layout.edges];

        // First fit entire CFG, show it for a short time
        // and then zoom in to start node
        fitView()
            .then(() => wait(150))
            .then(() => {
                const startNode = nodes.find((node) => node.type == "start");
                if (startNode) {
                    fitView({ nodes: [startNode], duration: 1000 });
                }
            });
    }

    let nodes = $state.raw<Node[]>([]);
    let edges = $state.raw<Edge[]>([]);

    async function getGraphData() {
        const cfg_nodes = await fetchData();

        nodes = cfg_nodes;
        edges = mapEdges(cfg_nodes);

        applyLayout();
    }

    const initialized = useNodesInitialized();
    let once = true;

    $effect(() => {
        if (initialized.current && once) {
            applyLayout();
            once = false;
        }
    });

    onMount(getGraphData);
</script>

<SvelteFlow
    bind:nodes
    bind:edges
    {nodeTypes}
    {edgeTypes}
    {defaultEdgeOptions}
    oninit={applyLayout}
    fitView
    nodesConnectable={false}
    nodesDraggable={false}
    elevateNodesOnSelect={false}
    elevateEdgesOnSelect={false}
    proOptions={{ hideAttribution: true }}
>
    <EdgeMarkers />
    <FlowControls />
    <Background />
</SvelteFlow>
