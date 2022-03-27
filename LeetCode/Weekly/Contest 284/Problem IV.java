class Solution {
    static class E {
        int node;
        long cost;
        E (int d, long c){
            node = d;
            cost = c;
        }
    }
    
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        ArrayList<ArrayList<E>> graph = new ArrayList<>();
        ArrayList<ArrayList<E>> revGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int cost = edge[2];
            
            graph.get(src).add(new E(dst, cost));
            revGraph.get(dst).add(new E(src, cost));
            
        }
        
        long[] cost1 = new long[n];
        long INF = Long.MAX_VALUE;
        Arrays.fill(cost1, INF);
        
        ArrayList<Integer> path1 = getPath(src1, dest, graph, cost1);
        
        long[] cost2 = new long[n];
        Arrays.fill(cost2, INF);
        ArrayList<Integer> path2 = getPath(src2, dest, graph, cost2);
        
        if (cost1[dest] == INF || cost2[dest] == INF)
            return -1;
        else {
            
            int lca = getLCA(path1, path2);
            
            long[] cost3 = new long[n];
            Arrays.fill(cost3, INF);
            getPath(dest, lca, revGraph, cost3);
            
            return cost1[lca] + cost2[lca] + cost3[lca];
            
            
        }
            
        
    }
    
    ArrayList<Integer> getPath(int src, int dest, ArrayList<ArrayList<E>> graph, long[] cost) {
        PriorityQueue<E> pq = new PriorityQueue<>((E a, E b) -> {
            if (a.cost == b.cost)return 0;
            else if (a.cost > b.cost) return 1;
            else return -1;
        });
        
        
        cost[src] = 0;
        pq.add(new E(src, 0));
        
        ArrayList<Integer> path = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int s = pq.peek().node;
            long scost = pq.peek().cost;
            pq.poll();
            
            if (scost > cost[s]) 
                continue;
            
            for (E adj : graph.get(s))
                if (cost[adj.node] > scost + adj.cost){
                    cost[adj.node] = scost + adj.cost;
                    pq.add(new E(adj.node, cost[adj.node]));
                }
            
            path.add(s);
            
            if (s==dest)
                break;
        }
        
        return path;
    }
    
    int getLCA(ArrayList<Integer> path1, ArrayList<Integer> path2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : path1)
            set.add(i);
        for (int i : path2)
            if (set.contains(i))
                return i;
        return -1;
    }
    
    
}
