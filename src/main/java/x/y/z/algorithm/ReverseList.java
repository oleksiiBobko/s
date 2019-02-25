package x.y.z.algorithm;

import java.util.List;

public class ReverseList<T> {

    public List<T> reverseList(List<T> list) {

        T item;

        for (int i = 0; i < list.size() / 2; i++) {
            item = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - 1 - i, item);

        }

        return list;

    }

}
