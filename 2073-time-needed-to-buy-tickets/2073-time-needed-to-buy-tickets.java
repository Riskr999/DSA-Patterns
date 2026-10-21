class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            queue.offer(i);
        }
        int time = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            tickets[curr]--;
            time++;

            if(curr==k&&tickets[k]==0){
                return time;
            }

            if(tickets[curr]>0){
                queue.offer(curr);
            }


        }
        return time;
    }
}