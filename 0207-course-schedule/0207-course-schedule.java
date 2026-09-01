class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        for(int[] pair: prerequisites){

            int a = pair[0],b = pair[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int processedNodes = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            processedNodes++;
            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return processedNodes == numCourses;
    }
}