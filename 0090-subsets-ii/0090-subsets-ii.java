class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void subset(int[] nums,int index, List<Integer> path, List<List<Integer>> result){
        
            result.add(new ArrayList<>(path));
            
        
        

        for(int i =index; i<nums.length; i++ ){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            subset(nums,i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}