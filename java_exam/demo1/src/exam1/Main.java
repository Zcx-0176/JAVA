package exam1;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        long E = sc.nextLong();
        sc.nextLine();
        String[] d = sc.nextLine().split(" ");
        String[] r = sc.nextLine().split(" ");
        int n = d.length;
        long[] damage = new long[n];
        long[] reward = new long[n];
        for(int i=0;i<n;i++){
            damage[i] = Long.parseLong(d[i]);
            reward[i] = Long.parseLong(r[i]);
        }


        long maxc = 0;
        for(int i=0;i<n;i++){
            long count = 0;
            long temp = E;
            for(int j=i;j<n;j++){
                if(temp<damage[j]){
                    continue;
                }
                temp = temp-damage[j]+reward[j];
                count++;
            }
            maxc = Math.max(count,maxc);
        }
        System.out.print(maxc);
    }
}
