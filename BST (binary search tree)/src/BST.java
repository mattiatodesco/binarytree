import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;
    private String alfabeto = "abcdefghijklmnopqrstuvwxyz";

    public BST(){
        this.root = null;
    }

    public void riempiAlbero(String str){
        for (int i = 0; i < str.length() -1; i++) {
            char lettera = str.charAt(i);
            for (int j = i+1; j < str.length(); j++) {
                if (lettera == str.charAt(j)){
                    System.out.println("Inserita stringa con lettere ripetute, albero non riempito");
                    return;
                }
            }
            
        }

        for (int i = 0; i < str.length(); i++) {
            boolean inserito = inserisciNodo(str.charAt(i), root);
            if (!inserito)
                System.out.println("Qualcosa storto a indice " + i);   
            else
                System.out.println("Inserito indice "+ i);   
        }
    }

    private boolean inserisciNodo(char lettera, Node root){

        if (this.root == null){
            this.root = new Node (lettera);
            return true;
        } else {
            if (alfabeto.indexOf(lettera) > alfabeto.indexOf(root.getData())){
                if (root.getRight() == null){
                    root.setRight(new Node(lettera));
                    return true;
                } else 
                    return inserisciNodo(lettera, root.getRight());
                
            } else if (alfabeto.indexOf(lettera) < alfabeto.indexOf(root.getData())){
                if (root.getLeft() == null){
                    root.setLeft(new Node(lettera));
                    return true;
                }
                 else 
                    return inserisciNodo(lettera, root.getLeft());
                
            }
        }

        return false;

    }

    public void breadth() {
        breadth(root); 
    }

    private void breadth(Node root) {
        if (root == null) return;

        // bisogna raccogliere tutti i nodi sullo stesso livello
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // toglie il primo nodo dalla coda
            Node cursor = queue.poll();
            System.out.print(cursor.getData());

            // aggiunge i figli del nodo corrente in coda
            if (cursor.getLeft() != null) {
                queue.add(cursor.getLeft());
            }
            if (cursor.getRight() != null) {
                queue.add(cursor.getRight());
            }
        }
    }

    public int nodeCounter(){
        return nodeCounter(root);
    }


    private int nodeCounter(Node root) {
        
        // exit clause + caso base
        if (root == null) return 0; 

        // chiamata ricorsiva
        return nodeCounter(root.getLeft()) + nodeCounter(root.getRight()) + 1;
    }
}
