
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis [] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); //add st index element
        vis[0] = true; //mark as visited
        
        while(!q.isEmpty()){
            Integer node = q.poll(); //take out first ele
            bfs.add(node);
            
            for(Integer it: adj.get(node) ){ //check for neighbours
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        
        return bfs;
    }
}