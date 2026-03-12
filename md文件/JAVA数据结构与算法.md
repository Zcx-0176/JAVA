# <center><font face="仿宋" font color=bark>Java数据结构与算法 </font>
## <center><font face="楷体" size=5>zcx</font> 
## 一、练习平台
- 以下是数据结构与算法练习平台的官方链接：
- | 平台名称 | 官方链接 | 主要特点 |
  | :---: | :----: | :----: |
  | LeetCode（力扣）​|https://leetcode.cn/（中文版）、https://leetcode.com/（全球版）| 题目最全、社区最活跃，国内外大厂面试真题集中地，支持多语言，有周赛和模拟面试功能。|
  | LintCode（炼码）​| https://www.lintcode.com/|包含大量国内企业（如字节、腾讯）真题，部分题目可免费挑战。|
  | HackerRank​|https://www.hackerrank.com/|覆盖算法、数据结构及多种技能领域，提供结构化学习路径和证书挑战。|
  | 牛客网​|https://www.nowcoder.com/|国内IT求职综合社区，除算法题外，还有公司真题、面经、招聘信息等。|
  |VisuAlgo​|https://visualgo.net/zh（中文版）|数据结构和算法可视化网站，通过动画演示帮助理解复杂算法的执行过程。|
- 建议：先用力扣练，辅以牛客网刷企业真题，用visualgo可视化理解算法

## 二、简单排序
### 1. **Comparable接口**：
- 是java中用于定义对象自然顺序的接口，当一个类实现了Comparable接口，代表他的实例对象具有内在的、默认的比较和排序规则，**使得这个类的对象可以直接被用于Collections.sort()方法和Arrays.sort()方法排序，或者存入TreeSet、TreeMap等需要排序的集合中**
- **compareTo()方法：** **这是Comparable接口中定义的唯一抽象方法，作用是定义当前对象和指定对象o之间的大小。** 如：return this.age-o.getAge;  要是返回一个正数，表示当前对象的age值大于指定对象o的age值。同理，返回一个0，表示两者相等。返回一个负数，表示当前对象的age值小于指定对象o的age值。
- **排序算法(sort())会反复调用集合中对象的compareTo()方法，根据负、正、0来决定谁在前，谁在后**
- >package Comparable;
/**
  ==定义Student类，包含属性age,username
  使用Comparable接口，进行比较，比较的是Student对象的内容
  所以Comparable后面的参数是 Student
  实现这个接口，需要重写compareTo方法，方法的参数是Student
  可以按照年龄进行排序，即return this.age-student.getAge();
  如果按照姓名进行排序，即return this.username-student.getUsername();==
 */
public class Student **implements Comparable< Student >**{
    private  int age;
    private String username;
    public Student(int age,String username){
        this.age=age;
        this.username=username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
    **@Override
    public int compareTo(Student student){
        return this.age-student.getAge();
    }**
public static void main(String[] args){
        Student s1 = new Student(18,"张三");
        Student s2 = new Student(20,"李四");
        **int re1 = s1.compareTo(s2); 调用了重写的compareTo方法，这是s1和s2进行比较
        System.out.println(re1);  //输出-2**
    }
}

### 2. **冒泡排序**
- 最大的元素会像气泡一样浮到最上面。即数组的顶端
- 流程：**冒泡排序n个元素，总体外循环n-1次，内循环n-1-i次。** **内循环是从数组起点开始，依次比较相邻的两个元素，如果后一个元素比前一个元素小，则交换两者的位置。** 这样每次内循环一轮，最大的元素就会浮到数组的最后。所以说要想全部冒泡完，外循环要n-1次，因为第n-1次循环已经把第二个元素冒泡完了，只剩下第一个元素，不用继续循环了
- >public class bubble {
    public static void bubblesort(int[] arr){
        **int n = arr.length;  //数组的长度
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){  //如果前一个元素比后一个元素大，则交换两元素的位置
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }**
    }
}
public class main {
    public static void main(String[] args){
        int[] arr = {6,5,3,4,2,1};
        bubble b = new bubble();  //创建bubble对象
        b.bubblesort(arr);  //调用bubblesort方法
        System.out.println(Arrays.toString(arr));
    }
}
- 冒泡排序的时间复杂度是O(n^2)，注意，冒泡排序可以提前结束，声明一个标志位布尔变量flag即可，先初始化flag为true，当内循环没有继续交换时，就可以停止冒泡了。如果发生交换，则把flag置为false即可
- >public static void bubblesort2(int[] arr){
        int n = arr.length;
        **boolean flag = true;** 
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    **flag = false;**
                }
            }
            **if(flag){  //如果flag为true，则说明没有发生交换，则提前结束冒泡
                break;
            }**
        }
    }
