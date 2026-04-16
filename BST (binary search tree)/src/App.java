public class App {
    public static void main(String[] args) throws Exception {
        BST albero = new BST();

        albero.riempiAlbero("stronzo");
        albero.breadth();

        System.out.println();
        System.out.println(albero.nodeCounter());
    }
}
