package com.exercise.programs.prodcons;

import java.util.Stack;

public class Consumer implements Runnable {
	
	Object lock;
	
	Stack<Integer> integers;
	
	public Consumer(Object lock,Stack<Integer> integers){
		this.lock=lock;
		this.integers=integers;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			synchronized(lock){
				lock.notifyAll();
				System.out.println("Consumed Item: "+integers.pop());
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
