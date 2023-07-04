package day0704;

import java.util.Random;

/**
 * 난수를 사용할 목적으로 만들어진 클래스
 * @author USER
 */
public class UseRandom {

	public UseRandom() {
		// 1. 생성 )
		Random random = new Random();
		
		// 2. method 호출 )
		// 정수의 난수
		int num = random.nextInt();
		System.out.println(Math.abs(num%10));// -21억 ~ +21억 사이의 수 중 하나가 나온다.

		num = random.nextInt(10);// nextInt( 범위의 수 ) 
		System.out.println(num);
		
		// 실수의 난수
		System.out.println(random.nextFloat());
		System.out.println(random.nextDouble());
		// (casting)(nextDouble()*발생할 수)
		System.out.println((int)(random.nextDouble()*10));
		
		// 불린의 난수
		boolean flag = random.nextBoolean();
		System.out.println(flag);
		System.out.println(random);
		
		// 1~45의 수중 하나를 출력
		num = random.nextInt(45)+1;
		System.out.println("1~45의 수 중 랜덤의 수 : " + num);
	}
	
	public static void main(String[] args) {
		new UseRandom();
		
	}
	
}
