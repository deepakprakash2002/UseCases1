package com.exercise.programs.map;

public class customCuncurrentHashMapTest extends Thread{
	public static void main(String[] args) {
		customCuncurrentHashMap chm=new customCuncurrentHashMap(16,16);
		TaskCHM T1=new TaskCHM(chm,"T1");
		TaskCHM T2=new TaskCHM(chm,"T2");
		TaskCHM T3=new TaskCHM(chm,"T3");
		TaskCHM T4=new TaskCHM(chm,"T4");
		TaskCHM T5=new TaskCHM(chm,"T5");
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
		
	}
	static class TaskCHM extends Thread{
		customCuncurrentHashMap chm=null;
		public TaskCHM(customCuncurrentHashMap chm, String string) {
			this.chm=chm;
		}

		public void run(){
			String name=Thread.currentThread().getName();
			if(name.equalsIgnoreCase("T1")){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(3+"-> "+chm.get("3"));
				System.out.println(2+"-> "+chm.get("2"));
				System.out.println(1+"-> "+chm.get("1"));
			}else{
			chm.put("1", "apple1");
			chm.put("2", "banana2");
			chm.put("3", "apple3");
			chm.put("4", "apple4");
			chm.put("1", "banana1");
			chm.put("2", "apple2");
			chm.put("3", "banana3");
			}
			System.out.println(2+"-> "+chm.get("2"));
			System.out.println(1+"-> "+chm.get("1"));
		}
     }
	}
