<script lang="ts">
    import { SvelteFlowProvider } from "@xyflow/svelte";
    import Flow from "./flow/Flow.svelte";
</script>

<div class="wrapper">
    <div class="svelteflowContainer">
        <SvelteFlowProvider>
            <Flow></Flow>
        </SvelteFlowProvider>
    </div>
    <!-- <div class="sidebarContainer">
        <Sidebar />
    </div> -->
</div>

<style>
    .wrapper {
        display: flex;
        .svelteflowContainer {
            display: inline-block;
            width: 100%;
            height: 100vh;
        }

        /*.sidebarContainer {
            display: inline-block;
            height: 100vh;
            width: 40rem;
            max-width: 40rem;
        }*/
    }
</style>
