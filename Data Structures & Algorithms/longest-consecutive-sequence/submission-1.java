class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currLength=1;
                while(set.contains(num+currLength)){
                    currLength++;
                }
                ans=Math.max(ans,currLength);
            }
        }
        return ans;
    }
}
