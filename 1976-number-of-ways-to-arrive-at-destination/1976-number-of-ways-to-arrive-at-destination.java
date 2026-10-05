class Solution {
    private static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
         
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0],v = road[1], time = road[2];
            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u, time});
        }
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        Arrays.fill(ways,0);
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
           long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if(d>dist[node]) continue;

            
            for(int[] edge : adj.get(node)){
                int neighbor = edge[0],w = edge[1];
                long candidateDist = d+w;
                if(candidateDist<dist[neighbor]){
                    dist[neighbor] = candidateDist;
                    ways[neighbor] = ways[node];
                    pq.offer(new long[]{neighbor,candidateDist});

                }
                else if(d+w == dist[neighbor]){
                     ways[neighbor] = (ways[neighbor] + ways[node]) % MOD;
                }
                
            }

        }
        return (int)ways[n-1];


    }
}