package com.exercise.programs.map;

class Entry{
	final String Key;
	volatile String Value;
	Entry Next;
	int Hash;
	public Entry(String key,String value,Entry next,int hash) {
		Key=key;
		Value=value;
		Next=next;
	    Hash=hash;
	}
}

class customHashMap {
	Entry [] entryTable=null;
	
	public customHashMap(int entryPerSegment) {
		this.entryTable=new Entry[entryPerSegment];
	}
	
    public synchronized	String  put(String key, String value){
		if(key==null){
			return insertForNull(value);
		}
		int hash=key.hashCode();
		int bucketIndex=hash%16;
		for(Entry e=entryTable[0];e!=null;e=e.Next){
			if(e.Key.equals(key) && e.Key==key && e.Hash==hash){
				String oldValue=e.Value;
				e.Value=value;
				return oldValue;
			}
		}
		insertEntry(hash,key,value,bucketIndex);
		return null;
	}
	public String insertForNull(String value){
		for(Entry e=entryTable[0];e!=null;e=e.Next){
			if(e.Key==null){
				String oldValue=e.Value;
				e.Value=value;
				return oldValue;
			}
		}
		insertEntry(0,null,value,0);
    return null;
	}
	
	public void insertEntry(int hash,String key,String Value,int bucketIndex ){
		Entry e=entryTable[0];
		entryTable[0]=new Entry(key,Value,e,hash);
		
	}
	
	public String get(String key){
		if(key==null){
			return entryTable[0].Value;
		}else {
			int hash=key.hashCode();
			int bucketIndex=hash%16;
			for(Entry e=entryTable[0];e!=null;e=e.Next){
			if(e.Key.equals(key) && e.Key==key && e.Hash==hash){
				return e.Value;
			}
		  }	
			return null;
		}
	}
}

public class customCuncurrentHashMap {
   
	customHashMap [] segmentTable=null;
	private int entryPerSeg;
	//Map size and Cuncurrency level assume same like 16
	customCuncurrentHashMap(int cuncurrencyLevel,int cMapSize){
		segmentTable=new customHashMap[cuncurrencyLevel];
		entryPerSeg=cuncurrencyLevel/cMapSize;
		for (int i=0;i<16;i++){
			segmentTable[i]=new customHashMap(entryPerSeg);
		}
		
	}
	
	public void put(String key,String value){
		int hash=key.hashCode();
		int bucketIndex=hash%16;
		segmentTable[bucketIndex].put(key, value);
	}
	public String get(String key){
		int hash=key.hashCode();
		int bucketIndex=hash%16;
		return segmentTable[bucketIndex].get(key);
	}
	
}

