package jtj;

import java.util.*;

public class Type_Cs {

	public static void main(String[] args) {
		/*
		    Map 함수
		 	key를 통해 value를 획득 
		 	
		*/
		//HashMap<String, String>을 통해 값들의 속성을 정해주는 듯
		HashMap<String, String> map1 = new HashMap<>();
			map1.put("people", "사람");
			map1.put("baseball", "야구");
		
		//key에 해당하는 value값을 얻기 위해서 get 메서드를 사용
		System.out.println(map1.get("people"));
		//key에 해당하는 value 값이 null일 경우 이 대신 default 값으로 얻고 싶을때 getOrDefault 메서드 사용
		System.out.println(map1.getOrDefault("JAVA", "자바"));
		//map에 해당하는 key가 있는지 조사후 참,거짓으로 return
		System.out.println(map1.containsKey("java"));
		//key에 해당되는 key,value을 삭제 흐 그 value값을 return
		System.out.println(map1.remove("people"));
		//size() 메서드는 Map의 갯수를 return한다 people이 지워졌기 때문에 baseball 1을 return
		System.out.println(map1.size());
		
		//Map에 있는 모든 key를 모아서 return list로 return 인가?
		HashMap<String, String> map2 = new HashMap<>();
	       map2.put("people", "사람");
	       map2.put("baseball", "야구");
	       System.out.println(map2.keySet());  // [baseball, people] 출력
	       
	   //Map의 모든 key를 모아서 Set 자료형으로 리턴한다. 다음과 같이 List 자료형으로 바꾸어 사용 가능!
	   List<String> keyList = new ArrayList<>(map2.keySet());
	   		System.out.println(keyList);
	   /*
	        HashMap 말고도 다른 Map 함수들
	    	LinkedHashMap은 입력된 순서대로 데이터를 저장하는 특징을 가지고 있다.
			TreeMap은 입력된 key의 오름차순 순서로 데이터를 저장하는 특징을 가지고 있다.
	    */
	   
	   /*
	   		(집합)Set 함수
	   		집합과 관련된 것을 쉽게 처리하기 위해서 만든 자료형이다.
	   		
	   		HashSet, TreeSet, LinkedHashSet  Set 또한 여러 함수가 있다
	   		+ (HashSet만)집합 자료형은 순서가 없기(unordered) 때문에 인덱싱으로 값을 얻을 수 없다.
	   			+ TreeSet - 오름차순으로 값을 정렬하여 저장하는 특징이 있다.
				+ LinkedHashSet - 입력한 순서대로 값을 정렬하여 저장하는 특징이 있다.

	    */
	   HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
	   		System.out.println(set);
	   	/*
		   [e, H, l, o] 이렇게 출력되는 이유는 
		     중복을 허용하지 않는다.
		     순서가 없다(Unordered).
		*/
	   	// 교집합, 합집합, 차집합 
	   		HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
	        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
	        
	   //교집합
	        HashSet<Integer> intersection = new HashSet<>(s1); // s1으로 intersection 생성
	        intersection.retainAll(s2); //교집합 수행
	        System.out.println(intersection); // [4, 5, 6] 출력
	   //합집합
	        HashSet<Integer> union = new HashSet<>(s1); // s1으로 union 생상
	        union.addAll(s2); //합집합 수행
	        System.out.println(union); //[1, 2, 3, 4, 5, 6, 7, 8, 9] 출력
	   //차집합
	        HashSet<Integer> substract = new HashSet<>(s1); // s1으로 substract 생성
	        substract.removeAll(s2);  //차집합 수행
	        System.out.println(substract); //[1, 2, 3] 출력   	   
	   // 집합 자료형 관련 메서드
	        //집합 자료형에 값 추가하기 (add)
	        HashSet<String> set2 = new HashSet<>();
	        set2.add("Jump");
	        set2.add("To");
	        set2.add("Java");
	        System.out.println(set2); // [Java, To, Jump] 출력
	   //값 여러 개추가하기(addAll)
	        HashSet<String> set3 = new HashSet<>();
	        set3.add("Jump");
	        set3.addAll(Arrays.asList("To","Java"));
	        System.out.println(set3); // [Java, To, Jump] 출력   
	   // 특정 값 제거
	        set3.remove("To");
	        System.out.println(set3);
	   /*
	     
	     상수집합 (Enum)
	     Enum은 서로 관련이 있는 여러 개의 상수 집합을 정의할 때 사용하는 자료형이다.
	     
	   */
	   // Enum 만들기
	       enum CoffeeType {
	    	   AMERICANO,
	    	   ICE_AMERICANO,
	    	   CAFE_LATTE
	       };
	       //정의한 상수 집합 사용
	       System.out.println(CoffeeType.AMERICANO);  // AMERICANO 출력
	       System.out.println(CoffeeType.ICE_AMERICANO);  // ICE_AMERICANO 출력
	       System.out.println(CoffeeType.CAFE_LATTE);  // CAFE_LATTE 출력
	        
	       for(CoffeeType type: CoffeeType.values()) { //배열을 return 한다.
	    	   System.out.println(type);  // 순서대로 AMERICANO, ICE_AMERICANO, CAFE_LATTE 출력
	       }
	   /*
	     Enum은 왜 필요한가?
	     
	     int americano = countSellCoffee(1);
	     이 방식은 숫자 1이 아메리카노임을 기억하고 사용해야 한다는 불편함이 있다. 또, 다음과 같이 사용할 경우에도 문제가 발생한다.
	     int result = countSellCoffee(99); // 99 타입은 존재하지 않으므로 오류가 발생한다.
	     인수의 값과 의미에 대해 명확이 알고 있지 못한다면 오류가 발생할 수 있다.
	     int americano = countSellCoffee(CoffeType.AMERICANO); // 아메리카노의 판매 갯수
	     숫자 1을 사용했을때 보다 코드가 명확해 진다. countSellCoffee메서드에는 CoffeeType에 정의된 상수만 전달할 수 있기때문에
	     99 처럼 엉뚱한 숫자값에 의한 오류가 발생하지 않는다.
	     
	     **총정리**
	     	* 매직넘버(1과 같은 숫자 상수값)를 사용할 때보다 코드가 명확해 진다. +프로그래밍에서 상수로 선언하지 않은 숫자를 매직넘버라고 한다.
	     	* 잘못된 값을 사용함으로 인해 발생할 수 있는 위험성이 사라진다.
	   
	    */
	      
	    /*
	      형변환과 final
	      형변환이란 자료형의 타입을 변경하는 것이다. 예를 들어 "123"과 같은 문자열을 123과 같은 숫자형으로 바꾸는 것을 말한다.
	      
	     */
	       String num = "123";
	       int n = Integer.parseInt(num);  //int <= String 형변환
	       System.out.println(n); //123 출력
	       
	       num = "" + n; //가장 간단한 int => String 형변환
	       System.out.println(num); 
	       
	       // String.valueOf(정수), Integer.toString(정수) 모두 정수를 문자열로 바꾸어 리턴한다.
	       int ns = 13;
	       String num1 = String.valueOf(ns);
	       String num2 = Integer.toString(ns);
	       System.out.println(num1);  // 13 출력
	        System.out.println(num2);  // 13 출력
	        
	        // 소숫점이 포함된 숫자 형태의 문자열도 마찬가지로 Double.parseDouble 또는 Float.parseFloat로 형변환 가능
	        String Dounum = "123.456";
	        double d = Double.parseDouble(Dounum);
	        System.out.println(d);
	        
	        //정수와 실수 사이의 형변환
	        //d2 앞의 (int)는 d2의 자료형을 강제로 int 형으로 바꾼다는 의미이고 전문적인 용어로 캐스팅이라고 한다.
	        int n1 = 123;
	        double d1 = n1;  // 정수를 실수로 바꿀때에는 캐스팅이 필요없다.
	        System.out.println(d1);  // 123.0 출력

	        double d2 = 123.456;
	        int n2 = (int) d2; // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅해 주어야 한다.
	        System.out.println(n2);  // 소숫점이 생략된 123 출력
	        /*
	          // 실수 형태의 문자열을 정수로 변환할 경우 NumberFormatException이 발생한다.
	          String num = "123.456";
        	  int n = Integer.parseInt(num); 
        	  
        	  만약 바꾸고 싶다면 Double.parseDouble()을 사용하여 실수로 바꾼 후에 사용해야 한다.
	         */
	        /*
	         Final
	          자바의 Final은 자료형에 값을 단 한번만 설정할 수 있게 강제하는 키워드이다.
	          즉, 한번 값을 설정하면 그 값을 다시 설정할 수 없다는 말이다.
	         */
	        final int finaln = 123;
	         // finaln = 223; 컴파일 Error
	        
	        final ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b"));
	        // a = new ArrayList<>(Arrays.asList("c","d")); 에러
	        
	        /*
	         Unmodifiable List
	          리스트의 경우 final로 선언시 리스트에 값을 더하거나(add) 빼는(remove) 것은 가능하다. 다만 재할당만 불가능할 뿐이다.
	          만약 그 값을 더하거나 빼는 것도 불가능하게 하고 싶은 경우에는 List.of로 수정이 불가능한 리스트(Unmodifiable List)를 사용해아한다. 
	         */
	        final List<String> c = List.of("a", "b");
	        //c.add("c");  UnsupportedOperationException 발생
	        
	        HashMap<String, Integer> grade = new HashMap<>();
	        grade.put("A", 90);
	        grade.put("B", 80);
	        grade.put("C", 70);
	        
	        System.out.println(grade.remove("B"));
	        /*
	         	for each문
	         	 원래 알던 for문과 조건식 부분의 문법이 조금 다르다. 
	        */
	        String[] numbers = {"one", "two", "three"};
	        for(String number: numbers) {
	            System.out.println(number);
	        }
	        // for each문은 따로 반복횟수를 명시적으로 주는 것이 불가능하고, 1스탭씩 순차적으로만 반복할때 사용가능한 제약이 있음
	
	}

}
