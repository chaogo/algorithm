## 语法相关
2. split时，regex前后仍是regex时，它会将前后处理成空的字符串
3. 对象比较相等时，一定记得不要用==, !=,这样涉及到了地址，要用equals
4. NullPointerException: null虽然String的缺省值，但其并不能调用String的方法，即使s.equals(null)也不能用，会出现NPE error，对于其它引用类型也一样
5. 强制类型转换 (int) ('8'-'0')； 如果 (int) '8' 为 56， ASCII码
6. ASCII码：'0'~'9' -> 48~57; 'A'~'Z' -> 65~90; 'a'~'z' -> 97~122; 记住48， 65， 97， 大写差小写32
7. **8种**基本数据类型：
   - 4种整数型：都是有符号的以二进制补码表示，byte（8位）， short（16位），int(32位)， long(64位)
   - 2种浮点型：float(32位)， double(64位)
   - 布尔型： boolean(1位，也取决于机器)， 默认值为false
   - 字符型： char(单一的16位Unicode字符)
8. int的范围为 -2^31～2^31-1，即-2147483648~2147483647, 即20亿左右（十亿数量级,10位数），遇到需要转换为数组时，长度为10就够了
9. null与长度为0的数组
   - `int[] array = null;` : 没有数组，只有一个数组的引用，或者说这个引用为null
   - `int[] array = {};`: 一个长度为0的数组，其引用不是null而是指向一个长度为0的数组
