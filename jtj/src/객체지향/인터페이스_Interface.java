package 객체지향;

interface Predator{
	String getFood();
	
	default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
	
	int LEG_COUNT = 4;  // 인터페이스 상수

    static int speed() {
        return LEG_COUNT * 30;
    }
}

class Animal_s{
	String name;
	
	void setName(String name) {
		this.name = name;
	}
}

class Tiger extends Animal_s implements Predator{
	public String getFood() {
        return "apple";
    }
}
class Lion extends Animal_s implements Predator{
	public String getFood() {
        return "banana";
    }
}
class ZooKeeper{
/*
	void feed(Tiger tiger) { //호랑이가 오면 사과를 던져 준다.
		System.out.println("feed apple");
	}
	void feed(Lion lion) { //사자가 오면 바나나를 던져 준다.
		System.out.println("feed banana");
	}
*/
	//변경
	void feed(Predator predator) {
		System.out.println("feed "+ predator.getFood());
	}
	
}
public class 인터페이스_Interface {
	/*
	  인터페이스(Interface)는 왜 필요한가?
	  
	  다음은 어떤 동물원 사육사가 하는 일이다.
	  
	  	난 동물원의 사육사이다.
	  	육식동물이 들어오면 난 먹이를 던져준다.
	  	호랑이가 오면 사과를 던져준다.
	  	사자가 오면 바나나를 던져준다.
	  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZooKeeper zooKeeper = new ZooKeeper();
		
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		zooKeeper.feed(tiger);
		zooKeeper.feed(lion);
		
		// 동물원에 호랑이와 사자뿐이라면 ZooKeeper 클래스는 더 이상 할 일이 없겠지만 악어, 표범등이 계속 추가된다면
		// ZooKeeper는 육식동물이 추가 될때마다 매번 feed 메서드를 추가해야 한다.
		// 이러한 어려움을 극복하기 위해서는 인터페이스의 도움이 필요하다
		
		//Line 1과 같이 class가 아닌 interface라는 키워드로 작성한다
		/*
		 	인터페이스는 클래스와 마찬가지로 Predator.java와 같은 단독 파일로 저장하는 것이 일반적인 방법이다. 여기서는
		 	설명의 편의를 위해 이 클래스 파일의 최상단에 작성하였다.
		 	
		 	그리고  Tiger, Lion 클래스는 작성한 인터페이스를 구현하도록 (implements) 수정하자.
		 	+ implements 추가함
		 	
		 	Tiger, Lion 클래스가 Predator 인터페이스를 구현하게 되면 ZooKeeper 클래스의 feed 메서드를 다음과 같이 변경할 수 있다.
		 	
		 	변경 전
		 	class ZooKeeper {
    			void feed(Tiger tiger) {
        		System.out.println("feed apple");
    			}
    		}
    		변경 후
    		class ZooKeeper {
    			void feed(Predator predator) {
        			System.out.println("feed apple");
    			}
			}
			
			ZooKeeper 클래스에 약간의 문제가 발생한다. feed 메서드를 보면 호랑이가 오던지, 사자가 오던지 무조건 "feed apple"이라는
			문자열을 출력한다. 사자가 오면 "feed banana"를 출력해야 하지 않겠는가!
			
			Predator 인터페이스에 다음과 같은 메서드를 추가해보자
			interface Predator {
    			String getFood();
			}
			getFood라는 메서드를 추가했다. 이상한 점이 있다 메서드에 몸통이 없다!?
			
			인터페이스의 메서드는 메서드의 이름과 입출력에 대한 정의만 있고 그 내용은 없다. 그 이유는 인터페이스는 규칙이기 때문이다.
			위에서 설정한 getFood라는 메서드를 추가하면 Tiger, Lion등의 Predator 인터페이스를 구현한 클래스들에서 컴파일 오류가 발생할 것이다.
			그 오류를 해결하려면 다음처럼 Tiger, Lion 클래스에 getFood메서드를 구현해야 한다.
			
			각각 추가
			public String getFood() {
        		return "apple";
    		}
    		
    		**인터페이스 메서드는 항상 public으로 구현해야 한다.
    		 Tiger, Lion 클래스의 getFood 메서드에 육식동물의 먹이인 "apple", "banana"를 각각 리턴하도록 작성했다. 이렇게
    		 getFood 메서드를 추가하면 컴파일 오류가 해결될 것이다.
		 */
		zooKeeper.feed(tiger); //feed apple
		zooKeeper.feed(lion); //feed banana
		//알맞게 출력된다 ㅎㅎ
		
