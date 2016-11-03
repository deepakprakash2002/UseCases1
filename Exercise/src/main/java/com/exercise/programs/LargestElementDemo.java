package com.exercise.programs;

public class LargestElementDemo {

	public static void main(String[] args) {
		int[] array={10,34,29,3,71,86,24,58,11,14};
		int largest=array[0];
		int secondLargest=array[1];
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]+"\t");
		}
		
		for(int i=0;i<array.length;i++){
			if(array[i]>largest){
				secondLargest=largest;
				largest=array[i];
			}else if(array[i]>secondLargest){
				secondLargest=array[i];
			}
		}
		
		System.out.println("Second largest element in array is:  "+secondLargest);
		System.out.println("largest element in array is:  "+largest);
	}
}