10. 数组打印 Arrays.toString(array) 
11. 字符转字符串 Character.toString(curChar);
12. hashmap 改变value值， 重新put(key, newValue)即可
13. Java队列 Queue<Integer> queue = new LinkedList<>();
14. 对于字符，要返回String的技巧`return "" + chr`
15. 初始化带参结点：`ListNode p = new ListNode(1)` ——> 别忘了new
16. 结点数组 ListNode[]
17. 位(移）运算：左移5<<2 :20; 右移5>>2 :1 (高位补0)
    - 正数右移，高位用0补，负数右移，高位用1补，当负数使用无符号右移时，用0进行部位(自然而然的，就由负数变成了正数了)
    - 注意：笔者在这里说的是右移，高位补位的情况。正数或者负数左移，低位都是用0补。
18. Java 排序 java.array.sort(data)
19. 对数组排序： Arrays.sort(char/int/...数组) 另Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
20. 数组也可以作为collection中的元素 ： List<int[]> res = new ArrayList<>();
21. 不能使用HashSet对List<Integer>去重，因为即使List内部integer顺序一样，先后新生成的地址也不一样，仍然可以添加到set里面去，何况顺序都会不一样
22. 获取集合的下一个元素
    - `Iterator<Integer> it = set.iterator(); if (it.hasNext()) it.next();`
    - `for (int i : set) { }`
23. map.getOrDefault(key, new ArrayList<String>());
24. 返回空数组的写法`return new int[0];`
25. `long mid2 = (long) mid*mid;` 声明+强制类型转换
26. 字符串比较 `words[mid].compareTo(s) < 0`
27. 对象数组默认初始化元素都是null,在循环赋值时需要先初始化为需要的类，e.g.    
    ```java
    Attraction[] attracts = new Attraction[N];
    for (int j = 0; j < N; j++) {
        attracts[j] = new Attraction(); // 初始化为该类，不然下面的代码会NPE
        attracts[j].h = sc.nextInt();
        attracts[j].s = sc.nextInt();
        attracts[j].e = sc.nextInt();
    }
    ```
28. void不代表没有返回类型，只是返回类型为空，这一点要区别于类的构造方法，构造方法是没有写明返回类型关键字的。
29. null可以赋值给任意引用，但一个已被null赋值的TreeNode引用，显然不能被再被比如String类型赋值
30. `TreeNode node = new TreeNode(); TreeNode left = node.left; left = anotherNode;` 这只是使得left引用指向从node.left变成了anotherNode,对node本身完全没有影响
31. `new StringBuilder("")`
32. 一个list数组的每个list初始化时为null, 添加结点时需要先初始化为list，再添加结点，否则会出现NPE
    ```java
    LinkedList<Integer>[] adj = new LinkedList[n];
    for (int k = 0; k < n; k++) adj[k] = new LinkedList<>();
    for (int[] connect : graph) adj[connect[0]].add(connect[1]);
    ```
33. list, set, array都可以做for-each loop
34. 补码
    - 减法运算
      - 对于机器来说，不管什么码，加法运算时对于每一位只有0+0=0，0+1=1，1+1=10
      - 我们能做的只是把机器的这个运算适应到我们的加法运算（本身就一致）和减法运算（加负数）
      - 对于加法，如4+3 (00000100 + 00000011), 逐位相加即可，结果为00000111，即7
      - **对于减法，怎么办呢？** ==》没有一个直接的减法机制，因此仍然需要转换成加法
      - 如 4-3，可以转换为加法运算4+（256-3），即4+253，（256对应100000000，溢出，后面有效的8位都是0，"等效于0"）
      - 因此只需要将253映射到-3，同理255(-1), 254（-2），...,128(-128)
      - **如何实现这个映射呢?** ==》补码
    - 为什么byte的取值范围为-128～127？
      - byte类型，一个字节，8位，如果无符号，0～255
        - 想让其有符号的话，划一半至负数即可: **128~255平移至-128～-1**
            - 128~255 的首位都是1，首位为1的约定为负数
            - 剩下位范围为0～127，设为x, 取反码即127-x, 取补码即128-x (算上首位，就是256的关系)
            - 再取负，即-128～-1
            - 比如对10000011（131表-3）的补码是11111101（253表-125），反过来后者的补码是前者
        - 这样，原码一个byte仍为0～255，但补码就变成了-128～127
    - 原码给人看；补码用于机器，方便运算（减法）
      - 对于4-3：（00000100 + 10000011），人看原码容易理解，但如果用原码运算，结果为10000111，-7显然错误
      - 机器用补码运算 （00000100 + 11111101）即4+253=257发生溢出，结果为1
    - 对于正整数（原码首位为0），原码、反码、补码一致； 对于负整数（原码首位为1），除首位始终不变，其余取反即反码，再加1即补码
35. ASCII, Unicode与UTF-8
    - ASCII码: 一个byte, 首位为0, 只有128个字符
    - Unicode: 目前最多4个byte， 可以容纳100多万个字符
      - java中(char), 两个byte, 16位, 65536个字符
      - ASCII码是Unicode的子集
    - UTF-8: 
      - 1到4位，变长编码，节省空间
      - 用于机器的存储，"给机器看"
      - Unicode "给人看"
36. 隐含强制类型转换
    - 字面值5.0, 默认为double, 5.0f即"隐含地类型转换"为float
    - 字面值5, 默认为int, 5l即"隐含地类型转换"为long
37. 静态类
    - 非静态内部类，只能用完全限定名，如`new ReverseWordsInAString().new Solution()；` 即通过实例调用
    - 静态类，可以直接用类调用，而不用实例化，如`Solution solution = new Solution();`
38. length
    - 对于数组，length是其属性，不加括号，如`int[] arr = {3,4,5}; int len = arr.lenth;`
    - 对于String类, length是其方法，需加括号，如`String str = "abc"; int len = str.length();`
    
39. 避免这种写法，会造成java.util.ConcurrentModificationException
    ```java
    for (int e : set) {
        if (e+nums[i] == target) return true;
        set.add(e+nums[i]);
    }
    ```

## 技巧、经验相关
1. 对于一前一后双指针的问题，不要拘泥于指针各自与'数组元素'的判断，两个指针之间对应的元素也可以判断，进而简化逻辑
2. 输入格式化和输出格式化的消耗不算在时间、空间复杂度中
3. 将一个int数字反转：        long y = 0;
   while (x != 0) {
   y = y*10 + x%10;
   x /= 10;
   }
4. Edge case occurs at an extreme (maximum or minimum) operating parameter.
   Corner case occurs outside of normal operating parameters, specifically when multiple environmental variables or conditions are simultaneously at extreme levels, even though each parameter is within the specified range for that parameter. (The "outside normal operating parameters" obviously means something like "outside typical combination of operating parameters", not strictly "outside allowed operating parameters". That is, you're still within the valid parameter space, but near its corner.)
   Boundary case occurs when one of inputs is at or just beyond maximum or minimum limits.
   Base case is where Recursion ends.
5. 当两个字符串进行对比或类似情形时，一定要明确字符之间是什么样的关系（一对一，多对一，一对多），从哪一方遍历才是想要的关系
6. hashMap, hashSet, LinkedList, ArrayList,... 后面是功能的说明，前面是具体数据结构的实现
7. 分析最差情况时间复杂度
8. **可以用一一映射boolean数组替代哈希表，这样编程简单，不需要使用高级的数据结构，特别是当数据规模不大时，是一种很重要的数据存储技巧** --零矩阵，扑克牌中的顺子,珠玑妙算
9. **不是说代码写的短，只写一次循环就一定好**
   1. 很多时候循环遍历没必要一个for/while循环遍历完，当设计稍微复杂的逻辑时，可以拆为几个循环，这样逻辑更加清楚。不要为了追求代码的简，如果稍微多一点代码，把不同情况独立出来，但可读性大大提高，显然是更好的选择。——"一次编辑"
   2. 有些时候一次遍历可以解决，但内部逻辑不清楚，很容易把自己绕晕了，这时用多次循环针对不同的类型分别处理（基本没提高复杂度），可以把逻辑弄清晰，提高代码可读性——珠玑妙算
10. 编辑距离：当遇到不同的，将长的后移，（增加短的相当于删除长的）
11. 多阶段决策模型：回溯（所以情况） ——> 动规（去除重复） ——> 贪心（一种情况）: 贪心是动态规划的一种特殊情况，动规又是回溯的一种特殊情况
12. 多次翻转可以代替旋转 ———— "旋转图像"
    - 顺时针旋转90度：上下翻转+对角线"\"翻转 或 左右翻转+"/"翻转
    - 顺时针旋转180度：上下翻转+左右翻转 或 左右翻转+上下翻转
    - 顺时针旋转270度：对角线"\"翻转+上下翻转 或 "/"翻转+左右翻转
13. 对区域划定范围时,多用几个变量（如top, bottom, left, right)，而不是来回去算，简化逻辑，不用在这些地方省空间
14. 递归的核心是 **递出去，归回来**
    - 递出去的过程一般是在遍历，这里要明确递的终点（终止条件）
    - 归回来的有可能是中间操作的结果，也有可能是"递"的终点，也有可能不归
    - 递出去归回来之外就是操作的核心逻辑或者说递推公式，处在往下一层函数调用之后，（后进先出）。
    - 往下一层函数调用之前的是做一些准备工作
15. **意识到 循环的终止条件得保证循环体内运行不出错，即循环体的语句对循环条件有提示作用**
    ```Java
         while (fast != null && fast.next != null) { // 循环内涉及fast.next.next，因此这里的终止条件得加上fast.next != null
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    ```
16. 链表遍历同时需要做`p.next = null`时的标准操作: 用`tmp = p.next; {...} p = tmp;`代替`p = p.next;`
    ```Java
    while (p != null) {
        tmp = p.next;
    if (p.val != tail.val) {
        p.next = null;
        tail.next = p;
        tail = p;
        }
    p = tmp;
    }
    ```
17. 除非题目中特殊说明，否则都可以改变输入的原始链表
18. 链表反转的另一种思路
    - 之前都是在dummyHead的尾部插入，即"尾插"，结果链表为顺序；
    - 为了翻转链表，只需往dummyHead的前面插入，即"头插"，结果链表逆序；
    - **头插与双指针迭代的思路（理解方式）不一样，（变量命名很大程度影响了代码的理解，一个是newHead,p;另一个是p,q),但代码的实质竟然是一模一样的！！ 大受震撼！**
