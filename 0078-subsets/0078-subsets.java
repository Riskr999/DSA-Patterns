class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums,0,current,result);

        return result;
    }
    public static void backtrack(int[] nums,int index,List<Integer> current, List<List<Integer>> result){
        //base condititon
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(nums,index+1,current,result);

        current.remove(current.size()-1);
        backtrack(nums,index+1,current,result);


    }
}