import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    
    private Node root;

    public BinaryTree() {

        this.root = null;
    }

    public BinaryTree(Node n) {

        this.root = n;
    }

    // depth-first
    public void preorder() {
        preorder(root);
    }

    /**
     * I nodi genitori sono visitati prima dei nodi figli
     * @param n nodo di partenza
     */
    private void preorder(Node n) {

        // exit clause
        if (n == null) return;

        System.out.print(n.getData()); 
        preorder(n.getLeft());
        preorder(n.getRight()); 
    }

    public void inorder() {
        inorder(root);
    }

    // in-order
    private void inorder(Node n) {

        // exit clause
        if (n == null) return;

        inorder(n.getLeft());
        System.out.print(n.getData()); 
        inorder(n.getRight()); 
    }

    public void postorder() {
        postorder(root);
    }

    // post-order
    private void postorder(Node n) {

        // exit clause
        if (n == null) return;

        postorder(n.getLeft());
        postorder(n.getRight()); 
        System.out.print(n.getData()); 
    }

    /** Conta quanti nodi sono presenti nel sotto-albero in input
     * @param root Nodo iniziale del sotto-albero
     * @return numero di nodi contati
     */
    public int nodeCounter(Node root){
        if (root == null) return 0;

        //chiamata ricorsiva
        return (nodeCounter(root.getLeft()) + nodeCounter(root.getRight()) + 1);
    }

    public int leavesCounter(Node root){
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;

        return (leavesCounter(root.getLeft()) + leavesCounter(root.getRight()));
    }

    public boolean searchNode(Node root, char letter){
        if (root == null) return false;
        
        if (root.getData() == letter) return true;

        return (searchNode(root.getLeft(), letter) || searchNode(root.getRight(), letter));
    }

    public int depth(Node root){
        // "figli" di una foglia 
        if (root == null) return -1;

        return Math.max(depth(root.getLeft()), depth(root.getRight())) +1;
    }

    public int calcolaLivello(Node n){
        return LivelloRec(n, this.root);
    }
    
    private int LivelloRec(Node n, Node cursor){
        if (cursor == null) return 0;
        if (cursor == n) return 1;

        int dx = LivelloRec(n, cursor.getRight());
        int sx = LivelloRec(n, cursor.getLeft());

        if (dx > 0) return dx +1;
        else if (sx > 0) return sx +1;
        else return 0;
    }

    public Node getAncestor(Node n){
        return getAncestor(root, n);
    }

    public Node getAncestor(Node current, Node n){
        // uscita
        if (current == null || n == null) return null;
        if (n == current) return null;
        
        // caso base
        if (current.getLeft() == n || current.getLeft() == n) return current;

        // chiamata ricorsiva
        Node left =  getAncestor(current.getLeft(), n);
        if (left != null) return left;

        Node right = getAncestor(current.getRight(), n);
        return right;

    }

    public List<Node> getPathList(Node start, Node end){
        if (start == null || end == null) return new ArrayList<Node>();

        ArrayList<Node> list = new ArrayList<>();

        boolean reverse = false;
        int startLvl = calcolaLivello(start);
        int endLvl = calcolaLivello(end);

        if (startLvl == 0 || endLvl == 0) return  new ArrayList<Node>();
        if (start != end && startLvl == endLvl) return  new ArrayList<Node>();

        if (startLvl < endLvl)
            getPathList(start, end, list);
        else {
            getPathList(end, start, list);
            reverse = true;
        }

        return reverse ? list : list.reversed();
        
    }

    private void getPathList(Node start, Node end, List<Node> list){
        if (start == end) {
            list.add(start);
            return;
        }

        if (end == root){
            list.clear();
            return;
        } 

        return getPathList(start, end);



    }




}