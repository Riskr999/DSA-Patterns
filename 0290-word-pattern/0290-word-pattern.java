class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;

        Map<Character,String> charToWords = new HashMap<>();
        Map<String,Character> wordsToChar = new HashMap<>();
        for(int i =0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(charToWords.containsKey(c) && !charToWords.get(c).equals(word)) return false;
            if(wordsToChar.containsKey(word)&& !wordsToChar.get(word).equals(c)) return false;

            charToWords.put(c,word);
            wordsToChar.put(word,c);
        }
        return true;
    }
}