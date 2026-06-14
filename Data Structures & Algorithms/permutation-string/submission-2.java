class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int target[]=new int[26];
        int window[]=new int[26];
        for(char c : s1.toCharArray()){
            target[c-'a']++;
        }
        int left=0,right=0;
        while(right<s2.length()){
            window[s2.charAt(right)-'a']++;
            if(right-left+1 > s1.length()){
                window[s2.charAt(left)-'a']--;
                left++;
            }
            if(check(window,target)){
                return true;
            }    
            right++;
        }
        return false;
    }
    private boolean check(int target[], int window[]){
        for(int i=0;i<26;i++){
            if(target[i] != window[i]){
                return false;
            }
        }
        return true;
    }
}
