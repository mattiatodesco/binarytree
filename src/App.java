public class App {
    public static void main(String[] args) throws Exception {
        
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        Node i = new Node('I');

        BinaryTree tree = new BinaryTree(a);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        e.setLeft(g);
        e.setRight(h);
        c.setRight(f);
        f.setLeft(i); 

        System.out.println("Preorder");
        tree.preorder();
        System.out.println(""); 
        System.out.println("Inorder");
        tree.inorder();
        System.out.println(""); 
        System.out.println("Postorder");
        tree.postorder();
        System.out.println(""); 

        System.out.println("Numero di nodi: " + tree.nodeCounter(a));
        System.out.println("Numero di foglie: " + tree.leavesCounter(a));
        System.out.println("L è presente? " + tree.searchNode(a, 'L'));
        System.out.println("H è presente? " + tree.searchNode(a, 'H'));
        System.out.println("Profondità: " + tree.depth(a));

        System.out.println("Livello di g: " + tree.calcolaLivello(g));
        System.out.println("Livello di b: " + tree.calcolaLivello(b));
        System.out.println("Livello di f: " + tree.calcolaLivello(f));

        System.out.println("Genitore di g: " + tree.getAncestor(g).getData());

        System.out.println("discesa: " + tree.getPathList(a, f));
        System.out.println("salita: " + tree.getPathList(f, a));
    }
}