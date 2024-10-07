//User function Template for Java
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> li = new ArrayList();
        for(int i=0;i<V;i++){
            li.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            li.get(u).add(v);
            li.get(v).add(u);
        }
      return li;  
    }
}