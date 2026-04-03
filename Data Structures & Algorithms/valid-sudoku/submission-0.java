class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] == '.') continue;
                int val = board[i][j] - '0';
                String rowVal = "row = "+i+", val = "+val;
                String colVal = "col = "+j+", val = "+val;
                String inner = "row = "+ i/3 + ", col = "+ j/3 + ", val = " + val;
                if(set.contains(rowVal) || set.contains(colVal) || set.contains(inner)) return false;
                set.add(rowVal);
                set.add(colVal);
                set.add(inner);  
            }
        }
        return true;
    }
}
