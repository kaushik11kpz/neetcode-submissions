class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry.getKey());
        }
        int res[]=new int[k];
        int i=0;
        while(k!=0){
            res[i]=pq.poll();
            k--;
            i++;
        }
        return res;
    }
}
