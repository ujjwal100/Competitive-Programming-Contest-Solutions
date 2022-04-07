import java.io.*;
import java.util.*;

public class Solution {

    static final int INF = Integer.MAX_VALUE;
    static final int NINF = Integer.MIN_VALUE;
    static final long LINF = Long.MAX_VALUE;
    static final long LNINF = Long.MIN_VALUE;
    static Reader reader;
    static Writer writer;
    static PrintWriter out;
    static FastScanner fs;


    static void solve() {
        int T = fs.nextInt();
        for (int X = 1; X <= T; X++) {
            int N = (int) 1e6 + 10;
            int n = fs.nextInt();
            int[] s = fs.readArrayInt(n);
            int[] a = new int[N];
            for (int i =0; i < n;i++)a[s[i]]++;

            int max =0;
            for (int i =0; i < N; i++){
                if (a[i] > 0){
                    int d = i - max;
                    max += Math.min(d, a[i]);
                }
            }

            out.print("Case #"+ X +": " + max + "\n");

        }
    }





    public static void main(String[] args) {
        setReaderWriter();
        fs = new FastScanner();
//        testForTestcases();
         solve();
        out.close();
    }

    static void setReaderWriter() {
        writer = new OutputStreamWriter(System.out);
        out=new PrintWriter(writer);
    }

    static void testForTestcases() {
        int T = fs.nextInt();
        while (T-- > 0) {
            solve();
        }
    }

    static int getMax(int[] a) {
        int m = NINF;
        for(int i : a) m = Math.max(m, i);
        return m;
    }

    static int getMin(int[] a) {
        int m = INF;
        for(int i : a) m = Math.min(m, i);
        return m;
    }

    static int upperBound(int[] a, int l, int h, int val) {
        int ans = h + 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] > val) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return  ans;
    }

    static boolean isInteger(double val) {
        return !(val - (long)val > 0);
    }

    static void swap(int[] a , int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void swap(long[] a , int i , int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void swap(char[] a , int i , int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static long GCD(long a,long b)
    {
        if(b==0)
        {
            return a;
        }
        else return GCD(b,a%b );
    }

    static int opposite(int n, int x) {
        return (n-1)^x;
    }

    static Pair print(int a, int b) {
        out.println(a+" "+b);
        return new Pair(a, b);
    }

    static class Pair {
        int a, b;
        public Pair(int a, int b) {
            this.a=a;
            this.b=b;
        }
    }

    static final Random random=new Random();
    static final int mod=1_000_000_007;

    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static long add(long a, long b) {
        return (a+b)%mod;
    }
    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }
    static long mul(long a, long b) {
        return (a*b)%mod;
    }
    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }


    static class FastScanner {
        Scanner sc;

        public FastScanner() {
            sc = new Scanner(System.in);
        }


        String next() {
            return sc.next();
        }

        String nextLine()
        {
            return sc.nextLine();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArrayInt(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        long[] readArrayLong(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        char[] readCharArray() {
            return next().toCharArray();
        }
    }
}
