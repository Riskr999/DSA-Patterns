class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sum(0,candidates,result, new ArrayList<>(),target);
        return result;
    }
    public static void sum(int index,int[] candidates,List<List<Integer>> result,List<Integer> com,int remainingTarget){
        if(remainingTarget == 0){
            result.add(new ArrayList<>(com));
            return; 

        }
        if(remainingTarget<0||index == candidates.length){
            return;
        }
        com.add(candidates[index]);
        sum(index,candidates,result,com,remainingTarget - candidates[index]);
        
        com.remove(com.size()-1);
        sum(index+1,candidates,result,com,remainingTarget);
    }
}