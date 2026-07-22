class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;
        
        for(char c: tasks){
            frequency[c-'A']++;
            maxFreq = Math.max(maxFreq,frequency[c-'A']);
        }

        for(int i : frequency){
            if(i == maxFreq){
                maxFreqCount++;
            }
        }


        int slot = (maxFreq-1)*(n+1)+maxFreqCount;
        return Math.max(tasks.length,slot);




    }
}