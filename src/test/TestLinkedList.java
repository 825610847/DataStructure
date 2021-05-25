import com.darknessvenom.data_structure.impl.LinkedList;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/24/21
 */
public class TestLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(11);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(null);
        linkedList.add(6);
        linkedList.add(8);
        linkedList.add(null);
        linkedList.add(2);

        System.out.println(LinkedList.display(linkedList));
        System.out.println(LinkedList.remove(linkedList, 2));
        System.out.println(LinkedList.display(linkedList));

        System.out.println();

    }
}
