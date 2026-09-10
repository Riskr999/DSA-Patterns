class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> wd = new HashSet<>();

        //traverse the list and add to the hashset
        
        for(String word : wordList){
            wd.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                String candidate  = queue.poll();
                if(candidate.equals(endWord)) return steps;

                char[] chars = candidate.toCharArray();
                for(int j = 0;j<chars.length;j++){
                    char oc = chars[j];
                    for(char c = 'a';c<='z';c++){
                        if(c==oc) continue;

                        chars[j] = c;
                        String newWord = new String(chars);

                        if(wd.contains(newWord)){
                            queue.offer(newWord);
                            wd.remove(newWord);
                        }
                    }
                    chars[j] = oc;

                }
                
            }

            steps++;

            
        }
        return 0;
    }
}