### 3. **选择排序**
- 分为左侧已排序和右侧未排序，每次从右侧找到最小的元素，放到未排序元素的最后一个位置，总而言之升序排序
- 流程：初始化一开始，左侧已排序(为空)，右侧未排序(为数组)，每次从右侧找到最小的元素，将其与**未排序部分的第一个元素交换**，交换后，这个元素就属于左边了，缩小右侧边界以此类推，反复找最小的元素，直到未排序部分就剩一个元素，则排序完成。**外侧循环为n-1次，内层循环为n-1-i次，外层循环从i=0开始，内层循环从i+1开始遍历到n-1来循环找最小值，最后最小值的位置与i位置交换即可，内层循环一轮后，外层循环i++**
- >public class selection {
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            **int min = i;保存最小值(目前)索引**
            for(int j=i+1;j<n;j++){
                **if(arr[j]<arr[min]){
                    min = j;通过循环找到最小值索引**
                }**
            }
            **int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;根据索引进行位置交换**
        }
    }
    public static void main(String[] args){
        int[] arr = {6,5,4,3,2,1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

### 4. **插入排序**
- 也是分为左边已排序，右边未排序，初始索引为0的值为已排序的部分，从右边未排序中取出第一个数，找到合适位置插入到左侧，保证左侧仍然有序
- 流程：第一个元素被认为是有序的，从第二个元素开始，取出，然后**从后往前扫描左侧已排序的部分**，如果**要插入的数比扫描到的元素小，则交换两者位置**，直到找到要插入的元素比扫描到的元素大，或者没有扫描的元素了，这时候这个位置就是插入的位置。外层循环为n-1次，内层循环就是while，只不过有判断条件
- >public class insert {
    public static void insertsort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            **int key = arr[i]; 、、待插入的元素key**
            **int j=i-1; 、、左边已排序的元素的最后一个元素的索引**
            **while(j>=0 && arr[j]>key){ 
                、、如果左边已排序从后往前遍历完，亦或者当前元素比key小，就会停止循环，不然则交换两个元素位置
                arr[j+1] = arr[j]; 、、交换两者位置。不能使用i因为外循环i会固定，使用只能用j+1代指i，因为j会变
                arr[j] = key;
                j--;
            }**
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
## 三、高级排序
### 1.**希尔排序**
- 是另一种插入排序，又称缩小增量排序，是插入排序的一种更高效的版本
- 流程：**选定一个增长量h，按照增长量进行分组**，如h=5，数组有10个元素，则索引0跟5为1组，索引1跟6为1组，索引2跟7为1组，索引3跟8为1组，索引4跟9为1组，接下来分别对每一组的组内元素进行插入排序，先是组内循环，把组内最后的元素进行插入排序，然后是组间循环，每个组都要进行一遍组内循环，然后就是外层循环，即只要h>=1就继续循环
- **如何确定增长量h的初始值：h=n/2 ，n为数组的长度**
- **增长量h如何减小：h=h/2**
- **h比1小的时候就应该结束排序了**
- >public class shell {
    public static void shellsort(int[] arr){
        int n = arr.length;   // 获取数组长度
        int h = n/2;   // 初始增量设为数组长度的一半
        **外层循环，跟h的值有关
        while(h>=1){
            // 内层循环：增量h，分了好几个组，组间循环
            for(int i=h;i<n;i++){
                int key = arr[i];   // 保存每个组当前要插入的元素
                int j =i-h;  // j 指向同一组中前一个元素的位置
                // 每个组内有多个元素，需要吧key插入到组内合适的位置
                while(j>=0 && arr[j]>key){  //在组内循环，寻找插入位置
                    arr[j+h] = arr[j]; // 将arr[j]后移一个h的位置，即赋值给arr[j+h]
                    j -= h;  // j前移一个h的位置
                }
                arr[j+h] = key;  // 将key插入到正确位置
                //组内循环结束因为arr[j]小于key，并且arr[j+h]在之前的组内循环后移到arr[j+h+h]了
                //所以就把中间的arr[j+h]赋值为key，即插入的位置即可
            }
            h/=2;   // 缩小增量
        }**
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,9,7,6,8,5};
        shellsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

### 2. **归并排序**
- 基于分治法的高效排序算法
  - 分：对待排序数组递归的分成两半
  - 治：对每个子数组进行排序
  - 合：将已排序的子数组合并成一个完整的有序数组
- 流程：**先创建一个临时数组，然后调用递归函数，需要传入初始数组，左右边界索引，临时数组，这个递归函数先是==根据left<right来获取mid索引，必须是小于==，不能是小于等于，因为递归到最后左右数组各剩了1个，这不用排序，需要返回，==获取mid索引，为了把左数组递归拆分，和右数组递归拆分，然后调用合并函数==，传入初始数组，左中右索引，临时数组这些数据，这个函数内==还需要把临时数组(排好序的)赋值给初始数组==，这样一步一步从递归的最后往上就会逐步排好序**
- >import java.util.Arrays;
public class merge {
    **public static void mergesort(int[] arr){ //归并排序主程序
        int n = arr.length;
        int[] temp = new int[n];  // 创建临时数组
        mergeSorttt(arr,0,n-1,temp);  // 对arr数组进行归并排序
    }**
- > **//归并排序
    执行流程：先是一直递归左数组，一直递归到左数组为2个数，然后接着往下递归执行，递规左数组，因为就剩了1个数(left=right了)，所以左递归结束，开始右递归，同理只剩1个数，也结束，然后执行merge合并函数，把这两个数进行排序，然后递归返回上一级，上一级是3个数0-2索引，分为了左数组0-1和右数组2(因为该数组为10个数，即第一次递归分割分为0-4和5-9.第二次分割为0-2和3-4,5-7和8-9)，刚才返回的是左递归，现在该继续执行右递归，右数组是2索引，就一个数，无法继续进行右递归，所以继续执行，调用合并函数，把左数组0-1和右数组2合并.依次类推反复执行
    private static void mergeSorttt(int[] arr,int left,int right,int[] temp){
        if(==left<right==){
            int mid = (left+right)/2;  // 中间位置索引，为了把数组分为左右两半
            mergeSorttt(arr,left,mid,temp);  // 对左边数组进行递归拆分
            mergeSorttt(arr,mid+1,right,temp);  //对右边数组进行递归拆分
            merge(arr,left,mid,right,temp);   //上述递归完毕后执行，开始合并
        }
    }**
- >**//合并函数
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;  //左数组的索引
        int j = mid+1;  //右数组的索引
        int k = 0;  //临时数组一开始的索引
        while(i<=mid && j<=right){  // 比较左右数组的元素，将较小的元素放入临时数组中
            if(arr[i]<=arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }else if(arr[i]>arr[j]){
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){  // 将左边数组剩余的元素放入临时数组中
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=right){   // 将右边数组剩余的元素放入临时数组中
            temp[k] = arr[j];
            k++;
            j++;
        }
        k=0;   // 临时数组的索引重置，为了把arr重新赋值为有序
        while(left<=right){  // 将临时数组的元素赋给arr数组
            arr[left] = temp[k];
            left++;
            k++;
        }
    }**
- > **public static void main(String[] args) {
        int[] arr = {10,9,8,7,1,3,4,5,6,2};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
/**
 * 上述程序完整执行流程，直观显示：
 * mergesort(0,9)
 * ├── mergeSorttt(0,4)  // 左半部分
 * │   ├── mergeSorttt(0,2)
 * │   │   ├── mergeSorttt(0,1)
 * │   │   │   ├── mergeSorttt(0,0)  // 单个元素，返回
 * │   │   │   ├── mergeSorttt(1,1)  // 单个元素，返回
 * │   │   │   └── merge(0,0,1)      // 合并[10]和[9] → [9,10]
 * │   │   ├── mergeSorttt(2,2)      // 单个元素[8]
 * │   │   └── merge(0,1,2)          // 合并[9,10]和[8] → [8,9,10]
 * │   ├── mergeSorttt(3,4)
 * │   │   ├── mergeSorttt(3,3)      // 单个元素[7]
 * │   │   ├── mergeSorttt(4,4)      // 单个元素[1]
 * │   │   └── merge(3,3,4)          // 合并[7]和[1] → [1,7]
 * │   └── merge(0,2,4)              // 合并[8,9,10]和[1,7] → [1,7,8,9,10]
 * ├── mergeSorttt(5,9)  // 右半部分
 * │   ├── mergeSorttt(5,7)
 * │   │   ├── mergeSorttt(5,6)
 * │   │   │   ├── mergeSorttt(5,5)  // 单个元素[3]
 * │   │   │   ├── mergeSorttt(6,6)  // 单个元素[4]
 * │   │   │   └── merge(5,5,6)      // 合并[3]和[4] → [3,4]
 * │   │   ├── mergeSorttt(7,7)      // 单个元素[5]
 * │   │   └── merge(5,6,7)          // 合并[3,4]和[5] → [3,4,5]
 * │   ├── mergeSorttt(8,9)
 * │   │   ├── mergeSorttt(8,8)      // 单个元素[6]
 * │   │   ├── mergeSorttt(9,9)      // 单个元素[2]
 * │   │   └── merge(8,8,9)          // 合并[6]和[2] → [2,6]
 * │   └── merge(5,7,9)              // 合并[3,4,5]和[2,6] → [2,3,4,5,6]
 * └── merge(0,4,9)                  // 合并[1,7,8,9,10]和[2,3,4,5,6] → [1,2,3,4,5,6,7,8,9,10]
 