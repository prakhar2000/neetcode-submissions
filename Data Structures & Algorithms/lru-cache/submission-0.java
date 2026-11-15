class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.val=val;
        this.key=key;

    }
    


}

class LRUCache {
    HashMap<Integer, Node> hm= new HashMap<>();
    int capacity;

    Node head= new Node(-1,-1);
    Node tail= new Node(-1, -1);


    public LRUCache(int capacity) {
        this.capacity= capacity;
        head.next= tail;
        tail.prev= head;
        
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }

        int res= hm.get(key).val;
        Node ansNode= hm.get(key);
        hm.remove(key);
        deleteNode(ansNode);
        addNode(ansNode);
        hm.put(key, ansNode);


        return res;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node toDelete= hm.get(key);
            deleteNode(toDelete);
            hm.remove(key);

        }

        if(hm.size()==capacity){
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode= new Node(key, value);
        addNode(newNode);
        hm.put(key, newNode);
        
    }
    public void addNode(Node newNode){

        Node oldnext= head.next;

        head.next= newNode;
        oldnext.prev= newNode;
        newNode.prev= head;
        newNode.next= oldnext;


    }
    public void deleteNode(Node toDelete){
        Node toDeleteprev= toDelete.prev;
        Node toDeletenext= toDelete.next;

        toDeletenext.prev= toDeleteprev;
        toDeleteprev.next= toDeletenext;


    }








}
