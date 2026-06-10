class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> bucket[]=new ArrayList[nums.length+1];
        for(int i=0;i<bucket.length;i++){
            bucket[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }
        int res[]=new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0 && index < k;i--){
            for(int num : bucket[i]){
                res[index++]=num;
                if(index==k){
                    return res;
                }
            }
        }
        return res;
    }
}
