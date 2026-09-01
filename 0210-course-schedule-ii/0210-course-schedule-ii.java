class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int processedNodes = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int node  = queue.poll();
            processedNodes++;
            result.add(node);
            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        if(processedNodes==numCourses){
            
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[0];
    }
}