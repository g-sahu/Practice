package com.practice.datastructures;

public class StackImpl {
	public static void main(String args[]) throws Exception {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		while(stack.size > 0) {
			System.out.println(stack.pop());
		}
	}
}

class MyStack {
	Integer arr[];
	int top, bufferSize = 10, size;
	
	MyStack() {
		arr = new Integer[bufferSize];
		top = -1;
		size = 0;
	}
	
	public void push(int i) throws Exception {
		if(++top < bufferSize) {
			arr[top] = i;
			++size;
		} else {
			throw new Exception("Stack is full!");
		}
	}
	
	public int pop() throws Exception {
		int element;
		
		if(top >= 0) {
			element = arr[top];
			arr[top--] = null;
			--size;
		} else {
			throw new Exception("Stack is empty!");
		}
		
		return element;
	}
}
