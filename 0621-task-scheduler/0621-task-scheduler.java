class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;
        
        for(char c : tasks){
            frequency[c-'A']++;
            maxFreq = Math.max(maxFreq,frequency[c-'A']);
        }

        for(int freq: frequency){
            if(freq == maxFreq){
                maxFreqCount++;
            }
        }

        int chunk = maxFreq -1;
        int chunkSize = n - (maxFreqCount - 1);
        int idleSlot = chunk*chunkSize;

        int availableSlot = tasks.length - (maxFreq*maxFreqCount);
        int remainingSlot = Math.max(0,idleSlot-availableSlot);
        

        return tasks.length + remainingSlot;





    }
}