## 链表


## 二分查找 (表达所求的元素需要满足的要求)

## 二叉树 (dfs递归实现，构建确切的子问题)
### 二叉树前中后序遍历的非递归实现
- 手动模拟函数调用栈的压栈出栈过程
- 对栈顶元素
  - status = 1, 表示要扩展左子树，将左子结点入栈
  - status = 2, 表示左子树扩展完了，要扩展右子树，将右子结点入栈
  - status = 3, 表示左右子树都扩展完了，出栈
```java
class Solution {
    private class SFrame {
        int status;
        TreeNode node;

        SFrame(TreeNode node, int status) {
            this.status = status;
            this.node = node;
        }
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> Traversal(TreeNode root) {
        Stack<SFrame> stack = new Stack<>();
        if (root != null) stack.push(new SFrame(root, 1));
        while (!stack.isEmpty()) {
            SFrame curFrame = stack.peek();
            if (curFrame.status == 1) {
                res.add(curFrame.node.val); // preorder
                curFrame.status = 2;
                if (curFrame.node.left != null) {
                    stack.push(new SFrame(curFrame.node.left, 1));
                    continue;
                }
            }
            if (curFrame.status == 2) {
                res.add(curFrame.node.val); // inorder
                curFrame.status = 3;
                if (curFrame.node.right != null)
                    stack.push(new SFrame(curFrame.node.right, 1));
                continue;
            }
            if (curFrame.status == 3) {
                res.add(curFrame.node.val); // postorder
                stack.pop();
            }
        }
        return res;
    }
}
```

### 二叉树层序遍历的递归实现
```java
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}
```
## 递归recursion
```
def recur(参数) {
  递归结束条件 # 最小子问题
  ...前置逻辑...
  recur(参数) # 子问题
  是否有现场需要手动恢复（全局变量） 
  ...后置逻辑...
}

```
## 回溯backTrack (**多阶段决策模型 -> 分好阶段**)
```python
result = [];

// 可选列表：往往可选列表不是显式的
// 决策阶段：（阶段数量）；提前终止条件；终止条件；（要全面，包括没满足题目条件但超出数组等情况，避免出现outOfBound,或stackOverFlow；）
// 当前路径：有时需要带一个路径和等题目关注的需求. 如果用数组，比如char[]记录path，每次决策覆盖path[k],则不用手动恢复，简化代码
def backTrack(可选列表， 决策阶段k， 路径path)
  // 提前终止条件 可无
  if 提前位置得到可行解（e.g. 组合的值为target)
    // if 可行
    result.add(路径)
    return
    
  // 终止条件，阶段走完了
  if 所有决策都已完成(e.g. 全排列)
    // if 可行 result.add(路径)
    return
    
  for 选择 in 可选列表: 
    if 满足要求：
      路径.add（选择）# 做选择
      backTrack(可选列表，决策阶段+1， 路径)
      路径.remove(选择) # 撤销选择 -> 引用类型必须恢复现场；局部变量如果下一循环还要用也需要手动恢复；
  
  // 两种选择时也一样
  // 分/选
  if 满足要求：...
  // 不分/不选
  if 满足要求...
```


## 深度/广度优先搜索
### BFS
```java
public void bfs(int s, int t) {
    boolean[] visited = new boolean[v];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = true;
    int[] prev = new int[v];
    for (int i = 0; i < v; ++i) prev[i] = -1;
    
    while (queue.size() != 0) {
        int p = queue.poll();
        if (p == t) {
            print(prev, s, t);
            return;
        }
        for (int i = 0; i < adj[p].size(); ++i) {
            int q = adj[p].get(i);
            if (!visited[q]) {
                prev[q] = p;
                visited[q] = true;
                queue.add(q);
            }
        }
    }
}

// 递归打印s->t的路径，有点类似逆序打印链表
private void print(int[] prev, int s, int t) {
    if (prev[t] != -1 && t != s) {
        print(prev, s, prev[t]);
    }
    System.out.print(t + " ");
}
```

### DFS
```java
private boolean[] visited = new boolean[v];
private List<Integer> res = new ArrayList<>();
private boolean found = false;

public List<Integer> dfs(int s, int t) {
    dfs_r(s, t, new ArrayList<>());
    return res;
}

// 这里由于s->t有方向/影响，不独立；
// 初始时如果path为空路径就得当前放s,当前不放t (先做选择，再放入路径）；
private void dfs_r(int s, int t, List<Integer> path) {
    visited[s] = true;
    
    path.add(s); 
    if (s == t) {
        res = new ArrayList<>(path); // 没包括t
        found = true;
        return;
    }
    
    for (int i = 0; i < adj[s].size(); ++i) {
        int q = adj[s].get(i);
        if (!visited[q]) {
            dfs_r(q, t, path);
            if (found) return;  
        }
    }
    path.remove(path.size()-1);
}
```

同回溯模版的代码
```java
private boolean[] visited = new boolean[v];
private List<Integer> res = new ArrayList<>();
private boolean found = false;

public List<Integer> dfs(int s, int t) {
    List<Integer> path = new ArrayList<>();
    path.add(s);
    visited[s] = true;
    dfs_backTrack(s, t, path);
    return res;
}

// 初始时不为空路径就得提前放s,当前放t（先放入路径，再做选择）；实质应该是一样的
// 可选列表 ： 由图adj给出
// 决策阶段 ： 当前结点；找到目标顶点或遍历完结束
// 路径 ： path
private void dfs_backTrack(int s, int t, List<Integer> path) {
    if (s == t) {
        res = new ArrayList<>(path); // 没包括t
        found = true;
        return;
    }
    
    for (int i = 0; i < adj[s].size(); ++i) {
        int q = adj[s].get(i);
        if (!visited[q]) {
            path.add(q);
            visited[q] = true;
            dfs_backTrack(q, t, path);
            if (found) return;
            path.remove(path.size()-1);
        }
    }
}
```

### 拓扑排序DFS算法
```java
public void topoSortByDFS() {
    for (int i = 0; i < v; ++i) {
        if (visited[i] == false) {
            visited[i] = true;
            dfs(i);
        }
    }
}

private void dfs(int vertex) {
    for (int i = 0; i < adj[vertex].size(); ++i) {
        int w = adj[vertex].get(i);
        if (visited[w] == true) continue;
        visited[w] = true;
        dfs(w);
    }
    System.out.print("->" + vertex);
}
```

### 检测环及拓扑排序Kahn算法
```java
public void topoSortByKahn() {
    int[] inDegree = new int[v];
    for (int i = 0; i < v; ++i) {
        for (int j = 0; j < adj[i].size(); ++j) { // 手写遍历链表会更高效，这里只是可读性更好
            int w = adj[i].get(j);
            inDegree[w]++;
        }
    }
    LinkedList<Integer> zeroSet = new LinkedList<>();
    for (int i = 0; i < v; ++i) {
        if (inDegree[i] == 0) zeroSet.add(i);
    }
    while (!zeroSet.isEmpty()) {
        int i = zeroSet.remove(); // retrive and remove the head of the list
        System.out.print("->" + i);
        for (int j = 0; j < adj[i].size; ++j) {
            int k = adj[i].get(j);
            inDegree[k]--;
            if (inDegree[k] == 0) zeroSet.add(k);
        }
    }
}
```












