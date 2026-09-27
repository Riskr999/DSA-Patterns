class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});

         int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currEff= curr[0], r = curr[1],c = curr[2];

            if(r==rows-1&&c==cols-1){
                return currEff;
            }


            if(currEff>dist[r][c]){
                continue;
            }
            for(int[] dir : direction){
                int nr = r+dir[0];
                int nc = c + dir[1];

                if(nr>=0&&nr<rows&&nc>=0&&nc<cols){
                    int edgeWeight = Math.abs(heights[r][c]-heights[nr][nc]);
                    int nextEffort = Math.max(currEff,edgeWeight);

                    if(nextEffort<dist[nr][nc]){
                        dist[nr][nc] = nextEffort;
                        pq.offer(new int[]{nextEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}