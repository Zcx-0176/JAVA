package exam2;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if(m<=0||n<=0){
            System.out.print(-1);
            return;
        }
        int[][] pcb = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pcb[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        list.add(new int[]{0,0});

        int ti = i+1;
        int tj = j+1;
        while(ti!=m&&tj!=n){
            while(ti<m && pcb[ti][j]==0){
                list.add(new int[]{ti,j});
                i = ti;
                ti = i+1;
            }

            while(tj<n && pcb[i][tj]==0){
                list.add(new int[]{i,tj});
                j = tj;
                tj = j+1;
            }
            if(ti<m&&tj<n&&pcb[ti][j]!=0&&pcb[i][tj]!=0){
                System.out.print(-1);
                break;
            }

        }


            int len = list.size();

            for(int k=0;k<len-2;k++){
                int[] t1 = list.get(k);
                int[] t2 = list.get(k+1);
                int[] t3 = list.get(k+2);

                if(t1[0]+1==t3[0]&&t1[1]+1==t3[1]){
                    count++;
                }
                if()
            }
            System.out.print(count);


    }
}
