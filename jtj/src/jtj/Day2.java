package jtj;

class Animal{
	//Animal 클래스에 name 이라는 String 변수를 추가했다. 
	//이렇게 클래스에 선언된 변수를 객체 변수 라고 한다.
	//객체 변수는 인스턴스 변수, 멤버 변수, 속성이라고도 한다.
	String name;
	
		public void setName(String name) {
			this.name = name;
		}
	}

public class Day2 {
	public static void main(String[] args) {
		/*
 			클래스
 			 클래스에 의해서 만들어진 객체를 인스턴스라고도 한다. 그렇다면 객체와 인스턴스의 차이는 무엇일까?
 			 
 			 이렇게 생각 해 보자. Animal cat = new Animal() 이렇게 만들어진 cat은 객체이다.
 			 그리고 cat이라는 객체는 Animal의 인스턴스(instance) 이다. 인스턴스라는 말은 특정 객체(cat)가
 			 어떤 클래스(Animal)의 객체인지를 관계위주로 설명할 때 사용된다. 즉, "cat은 인스턴스" 보다는 "cat은 객체"라는
 			 표현이 "cat은 Animal의 객체" 보다는 "cat은 Animal의 인스턴스" 라는 표현이 훨씬 잘 어울린다.
 			 [출처 : 점프 투 자바 05-02 클래스]
 			 
     	*/
		// 과자틀 => 클래스(class)
		// 과자틀에 의해서 만들어진 과자들 => 객체(Object)
		// 클래스에 의해 생성되는 것은 객체, 그리고 그 클래스에 선언된 변수는 객체 변수라고 생각하면 쉽다.
			Animal cat = new Animal();
			Animal dog = new Animal();
			Animal horse = new Animal();
		//객체 변수는 다음과 같이 도트연산자(.)를 이용하여 접근할 수 있다.
		//객체.객체변수
		//Animal cat = new Animal() 처럼 cat 이라는 객체를 생성했다면 이 cat 객체의 변수 name에는 다음과 같이 접근한다
		//cat.name ..객체: cat, 객체변수: name
			//Animal cat = new Animal(); 어떤 값이 대입되어 있는가
			System.out.println(cat.name); // null 출력
		
		//Animal 클래스에 추가된 setName 메서드는 다음과 같은 형태의 메서드이다.
			// 입력: String name
			// 출력: void(리턴값 없음)
		// 즉 입력으로 name이라는 문자열을 받고 출력은 없는 형태의 메서드이다.
		// 도트 연산자와 마찬가지로 객체.메서드 로 호출해야 한다.
			cat.setName("부들이"); //문자열로 하는 이유는 setName 메서드는 입력항목으로 문자열(String)을 필요
			System.out.println(cat.name); //부들이 출력
		//main메서드에서 cat.setName("부들이")와 같이 "부들이"라는 입력값으로 setName 메서드를 호출했기 때문에
		//setName 함수의 입력항목 name에는 "부들이"라는 문자열이 전달될 것이다.
		//this.name = "부들이";
			//this는 Animal 클래스에 의해서 생성된 객체를 지칭한다. cat객체에 의해 setName 메서드를 호출하면
			//setName 메서드 내부에 선언된 this는 바로 cat 객체를 가리킨다. 
			//따라서 this.name = "부들이";는 다음과 같이 해석된다. cat.name = "부들이"
			
			
			
	
	}

}
