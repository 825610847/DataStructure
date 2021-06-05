import com.darknessvenom.data_structure.impl.queue.LinkedListQueue;
import com.darknessvenom.data_structure.interfaces.Queue;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/5/21
 */
public class TestLinkedListQueue {

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedListQueue<>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.enqueue(6);
        q1.enqueue(7);

        Queue<Integer> q2 = new LinkedListQueue<>(q1);

        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();

        q2.enqueue(32);
        q2.enqueue(3);
        q2.enqueue(34);
        q2.enqueue(36);

        System.out.println(q1);
        System.out.println(q2);
    }
}
