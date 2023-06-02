package 객체지향;

public class Method {
	// Method (메서드)
	// 자바는 메서드와 함수를 구분하여 말하지 않는다. 자바에서 사용되는 함수의 정확한 명칭은 메서드이다.
	// 메서드는 믹서기와 같다. 믹서기에 과일을 넣고 믹서를 이용해 과일을 갈아 과일쥬스를 만든다.
	// 믹서기에 넣는 과일은 입력이 되고 과일 쥬스는 그 출력(리턴값)이 된다.
	// 여기서 믹서기가 Method(메서드)이다.
	
	/*
	   메서드를 사용하는 이유?
		여러번 반복해서 사용되는 부분을 한 뭉치로 묶어 "어떤 입력값을 주었을 때 어떤 리턴값을 돌려준다"라는 식의 메서드를 작성하는 것이 현명한 일이다.
	*/	
	//간단한 메서드

		int sum1(int a, int b) { // a,b는 매개변수
			return a+b;
		}
		
		String say() {
			return "Hi";
		}
		
		void sum2(int a, int b) {
			System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
		}
		void say2() {
			System.out.println("Hi");
		}
		void sayNick(String nick) {
			if("fool".equals(nick)) {
				return;
			}
			System.out.println("나의 별명은 "+nick+" 입니다.");
		}
		int varTest(int a) {
			a++;
			return a;
		}
	// 위 메서드 정의 sum 메서드는 입력값으로 두개의 값(int 자료형 a, int 자료형 b)을 받으며 리턴값은 두 개의 입력값을 더한 값(int 자료형)이다.
	// return은 메서드의 결과 값을 돌려주는 명령어
		public static void main(String[] args) {
			int a = 3;
			int b = 4;
			
			Method sumnum = new Method();
			int c = sumnum.sum1(a, b); // 3, 4는 인수
			
			System.out.println(c); // 출력 7
			// 매개변수 - 메서드에 전달된 값을 저장하는 변수
			// 인수 - 메서드에 전달하는 값
			/*
			 
			  메서드의 입력값과 리턴값
			  입력값 ---> 메서드(블랙박스) ---> 리턴값
			  
			  메서드의 구조
			  리턴자료형 메서드명(입력자료형1 매개변수1, 입력자료형2 매개변수2, ...){
			  		
			  		....
			  		return 리턴값;	
			 	}
			  	리턴자료형은 메서드 수행 후 돌려줄 값의 자료형을 의미한다.
			  	메서드의 리턴값은 return이라는 명령을 사용한다.
			  	
			  	메서드 입출력 유무에 따라 다음과 같이 4가지로 분류
			  	- 입력과 출력이 모두 있는 메서드
			  	- 입력과 출력이 모두 없는 메서드
			  	- 입력은 없고 출력은 있는 메서드
			  	- 입력은 있고 출력은 없는 메서드
			  
			 */
			/*
			 일반적인 메서드
			 입력 값이 있고 리턴값이 있는 메서드가 일반적인 메서드이다.
			 	
			 	int sum(int a, int b){
			 			return a+b;
			 		}
			 - 입력 값 - int 자료형 a, int 자료형 b
			 - 리턴 값 - int 자료형
			 
			 리턴값받을변수 = 객체.메서드명(입력인수1, 입력인수2, ..)
			 
			 sum 메서드의 사용예
			 	Sample sample = new Sample();
			 	int result = sample.sum(3, 4);
			 
			 */
			//입력 값이 없는 메서드
			
			Method Hi = new Method();
			String z = Hi.say();
			System.out.println(z + " 홍동인"); // "Hi" 출력
			System.out.println(z + z); 
			// 메서드 출력할때 다른거 붙여서 출력이 가능하네 메서드도 붙일 수 있나? 된다
			
			//String  z = Hi.say() 처럼 하면 z에는 "Hi"라는 문자열이 대입될 것이다.
			//즉, 입력값이 없고 리턴값만 있는 메서드는 다음과 같이 사용된다.
			// 리턴값받을변수 = 객체.메서드명()
			// 
			
			//리턴값이 없는 메서드 메서드 
			//위치 24Line
			
			Method sum = new Method();
			sum.sum2(3, 4); 
			// 출력 : 3과 4의 합은 7입니다.
			// 객체.메서드명(입력인수1, 입력인수2, ...)
			//입력 값 - int 자료형 a, int 자료형 b
			//리턴 값 - void (없음)
			
			//입력값도 리턴값도 없는 메서드
			// 27Line
			Method Hi2 = new Method();
			Hi2.say2();
			//입력 값 - 없음
			//리턴 값 - void(없음)
			//객체.메서드명()
			
			//return의 다른 쓰임새
			//특별한 경우에 메서드를 빠져나가고 싶다면 return을 단독으로 사용하여 메서드를 즉시 빠져나갈 수 있다.
			//30Line
			Method sayNick = new Method();
			sayNick.sayNick("angel");
			sayNick.sayNick("fool"); //출력되지 않는다
			//fool이라는 값이 들어오면 문자열을 출력하지 않고 바로 메서드를 빠져나간다.
			// return 문만 단독으로 사용하여 메서드를 빠져나가는 이 방법은 리턴 자료형이 void인 메서드에만 해당된다.
			// 리턴 자료형이 명시되어 있는 메서드에서 return문만 작성하면 컴파일 오류가 발생한다.
			
			/*
			 	메서드 내에서 선언된 변수의 효력 범위
			 		메서드 안에서 사용하는 변수의 이름을 메서드 밖에서 사용한 이름과 동일하게 사용한다면 어떻게 될까?
			 		
			 		public class Sample {
			 			void varTest(int a){
			 				a++;
			 			}
			 			
			 			public static void main(String[] args) {
			 				int a = 1;
			 				Sample sample = new Sample();
			 				sample.varTest(a);
			 				System.out.println(a);
			 			}
			 		}
			 		
			 		varTest 메서드는 입력으로 들어온 int자료형의 값을 1만큼 증가시키는 역할을 한다.
			 		
			 		먼저 main메서드에서 a라는 int 자료형의 변수를 생성하고 1을 대입했다. 그리고
			 		varTest 메서드를 입력 값 a를 주어 호출했다.그 다음에 a의 값을 출력하게 하였다.
			 		당연히 varTest 메서드에서 a의 값을 1만큼 증가시켰으니 2가 출력되어야 할 것 같지만 
			 		프로그램을 실행시켜 보면 1이라는 결과 값이 나온다.
			 		
			 		이유 -> 메서드에서 사용한 매개 변수는 메서드 안에서만 쓰여지는 변수이기 때문이다. 즉 public void varTest(int a) 라는 
			 		문장에서 매개변수 a는 메서드 안에서만 쓰이는 변수이지 메서드 밖의 변수 a가 아니라는 말이다.
			 		
			 		+tip
			 		하지만 varTest 입력값이 int 자료형이 아닌 객체였다면 얘기가 다르다. 객체를 메서드의 입력으로 넘기고 메서드가 객체의 속성값(객체변수 값)을
			 		변경한다면 메서드 수행 이후에도 객체는 변경된 속성값을 유지한다. 이러한 차이가 나는 이유는 메서드에 전달하는 입력 자료형의 형태 때문인데 
			 		메서드에 값을 전달하느냐 아니면 객체를 전달하느냐에 따라 차이가 난다.
			 */
			
			//varTest라는 메서드를 이용해서 메서드 외부의 a의 값을 1만큼 증가시킬 수 있는 방법
			//36Line
			int x = 1;
			Method varTest = new Method();
			x = varTest.varTest(x);
			System.out.println(x); // 출력 2
			
			/*
			  tip에서 언급한 객체를 넘기는 방법
			  
			  public class Sample {
			  		
			  	int a; //객체 변수 a
			  		
			  	void varTest(Sample sample) {	
			  		sample.a++
			  	}
			  	
			  	public static void main(String[] args) {
			  		Sample sample = new Sample();
			  		sample.a = 1;
			  		sample.varTest(sample);
			  		System.out.println(sample.a); //출력 2;
			  		
			  	}
 			  		
			  int 자료형인 a변수를 Sample 클래스의 객체변수로 선언했다. 그리고 varTest 메서드는 Sample 클래스의 객체를
			  입력받아 해당 객체의 객체변수 a의 값을 1만큼 증가시키도록 했다. 그리고 main메서드에서는 varTest메서드 호출 시
			  Sample 클래스의 객체인 sample을 전달하도록 수정했다.
			  
			  varTest 메서드의 입력 파라미터가 값이 아닌 Sample 클래스의 객체라는데 있다. 이렇게 메서드가
			  객체를 전달 받으면서 메서드 내의 객체는 전달받은 객체 그 자체로 수행된다. 따라서 입력으로 전달받은 sample 객체의
			  객체 변수 a의 값이 증가하게 되는 것이다.
			  
			  메서드의 입력항목이 값인지 객체인지 구별하는 기준은 입력항목의 자료형이 primitive 자료형인지 아닌지에 따라 나뉜다.
			 	int 자료형과 같은 primitive 자료형인 경우 값이 전달되고 그 이외의 경우는 객체가 전달된다.
			  
			 + tip
			 	sample.varTest(sample);
			 	sample 객체를 이용하여 varTest라는 메서드를 호출할 경우 굳이 sample 객체를 전달할 필요가 없다. 왜냐하면 전달하지 않더라도 varTest 메서드는
			 	this라는 키워드를 이용하여 객체에 접근할 수 있기 때문이다. this를 이용하여 varTest메서드를 수정한 버전은 다음과 같다.
			 	
			 	public class Sample {
			 		
			 		int a;
			 		
			 		void varTest
			 	}
			 	
			 	
			 	
			 */
			
			
			
			
			
		}
}
