package com.exercise.programs.prodcons;

import java.util.Stack;

public class Producer implements Runnable {
	Object lock;
	Stack<Integer> integers;
	
	public Producer(Object lock, Stack<Integer> integers){
		this.lock=lock;
		this.integers=integers;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			synchronized(lock){
				System.out.println("Produced item "+i);
				integers.push(i);
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.notifyAll();
			}
			
		}
	}

}
