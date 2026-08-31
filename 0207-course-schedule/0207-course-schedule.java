class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pair: prerequisites){
            int a = pair[0],b = pair[1];
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(hasCycle(i,adj,visited,inStack)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        for(int neighbor: adj.get(node)){
            if(inStack[neighbor]){
                return true;
            }
            if(visited[neighbor]){
                if(hasCycle(neighbor,adj,visited,inStack)){
                    return true;
                }
            }
        }
        inStack[node] = false;
        return false;
    }
}