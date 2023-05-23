package jtj;

class Animal{
	//Animal 클래스에 name 이라는 String 변수를 추가했다. 
	//이렇게 클래스에 선언된 변수를 객체 변수 라고 한다.
	//객체 변수는 인스턴스 변수, 멤버 변수, 속성이라고도 한다.
	String name;
	}

public class Day1Class {
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
		// 객체.객체변수
	}

}
