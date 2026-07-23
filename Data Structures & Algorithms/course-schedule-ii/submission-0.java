class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(i, new ArrayList<>());
        }
        int indegree[] = new int[numCourses]; 
        for(int pre[] : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int k=0;
        int completedCourses=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[k++]=node;
            completedCourses++;
            for(int nei : graph.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    queue.add(nei);
                }
            }
        }
        return completedCourses == numCourses ? ans : new int[]{};
    }
}
