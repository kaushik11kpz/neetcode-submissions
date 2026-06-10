class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int count=1;
            int prev=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==prev+1){
                    prev=nums[j];
                    count++;
                }
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
