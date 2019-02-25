package x.y.z.algorithm;

public class SinglyLinkedListImpl<T> {

    private Node<T> head;

    public void add(T element) {

        Node<T> nd = new Node<T>();
        nd.setValue(element);

        Node<T> tmp = head;
        
        if (tmp == null) {
            head = nd;
            return;
        }

        while (true) {
            if (tmp.getNextRef() == null) {
                tmp.setNextRef(nd);
                break;
            } else {
                tmp = tmp.getNextRef();
            }
        }

    }

    public String toString() {
        Node<T> tmp = head;
        StringBuilder stringBuilder = new StringBuilder();

        while (tmp != null) {
            stringBuilder.append(tmp.getValue()).append(",");
            tmp = tmp.getNextRef();
        }

        return stringBuilder.toString();

    }

    public void reverse() {

        Node<T> prev = null;
        Node<T> next = null;

        while (head != null) {
            next = head.getNextRef();
            head.setNextRef(prev);
            prev = head;
            head = next;
        }

        head = prev;
    }

    public static void main(String a[]) {

        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);

        System.out.println(sl.toString());
        sl.reverse();
        System.out.println(sl.toString());
    }
}

class Node<T> {

    private T value;
    private Node<T> nextRef;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<T> ref) {
        this.nextRef = ref;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}