import com.darknessvenom.data_structure.impl.bag.RandomBag;
import com.darknessvenom.data_structure.interfaces.Bag;

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
public class TestBag {
    public static void main(String[] args) {
        Bag<Integer> bag = new RandomBag<>();

        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        bag.add(6);
        bag.add(7);
        bag.add(7);
        bag.add(7);
        bag.add(7);
        bag.add(7);
        bag.add(7);

        for(Integer i : bag) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        for(Integer i : bag) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        for(Integer i : bag) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        for(Integer i : bag) {
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

}
