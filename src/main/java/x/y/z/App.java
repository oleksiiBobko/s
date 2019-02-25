package x.y.z;

import x.y.z.tree.BSTree;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();

        tree.add(6);
        tree.add(10);
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.add(9);

        System.out.println(tree);

    }

}
