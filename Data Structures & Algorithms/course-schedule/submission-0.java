class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int dest = prerequisite[0];
            List<Integer> list = adjList.getOrDefault(source, new ArrayList<>());
            list.add(dest);
            adjList.put(source, list);
        }
        //build the indegree
        int[] indegree = new int[numCourses];
        for(List<Integer> list : adjList.values()) {
            for(int course : list) {
                indegree[course] += 1;
            }
        }

        //iterate
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int c = queue.poll();
            count++;
            for(int neighbor : adjList.getOrDefault(c, new ArrayList<>())) {
                indegree[neighbor] -= 1;
                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return count == numCourses;
    }
}
