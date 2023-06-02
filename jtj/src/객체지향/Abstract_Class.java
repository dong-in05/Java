package 객체지향;

public class Abstract_Class {
	/*
	 	추상 클래스 Abstract_Class
	 	
	 	인터페이스의 역할도 하면서 클래스의 기능도 가지고 있는 자바의 돌연변이 같은 클래스
	
	*/
	abstract class Predator extends Animal {
		abstract String getFood();
		
		void printFood() {
			System.out.printf("my food is %n", getFood());
		}
		
		static int LEG_COUNT = 4; // 추상 클래스의 상수는 static 선언이 필요하다.
		static int speed() {
			return LEG_COUNT * 30;
		}
		/*
		 	추상클래스를 만들기 위해서는 class 앞에 abstract 라고 표기해야함 또한 인터페이스의 메서드와 같은 역할을 하는 메서드
		 	(getFood 메서드)에도 abstract를 붙여야한다. abstract 메서드는 인터페이스의 메서드와 마찬가지로 몸통이 없다.
		 	abstract 클래스를 상속하는 클래스에서 해당 abstract 메서드를 구현해야만 하는 것이다. 그리고 Animal 클래스의 기능을 유지
		 	하기 위해 Animal 클래스 상속  
		 	
		 	 + LEG_COUNT 상수도 인터페이스에서는 자동으로 static으로 인식하지만 추상 클래스는 명시적으로 static 이라고 적어 주어야 한다.
		 	 
		 	 + 추상 클래스는 일반 클래스와는 달리 단독으로 객체 생성이 불가능하다. 반드시 추상 클래스를 상속한 실제 클래스를 통해서만 객체 생성 가능하다.
		 
		 */
		
	}
	public static void main(String[] args) {
		
		
		//어렵다 어려워
	}

}
