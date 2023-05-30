package 객체지향;
	
	//다른 클래스 파일에 이미 선언한 클래스이름 때문에 조금씩 다르게 설정함

	class Ani_mals {
		String name;
		
		void setName(String name) {
			this.name = name;
		}
	}
	
	class Dogs extends Ani_mals {
		void sleep() {
			System.out.println(this.name + " zzz");
		}
	}
	
	class HouseDogs extends Dogs {
		HouseDogs(String name) {
	        this.setName(name);
	    }
		
		HouseDogs(int type){
			if(type == 1) {
				this.setName("yorkshire");
			} else if (type == 2) {
				this.setName("bulldog");
			}
		}
		
		void sleep() {
			System.out.println(this.name + " zzz in house");
		}
		
		void sleep(int hour) {
			System.out.println(this.name + " zzz in house for " + hour + " hour");
		}
	}

public class 생성자_Constructor {

	public static void main(String[] args) {
		// HouseDogs dog = new HouseDogs(); // System.out.println(dog.name); // null 출력
		HouseDogs dog = new HouseDogs("happy");
        System.out.println(dog.name); // happy 출력
       /*
        	dog 객체의 name 변수에 아무런 값도 설정하지 않았기 때문에 null이 출력될 것이다.
        	
        	이렇듯 HouseDogs 클래스는 코딩하기에 따라 객체변수 name에 값을 설정할 수도 있고 설정 안할 수도 있다. 그렇다면
        	name이라는 객체 변수에 값을 무조건 설정해야만 객체가 생성될 수 있도록 강제할 수 있는 방법은 없을까?
        	
        	생성자(Constructor)를 이용하면 된다.
        	
        	HouseDog 클래스 가장 상단에 다음과 같은 메서드를 추가해 보자.
        
        		HouseDog(String name) {
        			this.setName(name);
    			}	
    		위 메서드처럼 메서드명이 클래스명과 동일하고 리턴 자료형을 정의하지 않는 메서드를 생성자(Construtor)라고 한다.
    		
    		**생성자의 규칙**
    		1. 클래스명과 메서드명이 동일하다.
    		2. 리턴타입을 정의하지 않는다. (void도 사용하지 않는다)
    		
    		생성자는 객체가 생성될 때 호출된다. 즉, 생성자는 다음과 같이 new 키워드가 사용될 때 호출된다.
    		* new 클래스명(입력인수, ...)
    		HouseDog 클래스에 만든 생성자는 다음과 같이 입력값으로 문자열을 필요로 하는 생성자이다.
    			HouseDog(String name) {
    				this.setName(name);
    			}
    		따라서 다음과 같이 문자열을 전달해야 한다.
    			HouseDog dog = new HouseDog("happy"); // 생성자 호출 시 문자열을 전달해야 한다.
    		만약 다음과 같이 한다면 컴파일 오류 발생
    			HouseDog dog = new HouseDog();
    		- 오류 발생의 이유는 객체 생성 방법이 생성자의 규칙과 맞지 않기 때문에
    			생성자가 선언된 경우 생성자의 규칙대로만 객체를 생성할 수 있다.
        */
        
        /*
         	디폴트(default) 생성자
         	
         	다음 코드를 보자. 
         	class Dog extends Animal {
    			void sleep() {
        			System.out.println(this.name + " zzz");
    			}
			}
	
			그리고 다음 코드를 보자.
			class Dog extends Animal {
    			Dog() {
    			}

    			void sleep() {
        			System.out.println(this.name + " zzz");
    			}
			}
         
         	위 두 코드의 차이점이 무엇일까? 두번 쨰 코드에는 생성자가 구현되어 있다. 생성자의 입력 항목이 없고 생성자 
         	내부에 아무 내용이 없는 위와 같은 생성자를 디폴트(default) 생성자라고 부른다.
         	
         	위와 같이 디폴트 생성자를 구현하면 new Dog()로 Dog 클래스의 객체가 만들어 질 때 위에 구현한 디폴트 생성자가 실행될 것이다. 
         	만약 클래스에 생성자가 하나도 없다면 컴파일러는 자동으로 위와 같은 디폴트 생성자를 추가한다. 하지만 사용자가 작성한 생성자가
         	하나라도 구현되어 있다면 컴파일러는 디폴트 생성자를 추가하지 않는다.
         	
         	+ 이러한 이유로 위에서 살펴본 HouseDog 클래스에 name을 입력으로 받는 생성자를 만든 후에 new HouseDog() 는 사용할 수 없다.
         	  왜냐하면 HouseDog 클래스에 이미 생성자를 만들었기 때문에 컴파일러는 디폴트 생성자를 자동으로 추가하지 않기 때문이다.
         	  만약 new HouseDog()도 가능하게 하려면 디폴트 생성자를 수동으로 추가해야 한다.
         */
       
        /*
         	생성자 오버로딩 
         	 메서드에 오버로딩이 있는 것과 마찬가지로 생성자에도 오버로딩이 있다.
         	 - 하나의 클래스에 여러개의 입력항목이 다른 생성자를 만들 수 있다.
         	
         	HouseDogs(int type){
			if(type == 1) {
				this.setName("yorkshire");
			} else if (type == 2) {
				this.setName("bulldog");
			}
		}
         */
        HouseDogs happy = new HouseDogs("happy");
        HouseDogs yorkshire = new HouseDogs(1);
        HouseDogs bulldog = new HouseDogs(2);
        System.out.println(happy.name); // happy 출력
        System.out.println(yorkshire.name); // yorkshire 출력
        System.out.println(bulldog.name);
        
        /*
         	위의 HouseDogs 클래스는 두 개의 생성자가 있다. 하나는 String 자료형을 입력으로 받는 생성자이고 다른 하나는 int 자료형을 
         	입력 받는 생성자이다. 두 생성자의 차이는 입력 항목이다. 이렇게 입력 항목이 다른 생성자를 여러 개 만들 수 있는데 이런 것을
         	생성자 오버로딩(Overloading)이라고 한다.
         	
         	메서드 오버로딩과 동일한 개념이다.
         	
         	HouseDog 클래스의 객체는 다음처럼 두 가지 방법으로 생성할 수 있다.
         	HouseDog happy = new HouseDog("happy");
         	HOuseDog yorkshire = new HouseDog(1);
         
         
         */
        
	}

}
