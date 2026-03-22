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
- 流程：**先创建一个临时数组，然后调用递归函数，需要传入初始数组，左右边界索引，临时数组，这个递归函数先是==根据left<right来获取mid索引，必须是小于==，不能是小于等于，因为递归到最后左右数组各剩了1个，这不用排序，需要返回，==获取mid索引，为了把左数组递归拆分，和右数组递归拆分，然后调用合并函数==，传入初始数组，左中右索引，临时数组这些数据，这个函数内==还需要把临时数组(排好序的)赋值给初始数组==，这样一步一步从递归的最后往上就会逐步排好序。时间复杂度O(nlogn)，合并需要O(n)，递归每次分割成两半需要O(logn)**
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

### 3. **快速排序**
- 对冒泡排序的一种改进，从数组中选择一个元素作为基准元素，把数组分为两部分，比基准小的放左边，比基准大的放右边，递归的进行上述操作
- 流程：**先是创建一个递归函数，里面要保证left<right，并且先调用获取最后索引的函数，再进行左递归和右递归**
- >**public class quicksort {
    public static void quick(int[] arr){  // 创建一个快速排序函数，用于主函数嗲用，这个调用了递归函数
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr,int left,int right){  // 创建一个递归函数，用于进行排序和递归
        if(left<right){  // 判断left<right
            int pivot = divide(arr,left,right);  // 获取中标志引，即调用获取索引和排序函数
            quickSort(arr,left,pivot-1); // 左递归
            quickSort(arr,pivot+1,right); // 右递归
        }
    }
    public static int divide(int[] arr,int left,int right){  // 创建一个函数，用于获取标志索引和排序
        int pivot = arr[right]; // 选择最右元素作为基准值
        int i = left-1; // i 指向小于等于 pivot 区域的最后一个元素
        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){ // 当前元素 <= pivot
                i++; // 扩展小于等于区域
                swap(arr, i, j); // 将 arr[j] 交换到小于等于区域
            }
        }
        swap(arr, i + 1, right); // 将 pivot 放到正确位置
        return i + 1;  // 返回 pivot 的最终位置
    }
    private static void swap(int[] arr, int i, int j){  // 创建一个交换函数
        if(i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public static void main(String[] args) {  
        int[] arr = {5,4,3,2,1,10,8,9,7,6};
        quick(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}**

 
## 四、线性表
- **前驱元素**：当前元素前面的元素
- **后继元素**：当前元素后面的元素
- **线性表的特征**：数据元素之间具有一对一的逻辑关系
   - **头结点**：第一个元素，其没有前驱
   - **尾结点**：最后一个元素，其没有后继
   - 除了头结点、尾结点，其他元素都有前驱和后继
- **线性表的分类**：顺序表和链表
### 1. **顺序表**
- 以数组形式保存的线性表
-  **(1)数组**：长度固定、内存连续、可存储基本类型和对象、访问速度极快 (O(1))。
- **数组创建方式**
- | 创建方式 | 描述 |
  | :---: | :---: |
  | int[] arr = new int[5]; | 创建长度为5的数组 |
  | int[] arr = {1,2,3,4,5}; | 创建一个长度为5的数组，并赋值 |
  | int[] arr = new int[]{1,2,3,4,5}; | 创建一个长度为5的数组，并赋值 |
  | int[][] arr = new int[5][5];| 创建一个二维数组，长度为5，每行长度为5|
- **数组的核心工具类**：**Arrays**
- | API | 描述 |
  | :---: | :---: |
  | String str = Arrays.toString(arr) | 数组转字符串 |
  | Arrays.sort(arr) | 数组排序 |
  | int index = Arrays.binarySearch(arr,key) | 二分查找 |
  | Arrays.fill(arr,value) | 数组填充 |
  |int[] newArr = Arrays.copyOf(arr,arr.length) | 数组复制 |
  | int[] newArr = Arrays.copyOfRange(arr,from,to) | 数组复制,复制索引[from,to]的数组 |
  | boolean isEqual = Arrays.equals(arr1,arr2) | 数组比较是否相等 |
  | List< Integer > list = Arrays.asList(1,2,3,4,5) | 数组转List |

- **(2) 动态数组：ArrayList(最常用)**
- 基于数组实现，长度可动态增长，有序、可重复，允许null。查找快（按索引），中间增删慢。
- **创建方式**
- | 创建方式 | 描述 |
  | :---: | :---: |
  | List< Integer > list = new ArrayList<>(); | 创建一个空的ArrayList，多态写法 |
  | ArrayList< Integer > list = new ArrayList<>(); | 创建一个空的ArrayList |
  | ArrayList< Integer > list = new ArrayList<>(5); | 创建一个长度为5的ArrayList |
- **常用API**
- | API | 描述 |
  | :---: | :---: |
  | list.add(element) | 添加元素 |
  | list.add(index,element) | 添加元素，指定位置 |
  | list.add(Arrays.asList(str1,str2,str3)) | 添加多个元素，这是在 List<List<Integer>> list = new ArrayList<>();条件下，每次添加进去的三个元素整合为一个list，而这个list属于更大的集合list |
  | list.addAll(anotherlist) | 添加另一个集合所有元素 |
  | list.remove(index) | 删除指定位置的元素 |
  | list.remove(element) | 删除指定元素的元素 |
  | list.get(index) | 获取指定位置的元素 |
  | list.size() | 获取集合长度 |
  | list.isEmpty() | 判断集合是否为空 |
  | list.clear() | 清空集合 |
  | list.set(index,element) | 修改指定位置的元素 |
  | list.contains(element) | 判断集合是否包含某个元素 |
  | list.indexOf(element) | 获取首次出现指定元素的索引 |
  | list.lastIndexOf(element) | 获取最后一次出现指定元素的索引 |
  | list.forEach(System.out::println) | 迭代集合中的元素 |
  | String[] str = list.toArray(new String[0]); | 将集合转换为数组 |
- **(3) Set**
- 不包含重复元素，最多一个null。无序
- 主要实现类：
    - **HashSet：基于HashMap实现，无序，查询速度最快。是Set的默认选择。**
    - LinkedHashSet：基于LinkedHashMap实现，维护元素的插入顺序。
    - TreeSet：基于红黑树实现，元素会按照自然顺序或指定的Comparator进行排序。
- **创建方式：**
- | 方式 | 作用 |
  | :---: | :---: |
  |Set< String > set = new HashSet<>(); | 创建一个空的HashSet |
  |Set< String > set = new LinkedHashSet<>(); | 创建一个空的LinkedHashSet |
  |Set< String > set = new TreeSet<>(); | 创建一个空的TreeSet |
- **常用API，以HashSet为例：**
- | 方法 | 作用 |
  | :---: | :---: |
  | set.add(element) | 添加元素 |
  | boolean isT = set.add(element) | 添加元素并返回添加是否成功 |
  | boolean hasit = set.contains(element) | 判断元素是否在集合中，没有get方法 |
  | int size = set.size() | 获取集合中元素的个数 |
  | set.forEach(System.out::println) | 遍历集合，因为没有索引，所以只能增强for循环或迭代器遍历 |
  | set.remove(element) | 删除元素 |
  | set.clear() | 删除所有元素 |
  | set.isEmpty() | 判断集合是否为空 |
  | set.retainAll(anotherset) | 交集，结果保留在set中 |
  | set.removeAll(anotherset) | 差集(在set中但不在anotherset中的元素)，结果保留在set中 |
  | set.addAll(anotherset) | 并集，结果保留在set中 |
- **(4) HashMap**
- 基于哈希表实现，存储键值对 (Key-Value)。Key不可重复，Value可重复。允许一个null键和多个null值。无序。
- **创建方式：**
- | 方式 | 描述 |
  | :---: | :---: |
  、Map<String, Integer> scoreMap = new HashMap<>(); | 创建一个空的HashMap |
- **常用API：**
- | 方法 | 描述 |
  | :---: | :---: |
  | put(K key, V value) | 添加键值对 |
  | get(Object key) | 根据key获取value |
  | remove(Object key) | 删除键值对 |
  | remove(Object key, Object value) | 删除指定键值对 |
  | size() | 获取HashMap大小 |
  | isEmpty() | 判断HashMap是否为空 |
  | containsKey(Object key) | 判断HashMap中是否包含指定key |
  | containsValue(Object value) | 判断HashMap中是否包含指定value |
  | keySet() | 获取HashMap中所有key的集合 |
  | values() | 获取HashMap中所有value的集合 |
- **如何用KeySet()**
- 返回类型：Set< K >(一个Set集合，因为键是唯一的)
- 核心用途：当你想遍历所有键，或者只需要处理键时使用。
- >Map<String, Integer> studentScores = new HashMap<>();
  Set< String > allNames = studentScores.keySet();
- **如何用values()**
- >Map<String, Integer> studentScores = new HashMap<>();
  ArrayList< Integer > allScores = studentScores.values();
- **注意事项**
- **如果 创建是：HashMap<String,List< String >> hashmap = new HashMap<>();那么hashmap.get("key") ，返回的是一个List,那么如果需要添加这个key对应的value，则需要用hashmap.get("key").add("value")添加，即可以连起来，先获取对应键值的值，再根据ArrayList的add方法添加**
- **如果如果 创建是：HashMap<String,List< String >> hashmap = new HashMap<>();，整个函数需要把HashMap的值转换成ArrayList并返回,则可以直接return new ArrayList<>(hashmap.values());**


### 2. **链表**
- 链表是一种线性数据结构，与数组不同，链表中的元素在内存中不是连续存储的。每个元素（称为节点）包含两部分：
   - 数据域：存储实际数据
   - 指针域：存储下一个节点的地址
- **==重要认知1：链表中有一个元素是存放地址的，即next，比如有两个节点，节点1(val = 元素1，next = null)和节点2(val = 元素2，next = null)，如果节点1.next被赋值为节点2，则实际上就是节点2的地址被赋值给了节点1.next，节点1.next存放的就是节点2的地址，效果就是节点1里面的next字段指向了节点2，节点1把节点2连起来了：节点1->元素1->节点2->元素2，改链表了，1后边接了2==**
- **==重要认知2：如果直接节点1=节点2，那就是改指针了，节点1被赋值为节点2，那么节点1和节点2都是指向节点2了，根本没连起来，只是指针换了，就相当于a=2,b=3,a=b一样，a最后等于b了==**
- **==head==**：链表的头结点，指向第一个节点，如果没有则指向null。
- **==比如head -> 1 -> 2 -> 3 -> 4 -> 5 -> null,head指向1，head.val=1,head.next=2，head是给外部提供一个查询，插入的钥匙==**
- **(1) 单链表**
- 每个节点只有指向下一个节点的指针，只能单向遍历
- **(2) 双向链表**
- 每个节点有两个指针，一个指向前驱结点，一个指向后继结点，可以双向遍历
- **(3) 循环链表**
- 尾节点指向头结点，形成环状结构，可以单向循环或者双向循环
- **JAVA中的链表实现：LinkedList**
- 是双向链表，非线程安全，允许重复元素，允许null，保持插入顺序(按什么顺序放进去，取出来就是什么顺序)
- **创建方式：**
- | 创建方式 | 描述 |
  | :---: | :---: |
  | LinkedList< String > list = new LinkedList<>(); | 创建一个空的LinkedList |
  | LinkedList< String > list = new LinkedList<>(existingList); | 创建一个LinkedList，并把existingList中的元素添加到LinkedList中 |
  | List< String > list = new LinkedList<>(); | 创建一个空的LinkedList，多态写法 |
- **常用API：**
- | 方法 | 描述 |
  | :---: | :---: |
  | list.add(element) | 添加元素 |
  | list.add(index,element) | 添加元素，指定位置 |
  | list.addFirst(element) | 头部添加元素 |
  | list.addLast(element) | 尾部添加元素 |
  | list.get(index) | 获取指定位置的元素 |
  | list.getFirst() | 获取第一个元素 |
  | list.getLast() | 获取最后一个元素 |
  | list.remove(index) | 删除指定位置的元素 |
  | list.removeFirst() | 删除第一个元素 |
  | list.removeLast() | 删除最后一个元素 |
  | list.remove(element) | 删除指定元素 |
  | list.size() | 获取LinkedList大小 |
  | list.isEmpty() | 判断LinkedList是否为空 |
  | list.contains(element) | 判断LinkedList中是否包含指定元素 |
  | list.clear() | 删除所有元素 |
  | list.indexOf(element) | 返回元素首次出现的索引 |
  | list.lastIndexOf(element) | 返回元素最后出现的索引 |
  | list.poll() | 获取并删除第一个元素(出队) |
  | list.offer(element) | 尾部添加元素（入队） |
  | list.peek() | 获取第一个元素（队列操作）但不移除 |
- **自定义链表实现：单链表、双向链表**
- **单链表**

```
class ListNode<T> {
    T val;
    ListNode<T> next;

    ListNode(T val) {
        this.val = val;
        this.next = null;
    }

    ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }  
}
```
- **双向链表**
```
class DoublyListNode<T> {
    T val;
    DoublyListNode<T> prev;
    DoublyListNode<T> next;
    
    DoublyListNode(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
```
- **简单链表实现实例：**
```
class MyLinkedList<T> {
    private ListNode<T> head;
    private int size;
    
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    // 在头部添加节点
    public void addFirst(T val) {
        ListNode<T> newNode = new ListNode<>(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // 在尾部添加节点
    public void addLast(T val) {
        ListNode<T> newNode = new ListNode<>(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    // 获取链表大小
    public int size() {
        return size;
    }
    
    // 遍历打印链表
    public void printList() {
        ListNode<T> current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
```
- **链表的常见算法**、
- **链表反转**
- prev: 指向前一个节点
  current: 指向当前节点
  current.next: 指向下一个节点
  Temp: 临时保存下一个节点
- **head->1->2->3->null，反转后应为head->3->2->1->null。那么初始prev为null，这是代表了前一个节点，初始化current为head，这是当前节点。然后开始循环，每次先保存当前节点的下一个节点，防止丢失，然后把当前节点的下一个节点赋值为prev，即把原先的当前节点指向原先的下一个节点，变为当前节点指向prev(前一个节点)，然后把prev往后移，即把prev赋值为current，把current也往后移，即把current赋值为之前保存的下一个节点。直到current==null循环结束**
```
public ListNode<T> reverseList(ListNode<T> head) {
    ListNode<T> prev = null;
    ListNode<T> current = head;
    
    while (current != null) {
        ListNode<T> nextTemp = current.next;
        current.next = prev;
        prev = current;
        current = nextTemp;
    }
    
    return prev;
}
```
- **检测环(快慢指针法)**
- **快慢指针:让快慢指针同时从head开始移动，快指针每次移动两步，慢指针每次移动一步，如果快慢指针相遇，则说明有环。**
```
public boolean hasCycle(ListNode<T> head) {
    if (head == null || head.next == null) {
        return false;
    }
    
    ListNode<T> slow = head;
    ListNode<T> fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true;
        }
    }
    
    return false;
}
```
- **合并两个有序链表**
- **创建一个虚拟头节点dummy，dummy指向空节点，然后创建一个current节点，current节点指向dummy。然后比较l1和l2的节点值，将较小的节点连接到current的next，然后current节点后移，继续比较l1和l2的节点值，直到l1或l2为null。最后把还有剩余的节点连接到current的next，最后返回dummy的next。**
```
             节点1
               ^
               |
    dummy -> 空节点  <- current
```
- **实际上，dummy存放的是空节点的地址，效果是dummy指向了空节点，current被赋值为dummy，实际上也是指向了这个空地址。创建current是为了代替dummy执行添加元素操作，为了确保最后的链表返回能找到一开始的虚拟头结点，即dummy，这样才能返回找到新链表的头，即dummy.next**
- **==在链表中：赋值是动作，指向是效果==**
```
public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> dummy = new ListNode<>();
    ListNode<Integer> current = dummy;
    
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }
    
    current.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```