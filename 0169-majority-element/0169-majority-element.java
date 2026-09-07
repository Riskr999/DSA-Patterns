class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0;
        int count = 0;
        int n = nums.length;
        for(int ele: nums){
            if(count==0){
                candidate = ele;
                count=1;
            }
            else if(ele==candidate){
                count++;
            }
            else{
                count--;
            }
        }

        int actualCount=0;
        for(int num: nums){
            if(num==candidate){
                actualCount++;
            }
        }

        if(actualCount>(n/2)){
            return candidate;
        }

        return -1;
    }
}