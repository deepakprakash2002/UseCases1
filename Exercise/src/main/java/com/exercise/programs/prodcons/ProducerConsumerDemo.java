package com.exercise.programs.prodcons;

import java.util.Stack;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Object lock=new Object();
		Stack<Integer> integers=new Stack<Integer>();
		Thread producer=new Thread(new Producer(lock,integers));
		Thread consumer=new Thread(new Consumer(lock,integers));
		producer.start();
		consumer.start();
	}

}
