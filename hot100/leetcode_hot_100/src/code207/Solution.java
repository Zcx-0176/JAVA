package code207;
/*
    课程表
    就是图的环检测
    首先构成图，然后使用dfs

    如何构建图：使用邻接表存储
    即整体是一个大列表，大列表下有一堆小列表，每个小列表代表的是当前节点指向的其他所有节点
    比如要修3门课程
    那么就会给出0,1,2  三门课程
    比如要想修1，需要先修0  即0指向1
    要想修2，需要先修1   即1指向2
    要想修2 需要先修0   即0 指向2
    先在大列表下创建三个空列表
    表示0课程指向的节点列表
    1课程指向的节点列表
    2课程指向的节点列表
    然后根据上述整好的指向逻辑，把对应节点存储进对应列表
    如，把1和2存储进0那个小列表
    把2存储进1那个小列表

    然后就是dfs遍历这些列表
    先标记当前访问的节点为1，
    先说明：未访问标记为0，正在访问的节点为1，访问完成的节点为2(已回溯完成)
    所以需要一个标记数组和一个判断是否成环的布尔值
    如果在访问过程中遇到了节点为1的那么
    说明成环了，返回false
    如果遇到2的节点。不用管


    具体如何实现？
    首先定义布尔值valid为全局变量，初始化为true
    然后dfs函数传入list，visited，和当前节点current，实际上这个current就是主函数内for循环中的i，并且是visited[i]==0的i

    然后这是遍历到当前节点了，首先visited[current]需要赋值为1，表示正在遍历
    然后for循环list.get(current)这个列表
    即遍历当前节点的邻接表的每个数
    如果这个数在visited中是0
    则继续dfs

    如果这个数在visited是1
    则证明两者成环，因为如果0->1  1->0，就是这种情况时成环
    则把valid赋值为false，直接return

    如果这个数是在visited是2
    什么也不用干

    在for循环外，赋值visited[current]为2
    因为这是表示，当前节点的邻接表都遍历完了，那么当前节点就处于完成态，应置为2



    当然这么执行后其实就是拓扑排序，为2的才加入到栈里，后进先出，先进去的是先修课程
    当然在此题目中栈就是一个保存一种拓扑排序的结果
    所以没必要加入栈，栈就没写
 */
import java.util.*;
public class Solution {
    private boolean valid;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for(int i=0;i<n;i++){
            int[] temp = prerequisites[i];
            int child = temp[0];
            int pre = temp[1];
            list.get(pre).add(child);
        }
        valid = true;
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                dfs(list,visited,i);
            }
        }
        return valid;

    }

    public void dfs(List<List<Integer>> list,int[] visited,int current){
        visited[current] = 1;
        int n = list.get(current).size();
        for(int i=0;i<n;i++){
            int next = list.get(current).get(i);
            if(visited[next]==0){
                dfs(list,visited,next);
            }else if(visited[next]==1){
                valid = false;
                return;
            }
        }
        visited[current] = 2;
    }
}