19. 对于解题需要几个不同的逻辑步骤，或统一逻辑过程用了好几次的情况，一定要用函数把功能封装起来，这样能使得代码逻辑更加清晰，有助于解题，且代码可读性更高，（虽然性能不一定提高）。 典型例题——回文链表——先找中间结点-翻转后部分链表-比较
20. 原地算法和空间复杂度为O(1)的关系：O(1) -> 原地； 原地 —/> O(1) 
21. 解题时如果需要新封装一个函数，要定义成private
22. peek,pop等操作前一定要注意判断栈/队列是否为空
23. 临时栈/辅助栈
24. 双端队列，两头进，两头出，**同时具有队列和栈的功能**，`Deque<Character> deque = new LinkedList<>();`
25. StringBuilder的.toString方法可以直接打印字符串，而char[]的.toString方法只能打印地址，需要new String(chars)
26. 对于和的取模运算：
    - (a + b) % m == (a%m + b) % m == (a%m + b%m) % m
    - 即括号内做了几次取模运算无所谓，只要和最后再取模就行
    - 因此，为避免大数越界,又不至于太繁琐：如果a+b+c会越界，而其中任意两数和不会越界，可以两个两个地处理，即前两个相加取模，再与第三个相加取模
    - 即(a+b+c) % m == ((a+b) % m + c) % m 
