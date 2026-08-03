class Solution {
    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> as = new ArrayList<>();
            permutation(nums,as,0);
            return as;
           
       
    }
    private void permutation(int[] nums, List<List<Integer>> ans, int i){
        
        if(i == nums.length){
            List<Integer> currentnum = new ArrayList<>();
            for(int num : nums){
                currentnum.add(num);
            }
            ans.add(currentnum);
            return;
        }

        for(int j =i;j<nums.length;j++){
            swap(nums,i,j);
            permutation(nums,ans,i+1);
            swap(nums,i,j);

        }
        
    }
   
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}