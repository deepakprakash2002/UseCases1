package com.exercise.programs;

import java.util.concurrent.atomic.AtomicInteger;

class ConcurrentCounter implements Runnable{
	
	private AtomicInteger counter;
	
	public ConcurrentCounter(AtomicInteger counter){
		this.counter=counter;
	}

	@Override
	public void run() {
		System.out.println("The Current Counter value in Thread "+Thread.currentThread().getName()+ " is: "+counter.getAndIncrement());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class ConcurrentCounterDemo {

	public static void main(String[] args) {
		AtomicInteger counter=new AtomicInteger(0);
		
		for(int i=0;i<10;i++){
			Thread t=new Thread(new ConcurrentCounter(counter),"T"+i);
			t.start();
		}

	}

}
