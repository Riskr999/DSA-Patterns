class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,visited, new ArrayList<>(),ans);
        return ans;
        
    }
    public void backtrack(int[] nums,boolean[] vis,List<Integer> path, List<List<Integer>> result){
        if(path.size() == nums.length){
           
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i= 0;i<nums.length;i++){
            if(vis[i]) continue;

            if(i>0&&nums[i] == nums[i-1]&& !vis[i-1]){
                continue;
                

            }
            vis[i] = true;
            path.add(nums[i]);

            backtrack(nums,vis,path,result);
            vis[i] = false;

            path.remove(path.size()-1);
        }

    }
}