class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        sum(0,candidates,target,new ArrayList<>(),result);
        return result;
    }
    private void sum(int index,int[] candidates,int target,List<Integer> path,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);

            sum(i+1,candidates,target- candidates[i],path, result);
            path.remove(path.size()-1);
                
        }
    }
}