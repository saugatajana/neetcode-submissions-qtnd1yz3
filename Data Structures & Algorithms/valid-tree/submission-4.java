class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Build adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> uList = adjList.getOrDefault(u, new ArrayList<>());
            uList.add(v);
            List<Integer> vList = adjList.getOrDefault(v, new ArrayList<>());
            vList.add(u);
            adjList.put(u, uList);
            adjList.put(v, vList);
        }
        Set<Integer> visited = new HashSet<>();
        if(!dfs(0, adjList, visited, -1))
            return false;
        
        return visited.size()==n;
    }

    public boolean dfs(int curr, Map<Integer, List<Integer>> adjList, Set<Integer> visited, int parent) {
        visited.add(curr);
        List<Integer> neighbors = adjList.getOrDefault(curr, new ArrayList<>());
        for(int neighbor : neighbors) {
            if(!visited.contains(neighbor)) {
                if(!dfs(neighbor, adjList, visited, curr)) 
                    return false;
            } else if(parent != neighbor) 
                return false;
        }
        return true;
    }
}
