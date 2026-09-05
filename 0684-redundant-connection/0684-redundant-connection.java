class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      int n = edges.length;
      int[] parent = new int[n+1];
      for(int i=0;i<=n;i++) parent[i]=i;    

      for(int[] edge: edges){
        int u = edge[0], v = edge[1];
        int X = find(u,parent);
        int Y = find(v,parent);
        if(X==Y){
            return edge;
        }
        parent[X] = Y;  
      }
      return new int[0];
    }
    private int find(int x, int[] parent){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }
}