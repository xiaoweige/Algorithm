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
        HashMap<Long, Long> S = new HashMap<Long, Long>();//S是筛选法外层循环p后剩余的数列的和
        long r = (long) Math.sqrt(range);//r 是 range 的平方根，r向下取整
        long p = range / r; // p 是 筛选法的上界限 ，也是range 的平方根
        long[] V = new long[(int) (r + p - 1)];// v数组，最多 是 2r - 1 个 元素
        k = (int) (r + 1);//k = r + 1,k 是循环的上界限，i < k (k = r + 1)
        for (i = 1; i < k; i++) {
            V[i - 1] = range / i;
        }/*
        i = 1, p 从 1 开始循环，v[0] = range
        i = 2, p 从 2 开始循环，v[1] = range/2
        i = 3, p 从 3 开始循环，v[2] = range/3
        i = 4, p 从 4 开始循环，v[3] = range/4
        ...
        i = k(k=r),p从r开始循环，v[r] = range/r = r
        */
        int count = 1;//统计
        for (i = (int) (r + p - 2); i >= r; i--) {
            V[i] = count++;
        }
        /*
        i 从 2r-2 向下取整开始，到 i = r 截止, v 共有 r - 1 个element
        i = 2*r -2, v[2r-2] = 1
        i = 2r -3, v[2r-3] = 2
        ...
        i = r,     v[r] = r -1
         */
        // ArrayUtils.printArray(V);
        for (i = 0; i < V.length; i++) {
            S.put(V[i], ((long) V[i] * (V[i] + 1) / 2 - 1));
            /*
            i 从 0 到 r - 1 - 1
            S是 外层筛选法循环 v[i] 后， 得到首项为2 公差为一的等差数列，S 是 剩余的 数列 的 和，等差数列唄，缺首项 1
             */
        }
        //System.out.println(S);
        Long sp, p2;
        for (p = 2; p < r + 1; p++) {
            // p从 2 开始 到 r
            if (S.get(p) > S.get(p - 1)) {
                // S 是外层筛选循环p 后的和  >  S是外层筛选法循环 p-1 的和 ？？？
                sp = S.get(p - 1);//是，那 sp = S是外层筛选法循环 p-1 的和
                p2 = (long) (p * p);// p2 = p*p，如果循环p后，最大的素因子p的平方 比 剩余 数列最大的值 大
                for (i = 0; i < V.length; i++) {
                    //i 从 0 到 r-1
                    if (V[i] < p2) {//最大的素因子p的平方 比 剩余 数列最大的值 大???
                        break;//是， 就跳出循环
                    }
                    S.put(V[i], S.get(V[i]) - p * (S.get(V[i] / p) - sp));//
                    //外层V[i]循环后，剩余数列的和-  p *（剩余数列的和S 除以 p - 外层循环 v[i-1]后，剩余数列和sp）
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