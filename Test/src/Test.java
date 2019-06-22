import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fly
 * @date 2019/5/30
 */
public class Test {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        c1.add(1);
        c1.add(2);
        c1.add(3);

        c2.add(3);
        c2.add(4);
        c2.add(5);

        c1.retainAll(c2);
        System.out.println(c1.retainAll(c2));
        System.out.println(c1);
    }
}

