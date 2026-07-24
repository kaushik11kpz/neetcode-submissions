class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int m=text1.length();
       int n=text2.length();
       int memo[][]=new int[m][n];
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
       }
       return helper(text1,text2,m-1,n-1,memo); 
    }
    private int helper(String t1, String t2, int i, int j, int memo[][]){
        if(i<0 || j<0){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(t1.charAt(i) == t2.charAt(j)){
            memo[i][j]= 1+helper(t1,t2,i-1,j-1,memo);
        }else{
            memo[i][j]= Math.max(helper(t1,t2,i,j-1,memo),helper(t1,t2,i-1,j,memo));
        }
        return memo[i][j];
    }
}
