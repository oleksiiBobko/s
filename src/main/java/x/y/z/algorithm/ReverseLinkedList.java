package x.y.z.algorithm;

import java.util.LinkedList;

public class ReverseLinkedList<T> {

    public LinkedList<T> reverseList(LinkedList<T> list) {

        list.addFirst(list.removeLast());

        for (int i = 0; i < getSize(list); i++) {
            T last = list.removeLast();
            list.add(1, last);

        }

        return list;

    }

    private int getSize(LinkedList<T> list) {
        return list.size();
    }


}
