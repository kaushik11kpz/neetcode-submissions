class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> window = new HashMap<>();
        int left=0;
        int right=0;
        int formed=0;
        int required=need.size();
        int minLength=Integer.MAX_VALUE;
        int start=0;
        while(right<s.length()){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
                formed++;
            }
            while(formed==required){
                if(right-left+1 < minLength){
                    minLength=right-left+1;
                    start=left;
                }
                char ch = s.charAt(left);
                window.put(ch,window.get(ch)-1);
                if(need.containsKey(ch) && window.get(ch).intValue() < need.get(ch).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength==Integer.MAX_VALUE ? "" : s.substring(start,start+minLength);
    }
}
