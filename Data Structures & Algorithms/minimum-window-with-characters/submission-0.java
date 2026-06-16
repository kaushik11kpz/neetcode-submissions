class Solution {
    public String minWindow(String s, String t) {
        String res="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String str = s.substring(i,j+1);
                if(containsAll(str,t)){
                    if(res.length()== 0 || str.length()<res.length()){
                        res=str;
                    }
                }
            }
        }
        return res;
    }
    private boolean containsAll(String str, String t){
        int freqStr[]=new int[128];
        int freqT[]=new int[128];

        for(char c:str.toCharArray()){
            freqStr[c]++;
        }
        for(char c:t.toCharArray()){
            freqT[c]++;
        }
        for(int i=0;i<128;i++){
            if(freqStr[i]<freqT[i]){
                return false;
            }
        }
        return true;
    }
}
