
class Solution {
    int count=0;
    void dfsGraph(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        count++;
        for (Integer it : adj.get(node)) {
            if (vis[it]==false) {
                dfsGraph(it, vis, adj);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        if(edges.length!=n-1) return false;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < vis.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] is : edges) {
            int r = is[0];
            int c = is[1];
            adj.get(c).add(r);
            adj.get(r).add(c);
        }
        dfsGraph(0, vis, adj);
        return count==n;
    }
}
