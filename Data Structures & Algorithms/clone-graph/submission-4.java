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
        Queue<Node> bfs = new LinkedList<>();
        bfs.offer(node);

        Node result = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, result);

        while (!bfs.isEmpty()) {
            Node curr = bfs.poll();
            Node newNode = map.get(curr.val);
            List<Node> newNeighbors = new ArrayList<>();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    Node newNeighbor = new Node(neighbor.val);
                    bfs.offer(neighbor);
                    map.put(neighbor.val, newNeighbor);
                    newNeighbors.add(newNeighbor);
                } else {
                    newNeighbors.add(map.get(neighbor.val));
                }
            }
            newNode.neighbors = newNeighbors;
        }
        return result;
    }
}