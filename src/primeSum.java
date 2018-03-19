
import java.util.HashMap;

import static java.lang.System.currentTimeMillis;

public class primeSum {
    /*
     * sum: 24739512092254535 time:904 ms
     * 埃拉托斯特尼筛法
     *
     */


    public static long primeS(final long range) {
        int i, k;
        HashMap<Long, Long> S = new HashMap<Long, Long>();
        long r = (long) Math.sqrt(range);
        long p = range / r;
        long[] V = new long[(int) (r + p - 1)];
        k = (int) (r + 1);
        for (i = 1; i < k; i++) {
            V[i - 1] = range / i;
        }
        int count = 1;
        for (i = (int) (r + p - 2); i >= r; i--) {
            V[i] = count++;
        }
        // ArrayUtils.printArray(V);
        for (i = 0; i < V.length; i++) {
            S.put(V[i], ((long) V[i] * (V[i] + 1) / 2 - 1));
        }
        //System.out.println(S);
        Long sp, p2;
        for (p = 2; p < r + 1; p++) {
            if (S.get(p) > S.get(p - 1)) {
                sp = S.get(p - 1);
                p2 = (long) (p * p);
                for (i = 0; i < V.length; i++) {
                    if (V[i] < p2) {
                        break;
                    }
                    S.put(V[i], S.get(V[i]) - p * (S.get(V[i] / p) - sp));
                }
            }
        }
        return S.get(range);


    }

    public static void main(String args[]) {
        long startTime = currentTimeMillis();

        long i = primeS(Integer.MAX_VALUE);
        /*long range=1000000000;
        long i= primeS(range);*/


        System.out.println(i);
        long endTime = currentTimeMillis();

        System.out.println("当前程序耗时：" + (endTime - startTime) + "ms");

    }


}