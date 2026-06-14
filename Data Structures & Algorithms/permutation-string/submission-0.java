class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        int left=0,right=0;
        while(right<s2.length()){
            map2.put(s2.charAt(right),map2.getOrDefault(s2.charAt(right),0)+1);
            if(right-left+1 > s1.length()){
                map2.put(s2.charAt(left),map2.get(s2.charAt(left))-1);
                if(map2.get(s2.charAt(left))==0){
                    map2.remove(s2.charAt(left));
                }
                left++;
            }
            if(map2.equals(map1)){
                return true;
            }    
            right++;
        }
        return false;
    }
}
