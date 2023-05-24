package 객체지향;


	class Updater {
	    void update(int count) {
	        count++;
	    }
	}

	class Counter {
	    int count = 0;  // 객체변수
	}
	
	class Updater2 {
	    void update2(Counter counter) {
	        counter.count++;
	    }
	}
	
public class Call_by_value {
	/*
	  Call by value 
	  	메서드에 객체를 전달할 경우 메서드에서 객체의 객체변수(속성) 값을 변경할 수 있다.
	  
	  	한 개의 자바파일에 2개 이상의 클래스 선언하기
	  	- Call_by_value.java라는 파일 내에 Update, Counter, Call_by_value 클래스 3개가 생성되었다.
	  	  이것은 조금 특이하지만 물론 가능한 코드이다. 하나의 java파일내에는 여러개의 클래스를 선언할 수 있다.
	  	  단 파일명이 Call_by_value.java라면 Call_by_value.java 내의 Call_by_value 클래스는 public 으로 선언하라는 관례(규칙)가 있다.
	 */
	
	public static void main(String[] args) {
		Counter myCounter = new Counter();
        System.out.println("before update:"+myCounter.count);
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter.count);
        System.out.println("after update:"+myCounter.count);
        
        Counter myCounter2 = new Counter();
        System.out.println("before update:"+myCounter2.count); // 0 출력
        Updater2 myUpdater2 = new Updater2();
        myUpdater2.update2(myCounter2);
        System.out.println("after update:"+myCounter2.count); // 1 출력
        
        /*
         	메서드의 입력으로 객체를 전달받는 경우에는 메서드가 입렵받은 객체를 그대로 사용하기 때문에 메서드가 객체의
         	속성값을 변경하려면 메서드 수행 후에도 겍체의 변경된 속성값이 유지된다.
         
         
         */
	}

}
