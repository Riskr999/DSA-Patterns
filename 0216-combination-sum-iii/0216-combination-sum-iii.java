class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        sum(1,k,n,new ArrayList<>(),result);
        return result;
        
    }
    private void sum(int j,int k, int n, List<Integer> path, List<List<Integer>> result){

        if(k==0 && n ==0){
            result.add(new ArrayList<>(path));  
            return;
        }

        for(int i = j ; i<=9;i++){
            if(i>n){
                break;
            }
            path.add(i);
            sum(i+1,k-1,n-i,path,result);
            path.remove(path.size()-1);





        }

    }
}