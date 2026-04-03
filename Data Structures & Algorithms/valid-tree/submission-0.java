class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> uList = adjList.getOrDefault(u, new ArrayList<>());
            uList.add(v);
            List<Integer> vList = adjList.getOrDefault(v, new ArrayList<>());
            vList.add(u);
            adjList.put(u,uList);
            adjList.put(v, vList);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(0, -1, visited, adjList) && visited.size() == n;
    }

    private boolean dfs(int curr, int prev, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        visited.add(curr);
        List<Integer> neighbors = adjList.getOrDefault(curr, new ArrayList<>());
        for(int neighbor : neighbors) {
            if(neighbor == prev) continue;
            if(visited.contains(neighbor)) return false;
            if(!dfs(neighbor, curr, visited, adjList)) return false;
        }
        return true;
    }

    

}
