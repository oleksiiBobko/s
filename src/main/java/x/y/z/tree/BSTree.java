package x.y.z.tree;

public class BSTree<T> {

    private BSTreeNode root = null;

    public boolean add(T value) {

        BSTreeNode newNode = new BSTreeNode(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        addValue(root, newNode);

        return true;

    }

    private void addValue(BSTreeNode root, BSTreeNode newNode) {
        long diff = root.compare(newNode.getHash());
        if (diff < 0) {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
            } else {
                addValue(root.getLeft(), newNode);
            }
        } else if (diff > 0) {
            if (root.getRight() == null) {
                root.setRight(newNode);
            } else {
                addValue(root.getRight(), newNode);
            }
        } else if (diff == 0) {
            throw new IllegalArgumentException("hashCode collision = " + newNode.getHash());
        }
    }

    class BSTreeNode {

        private BSTreeNode left;

        private BSTreeNode right;

        private T value;

        private long hash;

        public BSTreeNode(T value) {
            setValue(value);
        }

        public T getValue() {
            return value;

        }

        public void setValue(T value) {
            this.value = value;
            this.hash = value.hashCode();

        }

        public BSTreeNode getLeft() {
            return left;

        }

        public void setLeft(BSTreeNode left) {
            this.left = left;
        }

        public BSTreeNode getRight() {
            return right;

        }

        public void setRight(BSTreeNode right) {
            this.right = right;
        }

        public long compare(long hash1) {
            return hash - hash1;
        }

        public long getHash() {
            return hash;
        }

    }

}
