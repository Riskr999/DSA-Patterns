class Solution {
    public int findCircleNum(int[][] isConnected){
       List<List<Integer>> adj =  maxToList(isConnected);
       int numNodes = isConnected.length;

        int[] vis = new int[numNodes];
        int cnt = 0;
        for(int i  =0;i<numNodes;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;



        
    }
    public  void dfs(int current, List<List<Integer>> adj, int[] vis ){
        vis[current] = 1;
        

        for(int neighbour : adj.get(current)){
            if(vis[neighbour]==0){
                dfs(neighbour,adj,vis);
            }
        }

    }
    public List<List<Integer>> maxToList(int[][] matrix){
        int numNodes = matrix.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i =0;i<numNodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i =0;i<numNodes; i++){
            for(int j=0; j<numNodes;j++){
                if(matrix[i][j]==1){
                    adjList.get(i).add(j);
                }
            }
        }

        return adjList;
        
    }
}