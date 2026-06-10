class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(!set.contains(board[i][j])){
                    set.add(board[i][j]);
                }else{
                    return false;
                }
            }
            set.clear();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]=='.') continue;
                if(!set.contains(board[j][i])){
                    set.add(board[j][i]);
                }else{
                    return false;
                }
            }
            set.clear();
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(board[k][l]=='.') continue;
                        if(!set.contains(board[k][l])){
                            set.add(board[k][l]);
                        }else{
                            return false;
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
