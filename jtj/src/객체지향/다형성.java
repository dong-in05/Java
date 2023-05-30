package 객체지향;
interface Predator2{
	String getFood();
	
	default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
	
	int LEG_COUNT = 4;  // 인터페이스 상수

    static int speed() {
        return LEG_COUNT * 30;
    }
}
interface Barkable{
	void bark();
}

class Animal2{
	String name;
	
	void setName(String name) {
		this.name = name;
	}
}

class Tiger2 extends Animal2 implements Predator, Barkable{
	public String getFood() {
        return "apple";
    }
	public void bark(){
		System.out.println("어흥");
	}
}
class Lion2 extends Animal2 implements Predator, Barkable{
	public String getFood() {
        return "banana";
    }
	public void bark(){
		System.out.println("으르렁");
	}
}

class ZooKeeper2{

	void feed(Predator predator) {
		System.out.println("feed "+ predator.getFood());
	}
	
}

class Bouncer {
	/*
	 * 변경 전
	 	if (animal instanceof Tiger) {
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        }
	 
	 */
	// 변경 후
	void barkAnimal(Barkable animal) { // Animal 대신 Barkable 사용
		animal.bark();
	}
}

public class 다형성 {
	/*
	 	다형성(폴리모피즘, Polymorphism)
	 	 객체지향 프로그래밍의 특징 중에서는 다형성이 있다. 도대체 다형성은 무엇이고 이게 왜 필요한건지 알아보자
	 	 
	 	 경비원 클래스는 동물을 짖게(barkAnimal) 하여 건물을 지킨다고 한다.
	 	 barkAnimal 메서드는 입력으로 받은 객체가 Tiger인 경우 "어흥"을 출력하고 Lion일 경우 "으르렁"을 출력한다.
	 	 instanceof는 어떤 객체가 특정 클래스의 객체인지를 조사할 때 사용되는 자바의 내장 명령어이다.
	 	 
	 	 ***animal instanceof Tiger는 "Animal 객체는 Tiger 클래스로 만들어진 객체인가?"를 묻는 조건문이다.
	 	 
	 	 IS-A 관계
	 	 barkAnimal 메서드의 입력자료형은 Tiger나 Lion이 아닌 Animal이다. 하지만 barkAnimal 메서드를 호출할 때는
	 	 tiger 또는 lion객체를 전달할 수가 있다. 이게 가능한 이유는 Tiger,Lion 클래스가 Animal이라는 부모 클래스를 상속한 
	 	 자식 클래스이기 때문이다. 자식 클래스에 의해서 만들어진 객체는 언제나 부모 클래스의 자료형으로 사용할 수가 있다.
	 	 (앞서 나왔던 IS-A 관계를 생각해보자.)
	 	 
	 	 Animal tiger = new Tiger(); // Tiger is a Animal
	 	 Animal Lion = new Lion(); // Lion is a Animal
	 	
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Tiger2 tiger = new Tiger2();
			Lion2 lion = new Lion2();
			
			Bouncer bouncer = new Bouncer();
			bouncer.barkAnimal(tiger);
			bouncer.barkAnimal(lion);
			
			//인터페이스를 활용해 더 나은 해법을 찾아보자
			/*
			 	인터페이스는 위에서 보듯이 콤마(,)를 이용하여 여러개를 implements 할 수 있다. Tiger, Lion 클래스는 Predator 인터페이스와 
			 	Barkable 인터페이스를 implements 하였다. 따라서 Tiger, Lion 클래스는 bark 메서드를 위와 같이 구현해야 한다.
			 	이렇게 Tiger, Lion 클래스에 bark 메서드를 구현하면 Bouncer 클래스의 barkAnimal 메서드를 위처럼 수정할 수 있다.
			 	
			 	barkAnimal 메서드의 입력 자료형이 Animal에서 Barkable로 변경되었다. 그리고 animal의 객체 타입을 체크하여 "어흥" 또는
			 	"으르렁"을 출력하던 부분을 그냥 bark 메서드를 호출하도록 변경했다. 이렇게 변경했더니 복잡하던 조건분기문도 사라지고 누가봐도 명확한
			 	코드가 되었다.
			 	
			 	폴리모피즘을 이용하면 위의 예에서 보듯이 복잡한 형태의 분기문을 간단하게 처리할 수 있는 경우가 많다.
			 	
			 	위에서 사용한 tiger, lion 객체는 각각 Tiger,Lion 클래스의 객체이면서 Animal 클래스의 객체이기도 하고 Barkable, Predator
			 	인터페이스의 객체이기도 하다. 이러한 이유로 barkAnimal 메서드의 입력 자료형을 Animal에서 Barkable로 바꾸어 사용할 수 있는 것이다.
			 	
			 	**이렇게 하나의 객체가 여러개의 자료형 타입을 가질 수 있는 것을 객체지향에서는 다형성(Polymorphism)이라고 한다.**
			 
			 */
			Tiger2 tiger2 = new Tiger2(); // Tiger is a Tiger
			Animal2 animal = new Tiger2(); // Tiger is a Animal
			Predator predator = new Tiger2(); // Tiger is a Predator
			Barkable barkable = new Tiger2(); // Tiger is a Barkable
			
			/*
			 	Predator로 선언된 predator객체와 Barkable로 선언된 barkable 객체는 사용할 수 있는 메서드가 서로 다르다는 점이다. predator 객체는 getFood()
			 	메서드가 선언된 Predaor 인터페이스의 객체이므로 getFood 메서드만 호출이 가능하다. 이와 마찬가지로 Barkable로 선언된 객체는 bark 메서드만 호출이 가능하다.
			 	
			 	getFood 메서드와 bark 메서드를 모두 사용하고 싶다면 
			 	
			 	Predator, Barkable 인터페이스를 구현한 Tiger로 선언된 tiger 객체를 그대로 사용하거나 다음과 같이 getFood,bark 메서드를 모두 포함하는
			 	새로운 인터페이스를 새로 만들어 사용하면 된다.
			 */
			
	}

}
