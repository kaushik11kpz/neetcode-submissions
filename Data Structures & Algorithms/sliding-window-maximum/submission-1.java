class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        int left=0;
        for(int right=0;right<n;right++){
            heap.offer(right);
            if(right-left+1 > k){
                left++;
            }
            if(right-left+1 == k){
                while(heap.peek() < left){
                    heap.poll();
                }
                res[left]=nums[heap.peek()];
            }
        }
        return res;
    }
}