		/*
		 	인터페이스의 핵심과 개념
		 	
		 	육식 동물들의 종류만큼의 feed메서드가 필요했던 Zookeeper 클래스를 Predator 인터페이스를 이용하여 구현했더니
		 	단 한개의 feed 메서드로 구현이 가능해 졌다. 여기서 중요한 점은 메서드의 갯수가 줄어들었다는 점이 아니라 ZooKeeper
		 	클래스가 동물들의 종류에 의존적인 클래스에서 동물들의 종류와 상관없는 독립적인 클래스가 되었다는 점이다. 바로 이 점이 
		 	인터페이스의 핵심이다.
		 	
		 	좀 더 개념적으로 인터페이스를 생각해보자면 컴퓨터의 USB포트에 연결할 수 있는 기기는 하드디스크, 메모리스틱, 스마트폰 등 무척
		 	많다. 바로 이 USB포트가 물리적 세계의 인터페이스라고 할 수 있다. USB포트의 규격만 알면 어떤 기기도 만들 수 있다. 또 컴퓨터는
		 	USB 포트만 제공하고 어떤 기기가 만들어지는지 신경쓸 필요가 없다. 바로 이 점이 인터페이스와 매우 비슷하다. 위에서 만든 사육사(ZooKeeper)가 어떤
		 	육식동물(Tiger,Lion...)이던지 상관하지 않고 먹이를 주는 것 처럼
		 	
		 	다음은 이해를 돕기위한 비교표 이다
		 	[   물리적 세계   ]      [   자바세계   ]
		 		  컴퓨터				ZooKeeper
		 		 USB 포트				Predator
		 	하드디스크, 디지털 카메라 	Tiger, Lion, Crocodile...
		  
		 +tip 
		 	상속과 인터페이스
		 	-위에서 작성한 Predator 인터페이스 대신 Animal 클래스에 getFood 메서드를 추가하고 Tiger, Lion 등에서 getFood
		 	 메서드를 오버라이딩한 후 ZooKeeper의 feed 메서드가 Predator 대신 Animal을 입력 자료형으로 사용해도 동일한 효과를 거둘 수 있다.
		 	 하지만 상속은 자식 클래스가 부모 클래스의 메서드를 오버라이딩하지 않고 사용할 수 있기 때문에 해당 메서드를 반드시 구현해야 한다는 "강제성"을 갖지 못한다.
		 	 상황에 맞게 상속을 사용할 것인지 인터페이스를 사용해야 할 지를 결정해야겠지만 인터페이스의 메서드를 반드시 구현해야하는 "강제성"을 갖는다는 점을 반드시 기억하자.
		  
		 */
		
		/*
		 	자바8 버전 이후부터는 디폴트 메서드(default mathod)를 사용할 수 있다. 인터페이스의 메서드는 몸통(구현체)을 가질 수 없지만 디폴트 메서드를 사용하면 
		 	실제 구현된 형태의 메서드를 가질 수 있다.
		 	
		 	예를들어 Predator 인터페이스에 다음과 같은 디폴트 메서드를 추가할 수 있다.
		 	default void printFood() {
		        System.out.printf("my food is %s\n", getFood());
		    	
		    디폴트 메서드는 메서드명 가장 앞에 "default" 라고 표기해야 한다. 이렇게 Predator 인터페이스에 printFood 디폴트 메서드를 구현하면
		     Predator 인터페이스를 구현한 Tiger, Lion 등의 실제 클래스는 printFood 메서드를 구현하지 않아도 사용할 수 있다. 그리고 디폴트
		     메서드는 오버라이딩이 가능하다. 즉, printFood 메서드를 실제 클래스에서 다르게 구현하여 사용할수 있다.
		    }
		 */
		
		/*
		 	스태틱 메서드
		 	
		 	자바8 버전 이후부터는 인터페이스에 스태틱 메서드(static method)를 사용할 수 있다. 인터페이스에 스태틱 메서드를 구현하면 Predator 
		 	인터페이스를 구현하면 인터페이스명.스태틱메서드명 과 같이 사용하여 일반 클래스의 스태틱 메서드를 사용하는 것과 동일하게 사용할 수 있다.
		 	
		 	int LEG_COUNT = 4; //인터페이스 상수
		 	
		 	static int speed(){
		 		return LEG_COUNT * 30;		 	
		 	}
		 	
		 	이렇게 스태틱 메서드를 추가하면 다음과 같이 사용할 수 있다.
		 */
		System.out.println(Predator.speed()); // 120출력
		
		/*
		 	인터페이스 상수
		 	위 코드에서 사용한 int LEG_COUNT = 4; 문장은 인터페이스에 정의한 상수이다. 인터페이스에 정의한 상수는 int LEG_COUNT = 4; 처럼
		 	public static final을 생략해도 자동으로 public static final이 적용된다. (다른 형태의 상수 정의는 불가능하다.)
		 */
		
	}

}
