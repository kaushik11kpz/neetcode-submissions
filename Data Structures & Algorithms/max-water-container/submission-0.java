class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        for(int i=0;i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++){
                int minHeight=Math.min(heights[i],heights[j]);
                int width=j-i;
                max=Math.max(max,minHeight*width);
            }
        }
        return max;
    }
}
