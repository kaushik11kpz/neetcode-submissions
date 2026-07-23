class Solution {
    int j=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(i, new ArrayList<>());
        }
        for(int pre[] : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        j=numCourses-1;
        int state[] = new int[numCourses];
        int ans[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(i,graph,state,ans)){
                return new int[]{};
            }
        }
        return ans;
    }
    private boolean hasCycle(int source, List<List<Integer>> graph, int state[], int ans[]){
        state[source]=1;
        for(int nei : graph.get(source)){
            if(state[nei] == 1){
                return true;
            }
            if(state[nei] == 0 && hasCycle(nei,graph,state,ans)){
                return true;
            }
        }
        state[source]=2;
        ans[j--]=source;
        return false;
    }
}
