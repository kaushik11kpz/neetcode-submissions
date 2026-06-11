class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int target=0-nums[i];
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                if(set.contains(target-nums[j])){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target-nums[j]);
                    Collections.sort(list);
                    ans.add(list);
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
