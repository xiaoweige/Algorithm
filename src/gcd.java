public class gcd{
//    欧几里得算法
    private static int gcd(int p, int q){
        if(q==0) return p;
        int r = p % q;
        return gcd(q,r);
    }
    public static void main(String[] args){
        gcd g1 = new gcd();
        int res = g1.gcd(219,129);
        System.out.println(res);
    }
}