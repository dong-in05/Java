package 입출력;

import java.io.*;

public class 콘솔_입출력 {
		/*
		 	생년월일(YYYY/MM/DD)을 입력해 주세요:
		 	
		 	이렇게 사용자에게 위와 같은 문자열을 보여주는 것이 바로 콘솔 출력이고
		 	 위 질문에 사용자가 답변을 하는 것을 콘솔 입력이라고 한다.
		 	 
		 	 * 콘솔이란
		 	 	콘솔은 환경에 따라 변경될 수 있다. 
		 	 	만약 인텔리제이에서 실행했다면 인텔리제이의 콘솔창 윈도우 명령창에서 실행했다면 명령창이 콘솔이 된다.
		 	 	즉, 콘솔은 사용자의 입력을 받거나 사용자에게 문자열을 출력해 주는 역할을 하는 것을 통칭하는 말이다.
		 */
	public static void main(String[] args) throws IOException{
			// 자바 코드에서 사용자가 입력한 문자열을 얻기 위해서는 자바의 *System.in*을 사용한다.
		
		InputStream in = System.in;
		
		int a;
		a = in.read();

		
		System.out.println(a);
		
		/*
		 	위에서 사용한 InputStream은 자바의 내장 클래스이다. 자바의 내장 클래스중에 java.lang 패키지에 속해 있지 않은 클래스는
		 	위 코드처럼 필요할 때 항상 import해서 사용해야 한다. 우리가 그동안 사용해 왔던 System 이나 String 등의 클래스는 
		 	java.lang 패키지에 속해 있는 클래스이므로 별도의 import 과정이 필요없었다.
		 	
		 	System.in은 InputStream 의 객체
			
			InputStream in = System.in;
			
			InputStream의 read 메서드는 1 byte의 사용자의 입력을 받아들인다.
			
			int a;
			
			a = in.read();
			
			read 메서드로 읽은 1 byte의 데이터는 byte 자료형으로 저장되는 것이 아니라 int 자료형으로 저장된다.
			저장되는 int값은 0-255 사이의 정수값으로 아스키 코드값이다.
			+ 사용자 입력후 Enter를 입력해야 입력이 종료된다.
			
			IOException 
			 - InputStream오르 부터 값을 읽어들일때는 IOException이 발생할 수 있기 때문에 예외처리를 해야하는데
			   throws로 예외처리를 뒤로 미루게 한 것이다.
			
			여기서 abc를 입력했지만  "a"에 해당하는 아스키 코드값만 출력되었다. 그 이유는 InputStream의 read 메서드는 1 byte만 
			읽기 때문이다. 즉, 사용자는 "abc"라는 총 3byte의 데이터를 전달했지만 프로그램에서 1byte만 읽은 경우라고 할 수 있다.
			사용자가 전달한 1byte 또는 3 byte의 데이터를 다른 말로 입력 스트림(Stream)이라고 한다. 스트림은 이어져 있는 데이터(byte)의 형태를 의미한다.
			
			스트림(Stream)이란?
				-  스트림을 가장 쉽게 이해하려면 수도꼭지를 생각하면 된다. 수도꼭지를 틀면 물이나오고 수도꼭지를 잠그면 물이 나오지 않는다.
				   A라는 곳에서 부터 B라는 곳까지 수도관이 연결되어 있고 A에서 계속 물을 보낸다면 B에서 수도꼭지를 틀때마다 물이 나오게 될 것이다.
				   여기서 스트림은 A수도관에서 B수도관으로 이동하느 물의 흐름이라고 할 수 있다.
				   
				   ex) 파일 데이터 (파일은 그 시작과 끝에 있는 데이터의 스트림이다.)
				   	   HTTP 송수신 (브라우저가 요청하고 서버가 응답하는 HTTP 형태의 데이터도 스트림이다.)
				   	   키보드 입력 (사용자가 키보드로 입력하는 문자열은 스트림이다.)				   
		 */
			//3 byte를 전부 읽고 싶다면?
				int b;
				int c;
				int d;
				
				b = in.read();
				c = in.read();
				d = in.read();
				
				System.out.println(b);
				System.out.println(c);
				System.out.println(d); // 위에 출력하는 값 때문에 엔터의 값과 스페이스바(공백?) 10 13이 출력됌
				
				//개선된 방법
				
				byte[] f = new byte[3];
				in.read(f);
				
				System.out.println(f[0]);
				System.out.println(f[1]);
				System.out.println(f[2]);
	
					
				// InputStreamReader
				// 입력한 문자값을 그대로 출력하려면?
				
				InputStreamReader reader = new InputStreamReader(in);
				char[] r = new char[3];
				reader.read(r);
				
				System.out.println(r);
				/*
				 	InputStreamReader 객체를 생성할 때는 생성자의 입력으로 InputStream 객체가 필요하다.
				 	
				 	InputStreamReader(in);
				 	
				 	이전에 읽어들일 값을 byte배열로 선언했는데 InputStreamReader를 이용하면 다음처럼 byte 대신 char 배열을 사용할 수 있다.
				
				 	char[] a = new char[3];
				 */
				
				/*
				 	BufferedReader
				 	 - 사용자의 입력을 전부 받아들일 수 있는 법
				 
				 */
				BufferedReader br = new BufferedReader(reader);
				
				String s = br.readLine();
				
				System.out.println(s);
					
	}

}
