class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 =0,count1=0;
        int candidate2=0,count2=0;

        for(int ele : nums){
            if(count1>0&&ele==candidate1){
                
                count1++;
            }
            else if(count2>0&& ele ==candidate2){
                count2++;
            }
            else if(count1==0){
                candidate1 = ele;
                count1=1;
            }
            else if(count2==0){
                candidate2 = ele;
                count2 =1;
            }
            else{
                count1--;
                count2--;
            }
        }

        int actualCount1=0,actualCount2=0;
        for(int num: nums){
            if(num==candidate1){
                actualCount1++;
            }
            else if(num==candidate2){
                actualCount2++;
            }
        }

        List<Integer> me = new ArrayList<>();
        if(actualCount1>(n/3)){
            me.add(candidate1);
        }
        if(actualCount2>(n/3)){
            me.add(candidate2);
        }
        return me;
    }
}