27. 写swap函数时，一定要拿数组/引用作为参数，不能直接用值作为参数。即 private void swap (int[] nums, int i, int j) , 而不是 private void swap (int a, int b)
28. 常数级空间复杂度 ——> 不但不能申请新的n相关大小的空间，**也不能使用递归**，因为有函数调用栈的空间占用
29. 用数组下标做函数参数，而不是来回复制数组将完整的数组做参数 ——> 17.14, 215
30. tail.next = null; // 链表结束记得断开
31. 尽量不要让链表结点的next/prev随意指，或不做控制，这样很可能会发生意外的错误
32. 写if-else语句时，切记不要遗漏，比如等式相等的情况
33. 写二分查找时，不要绕进去，一定要以mid为界
    如 循环数组的二分查找
    ```java
    if(nums[low] <= nums[mid]) { // 左有序
    if (nums[low] <= target && target < nums[mid]) high = mid - 1; // 一定以mid为界进行划分
    else low = mid + 1; // 将target>nums[mid]和target<nums[mid] (最后折的一段）做了合并
    } else { // 右有序
    if (nums[mid] < target && target <= nums[high]) low = mid + 1; // 一定以mid为界进行划分
    else high = mid - 1;
    }```
34. 一个结点的值跟它的所有祖宗结点都有关系，所以判断一个子树是不是平衡时，要同时更新其取值范围
35. 写代码时，有一些特殊情况时，先写特殊的，（代码少，并return），再写一般的，（代码多，已经排除了特殊的情况了）, 这也同时保证了return语句不在if代码块里 e.g.
    ```java
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        // if (node1 != null && node2 != null) {
        TreeNode resNode = new TreeNode(node1.val + node2.val);
        resNode.left = mergeTrees(node1.left, node2.left);
        resNode.right = mergeTrees(node1.right, node2.right);
        return resNode;
    }
        
    //求高度的同时顺便判断是否平衡
    private int depthBalance(TreeNode node) {
        if (node == null) return 0;
        if (!balance) return -1; // 已经不平衡了，提前终止递归；
        int depthLeft = depthBalance(node.left);
        int depthRight = depthBalance(node.right);
        if (Math.abs(depthLeft-depthRight) > 1) { balance = false; }
        return Math.max(depthLeft, depthRight) + 1;
    }
    ```
    不好的写法：
    ```java
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            TreeNode resNode = new TreeNode();
            resNode.val = node1.val + node2.val;
            resNode.left = mergeTrees(node1.left, node2.left);
            resNode.right = mergeTrees(node1.right, node2.right);
            return resNode;
        }
    
        if (node1 != null) {
            return node1;
        }
    
        if (node2 != null) {
            return node2;
        }
        return null;
    }
    
    //求高度的同时顺便判断是否平衡
    private int depthBalance(TreeNode node) {
        if (node == null) return 0;
        if (balance) {
            int depthLeft = depthBalance(node.left);
            int depthRight = depthBalance(node.right);
            if (Math.abs(depthLeft-depthRight) > 1) { balance = false; }
            return Math.max(depthLeft, depthRight) + 1;
        } else {
            return -1; // 已经不平衡了，提前终止递归；
        }
        retrun -1;
    }
    ```
