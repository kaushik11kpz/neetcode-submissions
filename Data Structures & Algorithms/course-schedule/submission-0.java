class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int completedCourses=0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            completedCourses++;
            for(int nei : graph.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    queue.add(nei);
                }
            }
        }
        return completedCourses == numCourses;
    }
}
