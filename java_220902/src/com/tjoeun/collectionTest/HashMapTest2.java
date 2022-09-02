package com.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest2 {

	public static void main(String[] args) {

		HashMap<String, Integer> hmap = new HashMap<>();

		hmap.put("apple", 1000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("banana", 3500);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("orange", 1500);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("melon", 10000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("water melon", 20000);
		System.out.println(hmap.size() + ": " + hmap);

//		keySet() 메소드는 HashMap에 저장된 데이터의 key만 얻어온다.
		System.out.println(hmap.keySet());
//		values() 메소드는 HashMap에 저장된 데이터의 value만 얻어온다.
		System.out.println(hmap.values());
		
//		HashMap에 저장된 데이터의 key만 얻어와서 ArrayList에 저장하기
		ArrayList<String> keyList = new ArrayList<>();
		for (String key : hmap.keySet()) {
			keyList.add(key);
		}
		System.out.println(keyList);
		
		
//		HashMap에 저장된 데이터의 value만 얻어와서 ArrayList에 저장하기
		ArrayList<Integer> valueList = new ArrayList<>();
		for (Integer value : hmap.values()) {
			valueList.add(value);
		}
		System.out.println(valueList);
		
		ArrayList<Integer> valueList2 = new ArrayList<>();
		for (String key : hmap.keySet()) {
			valueList2.add(hmap.get(key));
		}
		System.out.println(valueList2);		
		
	}

}
