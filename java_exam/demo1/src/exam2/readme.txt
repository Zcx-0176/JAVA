4 4
0 2 0 4
0 1 3 0
0 1 0 0
1 0 0 0


3 3
0 1 0
0 0 0
2 0 0

-2 2
0 0
0 0

4 4
0 2 0 4
0 1 3 0
0 0 0 1
1 0 0 0


if(ti==m&&tj<n){
            while(tj<n && pcb[i][tj]==0){
                list.add(new int[]{i,tj});
                j = tj;
                tj = j+1;
            }
        }
        if(tj==n&&ti<m){
            while(ti<m && pcb[ti][j]==0){
                list.add(new int[]{ti,j});
                i = ti;
                ti = i+1;
            }
        }