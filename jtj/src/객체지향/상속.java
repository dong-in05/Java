package 객체지향;
	/*
	  	자바에는 자식 클래스가 부모 클래스의 기능을 그대로 물려받을 수 있는 상속(Inheritance) 기능이 있다. 
	  	예제를 통해서 자바의 상속에 대해서 자세히 알아보자.
	  
	  
	 */
	class Animals {
		String name;
		
		void setName(String name) {
			this.name =  name;
		}
	}

	class Dog extends Animals { // Animal 클래스를 상속한다.
		void sleep() {
			System.out.println(this.name+" "
					+ "zzz");
			
		}
	}
	
	class HouseDog extends Dog{
		void sleep() {
	        System.out.println(this.name + " zzz in house");
	    }
		void sleep(int hour) {
			System.out.println(this.name + " zzz in house for " + hour + " hours");
		}
	}
	
public class 상속 {
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("poppy");
		System.out.println(dog.name); // poppy 출력
		/*
		 	클래스 상속을 위해서는 extends 라는 키워드를 사용한다. 이제 Dog 클래스는 Animals 클래스를 상속하게 되었다. 
		 	Dog 클래스에 name 이라는 객체변수와 setName이라는 메서드를 만들지 않았지만 Animals 클래스를 상속했기 때문에
		 	예제에서 보듯이 그대로 사용이 가능하다.
		 	
		 	부모 클래스의 기능을 확장
		 	- Dog 클래스에 sleep 메서드를 추가함
		 */
		dog.sleep(); // poppy zzz 출력
		//이제 Dog 클래스는 Animals 클래스보다 좀 더 많은 기능(sleep 메서드가 추가되었다.)을 가지게 되었다. 이렇듯 보통 부모
		//클래스를 상속받은 자식 클래스는 부모 클래스의 기능에 더하여 좀 더 많은 기능을 갖도록 작성한다.
		
		/*
		 	IS-A 관계
		 	
		 	Dog 클래스는 Animals 클래스를 상속했다. 즉, Dog는 Animals의 하위 개념이라고 할 수 있다. 이런경우 Dog는 Animals에
		 	포함되기 때문에 "개는 동물이다"라고 표현할 수 있다. 자바는 이러한 관계를 IS-A관계라고 표현한다. 즉, " Dog is a Animals"과
		 	같이 말할 수 있는 관계를 IS-A관계라고 한다. 이렇게 IS-A관계(상속관계)에 있을 때 자식 클래스의 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다.
		 	
		 	즉 다음과 같이 코딩이 가능하다.
		 */
			Animals dog2 = new Dog();
			//주의 할 점은 Dog2 객체를 Animals 자료형으로 사용할 경우에는 Dog클래스에만 존재하는  sleep 메서드를 사용할 수 없다는 점이다
			// 이러한 경우 Animals 클래스에 구현된 setName 메서드만 사용이 가능하다.
			// 이 반대의 경우, 즉 부모 클래스로 만들어진 객체를 자식 클래스의 자료형으로는 사용할 수 없다.
			
			//  Dog dog = new Animal();  // 컴파일 오류: 부모 클래스로 만든 객체는 자식 클래스의 자료형으로 사용할 수 없다.
			/*
			 	Animals dog = new Dog(); // Dog is a Animals (O)
			 	"개로 만든 객체는 동물 자료형이다."
			 	
			 	Dog dog = new Animals(); // Animals is a Dog (X)
			 	"동물로 만든 객체는 개 자료형이다."
			 	
			 	동물로 만든 객체는 "개"자료형말고 "고양이" 자료형 또는 "호랑이" 자료형도 될 수 있지 않은가?
			 	개념적으로 두번째 코드는 성립할 수 없다는 것을 알 수 있다.
			 */
			
			/*
			 	Object 클래스
			 	
			 	자바에서 만드는 모든 클래스는 Object 클래스를 상속받는다. 사실 우리가 만든 Animal 클래스는 다음과 기능적으로
			 	완전히 동일하다. 하지만 굳이 아래 코드처럼 Object 클래스를 상속하도록 코딩하지 않아도 자바에서 만들어지는 모든 클래스는
			 	Object 클래스를 자동으로 상속 받게끔 되어 있다.
			 	
			 	class Animal extends Object {
			 		String name;
			 		
			 		void setName(String name){
			 			this.name = name;
			 		}
			 	}
			 	
			 	따라서 자바에서 만드는 모든 객체는 Object 자료형으로 사용할 수 있다. 즉, 다음과 같이 코딩하는 것이 가능하다.
			 	Object animal = new Animal(); // Animal is a Object
			 	Object dog = new Dog(); // Dog is a Object
			 
			 */
			
			/*
			 	메서드 오버라이딩 (Method overriding)
			 	
			 	Dog 클래스를 좀 더 구체화 시키는 HouseDog 클래스를 만들어 보자.
			 	 HouseDog 클래스는 Dog클래스를 상속하여 다음과 같이 만들수 있다.  
			 */
			HouseDog houseDog = new HouseDog();
			houseDog.setName("happy");
			houseDog.sleep(); // happy zzz 출력
			
			//만약 HouseDog 클래스로 만들어진 객체들은 sleep 메서드 호출 시 "happy zzz"가 아닌"happy zzz in house"를 출력해야 한다고 가정 해 보자.
			/*
				 HouseDog 클래스에 밑 코드 추가 
				 
				 void sleep() {
        			System.out.println(this.name + " zzz in house");
    			}
    			
    			이제 위에 코드 
    			houseDog.sleep()는  "happy zzz in house"를 출력한다.
    			
    			이렇게 부모클래스의 메서드를 자식클래스가 동일한 형태로 또다시 구현하는 행위를 메서드 오버라이딩(Method Overriding)이라고 한다.(메서드 덮어쓰기)
    			
			*/
			
			/*
			 	메서드 오버로딩(Method Overloading)
			 	
			 	이번에는 HouseDog 클래스에 다음과 같은 메서드를 추가해 보자.("변경"이 아니라 "추가"임에 주의하자.)			 
			 	void sleep(int hour) {
					System.out.println(this.name + " zzz in house for " + hour + " hours");
				}
				
				이미 sleep이라는 메서드가 있지만 동일한 이름의 sleep메서드를 또 생성할 수 있다. 단, 메서드의 입력항목이 다른 경우만
				가능하다. 새로 만든 sleep메서드는 입력항목으로 hour라는 int 자료형이 추가되었다.
				
				이렇듯 입력항목이 다른 경우 동일한 이름의 메서드를 만들 수 있는데 이를 메서드 오버로딩(method overloading)이라고 부른다.
				새로 만든 sleep 메서드를 실행 해 보자.
			 */
				houseDog.sleep(3);
			
			
			
	}

}
