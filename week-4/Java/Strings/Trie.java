class Node{
    Node arr[];
    boolean isEnd;

    Node(){
        arr = new Node[26];
        this.isEnd = false;
    }

    boolean isEnd(){
        return this.isEnd;

    }

    void put(Node node, int index){
        arr[index] = node;
        return;
    }

    void setEnd(){
        isEnd = true;
    }

    boolean containsKey(int index){
        return arr[index] != null;
    }
}
class Trie {
    Node root ;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.containsKey(index) == false){
                node.arr[index] = new Node();
            }
            node = node.arr[index];
        }
        node.setEnd();
        return ;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.containsKey(index) == false){
                return false;
            }
            node = node.arr[index];
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
         Node node = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(node.containsKey(index) == false){
                return false;
            }
            node = node.arr[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */