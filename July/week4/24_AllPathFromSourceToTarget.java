/*
        Given a directed, acyclic graph of N nodes.  
        Find all possible paths from node 0 to node N-1, and return them in any order.
        The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  
        graph[i] is a list of all nodes j for which the edge (i, j) exists.

        Example:
        Input      : [[1,2], [3], [3], []]
        Output     : [[0,1,3],[0,2,3]]
        Explanation: The graph looks like this:
        0--->1
        |    |
        v    v
        2--->3
        There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

        Note:
        - The number of nodes in the graph will be in the range [2, 15].
        - You can print different paths in any order, but you should keep the order of nodes inside one path.
*/
class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
                List<List<Integer>> list = new LinkedList();
                boolean[] visited = new boolean[graph.length];
                List<Integer> path = new LinkedList();
                path.add(0);
                dfs(graph, 0, visited, list, path);
                return list;
        }
        
        private void dfs(int[][] graph, int source, boolean[] visited, List<List<Integer>> list, List<Integer> path){
                visited[source] = true;
                if(source == graph.length - 1){
                        list.add(new LinkedList(path));
                        visited[source] = false;
                        return;
                }
                
                for(int dest : graph[source]){
                        if(!visited[dest]){
                                path.add(dest);
                                dfs(graph, dest, visited, list, path);
                                path.remove(path.size()-1);
                        }
                }
                visited[source] = false;
        }
}