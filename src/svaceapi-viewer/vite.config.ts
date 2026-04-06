import { defineConfig } from "vite";
import { svelte } from "@sveltejs/vite-plugin-svelte";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [svelte()],
  esbuild: {
    keepNames: true,
  },
  server: {
    proxy: {
      "/api": "http://localhost:8080",
    },
  },
});
