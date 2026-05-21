class Solution {

    class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]); // path compression
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return false; // already same component

            parent[pu] = pv;
            return true;
        }
    }

    public int countComponents(int n, int[][] edges) {

        DisjointSet ds = new DisjointSet(n);
        int components = n;

        for (int[] e : edges) {
            if (ds.union(e[0], e[1])) {
                components--;  // only when union happens
            }
        }

        return components;
    }
}