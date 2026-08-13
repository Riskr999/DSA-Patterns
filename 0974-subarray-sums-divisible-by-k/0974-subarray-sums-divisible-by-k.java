class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> remainderMap = new HashMap<>();


        int prefixSum = 0;
        int count = 0;

        remainderMap.put(0,1);

        for(int num:  nums){
            prefixSum += num;
            int rem = ((prefixSum % k)+k) % k ;
            if(remainderMap.containsKey(rem)){
                count+=remainderMap.get(rem);
            }
            remainderMap.put(rem,remainderMap.getOrDefault(rem,0)+1);
        }

        return count;

    }
    
}