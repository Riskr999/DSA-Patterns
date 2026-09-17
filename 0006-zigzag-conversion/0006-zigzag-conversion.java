class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows==1||s.length()<=numRows) return s;

        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i =0;i<numRows;i++){
            sb[i] = new StringBuilder(); 
        }
        int currRow = 0;
        int direction = -1;

        for(char c : s.toCharArray()){
            sb[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                direction = -direction; // Flip the direction
            }
            currRow += direction;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row :sb) {
            result.append(row);
        }

        return result.toString();

        
        
    }
}