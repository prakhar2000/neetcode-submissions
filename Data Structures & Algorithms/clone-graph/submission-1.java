/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // bfs
        HashMap<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        hm.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            for (Node n : temp.neighbors) {
                if (!hm.containsKey(n)) {
                    hm.put(n, new Node(n.val));
                    q.offer(n);
                }

                hm.get(temp).neighbors.add(hm.get(n));
            }
        }
        return hm.get(node);
        // dfs
        //  if(hm.containsKey(node)){
        //      return hm.get(node);
        //  }

        // Node copy= new Node(node.val);
        // hm.put(node, copy);

        // for(Node n: node.neighbors){
        //     copy.neighbors.add(cloneGraph(n));
        // }

        // return copy;
    }
}