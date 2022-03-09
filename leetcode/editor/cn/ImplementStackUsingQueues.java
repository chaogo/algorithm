//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的
//时间。你可以使用两个以上的队列。 
// Related Topics 栈 设计 队列 👍 375 👎 0


package editor.cn;
    
//public class ImplementStackUsingQueues {
//    public static void main (String[] args) {
//        Solution solution = new ImplementStackUsingQueues().new Solution();
//    }
//// TIME: 60min

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
// 入和出的时候都倒腾
//class MyStack1 {
//    Queue<Integer> queueIn;
//    Queue<Integer> queueOut; //只存储最顶部元素
//    /** Initialize your data structure here. */
//    public MyStack1() {
//        this.queueIn = new LinkedList<>();
//        this.queueOut = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        if(!queueOut.isEmpty()) {
//            queueIn.offer(queueOut.poll());
//        }
//        queueOut.offer(x);
//    }
//
//    // 调用 pop 和 top 都保证栈不为空
//    // 每次取顶部元素，需要对其它元素都做一次搬移，同时In和Out角色互换
//    /** Removes the elemenpt on top of the stack and returns that element. */
//    public int pop() {
//        if (queueOut.isEmpty()) {
//            move();
//        }
//        return queueOut.poll();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        if (queueOut.isEmpty()) {
//            move();
//        }
//        return queueOut.peek();
//    }
//
//    private void move() {
//        while (queueIn.size() > 1) {
//            queueOut.offer(queueIn.poll());
//        }
//        Queue<Integer> tmp = queueOut;
//        queueOut = queueIn;
//        queueIn = tmp;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queueOut.isEmpty() && queueIn.isEmpty();
//    }
//}

// 入的时候倒腾
//class MyStack2 {
//    Queue<Integer> queue1;
//    Queue<Integer> queue2; // 入的时候辅助实现queue1逆序
//    /** Initialize your data structure here. */
//    public MyStack2() {
//        this.queue1 = new LinkedList<>();
//        this.queue2 = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        while (!queue1.isEmpty()) {
//            queue2.offer(queue1.poll());
//        }
//        queue1.offer(x);
//        while (!queue2.isEmpty()) {
//            queue1.offer(queue2.poll());
//        }
//
//    }
//
//    /** Removes the elemenpt on top of the stack and returns that element. */
//    public int pop() {
//        return queue1.poll();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return queue1.peek();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue1.isEmpty();
//    }
//}

// 出的时候倒腾
//class MyStack3 {
//    Queue<Integer> queue1;
//    Queue<Integer> queue2; // 出的时候辅助找到栈顶元素
//    /** Initialize your data structure here. */
//    public MyStack3() {
//        this.queue1 = new LinkedList<>();
//        this.queue2 = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        queue1.offer(x);
//    }
//
//    /** Removes the elemenpt on top of the stack and returns that element. */
//    public int pop() {
//        while (queue1.size() > 1) { //留最后一个，即栈顶元素
//            queue2.offer(queue1.poll());
//        }
//
//        while (!queue2.isEmpty()) {
//            queue1.offer(queue2.poll());
//        }
//        return queue1.poll();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        // 弹出栈顶元素，再补上
//        int res = pop();
//        queue1.offer(res);
//        return res;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue1.isEmpty();
//    }
//}

// 一个队列实现，入的时候倒腾（只有push)，直接出(pop和top)
class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; ++i) { // 将原本前n个元素放到x后面
            queue.offer(queue.poll());
        }
    }

    /** Removes the elemenpt on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

//}