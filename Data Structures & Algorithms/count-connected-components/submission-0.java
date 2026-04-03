class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> list1 = adjList.getOrDefault(u, new ArrayList<>());
            List<Integer> list2 = adjList.getOrDefault(v, new ArrayList<>());
            list1.add(v);
            list2.add(u);
            adjList.put(u, list1);
            adjList.put(v, list2);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        List<Integer> neighbors = adjList.getOrDefault(i, new ArrayList<>());
        for(int n : neighbors) {
            if(!visited[n]) 
                dfs(n, adjList, visited);
        }
    }
}
