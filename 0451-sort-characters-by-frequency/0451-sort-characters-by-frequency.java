class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> counts = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] buckets = new List[n+1];
        for(char c : counts.keySet()){
            int freq = counts.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        for(int i=n;i>0;i-- ){
            if(buckets[i]!=null){
                for(char c : buckets[i]){
                    for(int j=0;j<i;j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
        
    

        
    }
}