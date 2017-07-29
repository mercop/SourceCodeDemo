/**
 * Created by mercop on 2017/7/26.
 */

public class TimSortTest {
    public static void main(String[] args) {
        System.out.println(minRunLength(4));
        System.out.println(minRunLength(5));
        System.out.println(minRunLength(32));
    }

    private static int MIN_MERGE = 2;

    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // 只要不是 2的幂就会置 1
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

}
