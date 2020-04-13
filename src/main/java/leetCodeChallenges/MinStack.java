package leetCodeChallenges;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public MinStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int x) {
		stack1.push(x);
		if (stack2.isEmpty()) {
			stack2.push(x);
		} else {
			stack2.push(Math.min(stack2.peek(), x));
		}
	}

	public void pop() {
		stack1.pop();
		stack2.pop();
	}
	
	public int top() {
		return stack1.peek();
	}
	
	public int getMin() {
		return stack2.peek();
	}
}
