class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            List<Integer> list = adjList.getOrDefault(u, new ArrayList<>());
            list.add(v);
            adjList.put(u, list);
        }

        int[] indegree = new int[numCourses];
        for(int key : adjList.keySet()) {
            for(int val : adjList.get(key)) {
                indegree[val] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) queue.offer(i);
        }
        List<Integer> orderedList = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.remove();
            orderedList.add(course);
            List<Integer> courseNeighbors = adjList.getOrDefault(course, new ArrayList<>());
            for(int neighbor : courseNeighbors) {
                indegree[neighbor] -= 1;
                if(indegree[neighbor] == 0) 
                    queue.offer(neighbor);
            }
        }
        if(orderedList.size() != numCourses) return new int[0];
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            res[i] = orderedList.get(i);
        }
        return res;
    }
}