36. 提前终止递归语句可以放在函数最前面，也可以放在函数返回语句后面（更高效）,e.g.
    ```java
    private boolean balanced = true;
    private int height(TreeNode root) {
    if (root == null) return 0;
    // if (balanced == false) return 0; // 提前终止递归
    int leftHeight = height(root.left);
    // if (balanced == false) return 0; // 提前终止递归
    int rightHeight = height(root.right);
    if (Math.abs(leftHeight-rightHeight) > 1) balanced = false;
    return Math.max(leftHeight, rightHeight) + 1;
    }
    ```
37. 题目的函数头只是规范输入输出，不要视为提示，有时是误导，而且面试时也没有这样的函数头
38. 单独写一个递归函数时，如果返回值并非要求的值，要求解的值放在全局变量中
39. 命名(my-), e.g. 主函数buildTree, 需要单独写一个递归函数myBuildTree
40. list的snapShot的利用parametrized constructor call的简洁写法
    ```java
    List<Integer> snapShot = new ArrayList<>();
    snapShot.addAll(path); //path一直在变
    ```
    ->`List<Integer> snapShot = new ArrayList<>(path);`
41. 不要嫌递归函数的参数繁，如果是对象，传递的只是一个引用，如果是值，传递的代价也不大，总之，可读性和方便更重要
42. 写递归函数时要明确这个函数要解决一个什么问题，然后把单独解决这个问题的函数主体先写好，比如传递的是区间，就不要访问超过这个区间，即使由于其是一个子问题暂时不会报错
43. 一个对象的.toString()方法如果没有覆盖只会返回方便打印的描述（地址）
44. 将char[] 转化为String, e.g. `char[] charArr = {'a','b','c'};`
    - 构造String时建立： `String str = new String(charArr);`
    - 用String的valueOf方法： `String str = String.valueOf(charArr);`
45. int转char: JVM会把数字当成字符的ASCII编码来处理
    - 先转String再转char;
    - 如果int只对应0～9，加48再转，（'0'～'9'对应48～57） e.g. `int a = 5; char aChar = (char) a+48;`
46. 回溯解数独 
    - 尽量不要采用太复杂的数据结构比如三维数组很容易出bug，还是维护直接的数据结构比如collection，哪怕因此会牺牲一点效率
    - 现场如果不恢复的话，第一次到这即使不成功也会改变值，之后就不会再搜索这了 -> 恢复现场不仅为后面得到结果有用，对失败搜索后重新搜索这也有用
47. java char的默认值 '\u0000' （空字符）
48. String截取子串的substring方法：`String str = "bbbdsajjds"; str.substring(2, 4);` 左闭右开[2,4)
49. String 转 int 
    - Integer.parseInt() returns the string as a primitive type int. 
    - Integer.valueOf() returns the string as an integer object.
50. `return myVerifyPostorder(post, i, m-1) && myVerifyPostorder(post, m, j-1);` // 分开写成
    `if (!myVerifyPostorder(post, i, m-1)) return false;
     return myVerifyPostorder(post, m, j-1);`
    并不会避免不必要的递归，因为f(a) && f(b) 当f(a)为false时并不会执行f(b),而是直接返回false
51. 写一个辅助函数得明确这个函数是要干什么，在写这个函数时，不要想其他函数
52. &&与&， ||与｜
    - &&：逻辑与，逻辑运算符，执行短路求值，当参与运算的一个操作数（表达式）已经足以推断出这个表达式的值的时候，另一个操作室（表达式）就不会被执行
    - &：按位与，位操作符，不执行短路求值，任何参与运算的表达式都会被执行求值
    - （由于boolean值按0，1存储？也）可以用&进行运算
53. 一维数组打印： `Arrays.toString(dp)；` 多维数组打印：`Arrays.deepToString(dp)；`

