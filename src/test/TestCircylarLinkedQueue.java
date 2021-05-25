import com.darknessvenom.data_structure.impl.CircylarLinkedQueue;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/25/21
 */
public class TestCircylarLinkedQueue {

    public static void main(String[] args) {
        CircylarLinkedQueue<String> queue = new CircylarLinkedQueue<>();
        queue.enqueue("李");
        queue.enqueue("艳");
        queue.enqueue("霞");
        queue.enqueue("傻");
        queue.enqueue("逼");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
