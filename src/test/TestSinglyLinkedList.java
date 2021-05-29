import com.darknessvenom.data_structure.SinglyLinkedListNode;
import com.darknessvenom.data_structure.impl.SinglyLinkedList;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/29/21
 */
public class TestSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList<Double> list = new SinglyLinkedList<>();

        list.add(4.0);
        list.add(6.0);
        list.add(7.0);
        list.add(3.0);
        list.add(1.0);
        list.add(4.5);

        System.out.println(list);
        System.out.println(SinglyLinkedListNode.reverse(list.getHead()));
    }
}