## 易错
1. 即使是简单的做过很多次的题，也要认真对待，该类型题目的一步一步思考过程要完整，一定不要凭着记忆和感觉去写，这样很容易处处是bug,还察觉不出来
2. 注意避免大数越界溢出： 
   - 面试题08.01 三步问题: 每两个两个取模，避免一次求和（已越界）再取模
   - 剑指Offer 67 把字符串转换成整数： 预计将要越界时，提前处理可能情况
   - 剑指Offer 16 数值的整数次方： 负数转换成正数时如果直接不能直接取相反数，因为最小值-2^31-1的绝对值比最大值2^31的绝对值大1，会造成越界. 做法技巧`if (n < 0) return 1/(Pow(x, -1*(n+1))*x);`
3. 写递归代码时注意避免堆栈溢出和超时(递归的函数调用累计时间消耗可能是非常庞大的）：剑指Offer 16 数值的整数次方； 08.05递归乘法
4. 引用：
   LinkedList<Pair> slot = slots[hash(key)];
   if (slot == null) {
   slots[hash(key)] = new LinkedList<>();
   slot = slots[hash(key)];
   // 如果直接这样写slot = new LinkedList<>();
   // 相当于LinkedList<Pair> slot = new LinkedList<>(); 就跟slots没什么关系了
   // slot是新建的一个引用，而slots[hash(key)]才是已经存在在数组的 需要用的那个引用
   }
5. **只要遇到中括号"["和点".", (访问数组元素(array[i])或访问对象属性(node.right))，一定要警惕数组越界IndexOutOfBoundsException和NPE nullPointerError**
6. **只要写循环，无论是while还是for,一定要确定循环变量在更新，警惕陷入死循环**
7. 

## 补缺
1. 位运算；
    - 08.05 递归乘法 5>>1 (2), (5>>1)<<1 (4), 5-(5>>1)<<1 (6?)
2. 位图在二进制位上的模拟， 涉及位运算
3. 浮点型的取值范围

## 必需要再刷的题
- 剑指Offer 16 数值的整数次方
- 面试题17.14 最小的k个元素； 215 第K个最大的元素
- 706 设计哈希映射； 146 LRU缓存机制
- 33 搜索旋转排序数组
- 98 验证二叉搜索树
- 37 解数独 
- 90 子集II 
- 62 不同路径 ：用组合的方法中间过程容易发生溢出

## 工具相关， 杂
1. github上一个项目，有issue讨论区，很可能有人遇到了一样的问题，那里会有解答，也可以在那向开发者提问
2. 对于leetcode的IDEA插件，可以下不同的release版本的.zip 或 .jar文件，然后在plugin中选择install from disk






## Kick Start
- 不能有中文字符，注释也不行
- 自己组织输入输出, 类命名为Solution
    ```java
    import java.util.Scanner;
    
    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();
            for (int t = 1; t <= T; t++) {
                
                System.out.println("Case #" + t + ": " + res);
            }
        }
    }
    ```
- void main 函数中不要轻易写return语句，因为有有多个test cases
- 要求区间不连续、不重合，可以考虑对两个区间对分界做遍历，让两个区间分布在分界线的左右： 21G.3
- CE时，注意检查分号、括号有没有丢
- 有时讨论各种情况（条件）求（最优值），不如拿各种结果直接比较得出结果，e.g.
    ```java
    int DistanceX = 0;
    int DistanceY = 0;
    
    if (x < F.x1) {
        DistanceX = F.x1 - x;
    } else if (x > F.x2) {
        DistanceX = x - F.x2;
    }
    
    if (y < F.y1) {
        DistanceY = F.y1 - y;
    } else if (y > F.y2) {
        DistanceY = y - F.y2;
    }
    int d = (DistanceX+DistanceY);
    ```
  可以写成：
    ```
    d = max(x1-x, x-x2, 0) + max(y1-y, y-y2, 0); 
    ```
  // 取大于等于0的那个：比小的小则第二项为负取第一项，比大的大则第一项为负取第二项，小大之间则两项都为负数取0
- line Sweep, Sliding Window