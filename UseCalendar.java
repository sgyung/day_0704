package day0704;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UseCalendar {

	public UseCalendar() {
		System.out.println("시스템의 현재 날짜 : " + System.currentTimeMillis());

		// abstract class => 객체화가 되지 않음.
		// Calendar cal = new Calendar();

		// 1. instance를 얻는 static method 사용
		Calendar cal = Calendar.getInstance();
		// 2. 자식클래스를 사용
		Calendar cal2 = new GregorianCalendar();

		System.out.println(cal); // toString을 오버라이딩을 했기 때문에 주소값이 나오는것이 아니라 메세지가 나오게된다.
		System.out.println(cal2);

		// Constant를 사용하는 이유
		// System.out.println(cal.get(1) + " / " + cal.get(Calendar.YEAR)); // 1을 넣었을 때
		// 무엇을 표현하는지 알 수 없다.
		StringBuilder sb = new StringBuilder();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		sb.append(cal.get(Calendar.YEAR)).append("년").append(cal.get(Calendar.MONDAY) + 1).append("월")
				.append(cal.get(Calendar.DAY_OF_MONTH)).append("일").append(" 오늘이 이번년에 몇번 째 일 ")
				.append(cal.get(Calendar.DAY_OF_YEAR)).append(" 요일 ").append(dayOfWeek).append(" ");

		String[] weekTitle = { "일", "월", "화", "수", "목", "금", "토" };
		int amPm = cal.get(Calendar.AM_PM);
		sb.append(weekTitle[dayOfWeek - 1]).append("\n오전/오후 ").append(cal.get(Calendar.AM_PM));

		String amTitle = "";
		switch (amPm) {
		case Calendar.AM:// get이나 set에 넣어 사용하는 상수가 아닌 경우에는 비교용으로
			amTitle = "오전";
			break;
		case Calendar.PM:
			amTitle = "오후";
			break;
		}

		sb.append(amTitle).append(" ");
		sb.append(cal.get(Calendar.HOUR)).append(" ");
		sb.append(cal.get(Calendar.HOUR_OF_DAY)).append(":");
		sb.append(cal.get(Calendar.MINUTE)).append(":");
		sb.append(cal.get(Calendar.SECOND)).append(" ");

		System.out.println(sb);

	}

	public UseCalendar calendarSet() {
		// 1. Calendar 생성
		Calendar cal = Calendar.getInstance();

		// 2. method 호출
		// 년을 변경
		cal.set(Calendar.YEAR, 2024);
		// 월 변경 - JAVA는 0월 부터 11월 까지로 설정한다.
		cal.set(Calendar.MONTH, 11);// 2024-12-4
		// 일 변경 
		cal.set(Calendar.DAY_OF_MONTH, 25);// 2024-12-25
		

		String[] dayTitle = "일,월,화,수,목,금,토".split(",");
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DAY_OF_MONTH) + "-" + dayTitle[cal.get(Calendar.DAY_OF_WEEK)-1]);
		return this;
	}
	
	public void calSet2() {
		// 1. Calendar 생성
				Calendar cal = Calendar.getInstance();

				// 2. method 호출
				// 일 변경 : 현재월에 없는 일이 설정되면 다음 달 1일로 설정된다.
				cal.set(Calendar.DAY_OF_MONTH, 32);// 2025-8-1
				

				String[] dayTitle = "일,월,화,수,목,금,토".split(",");
				System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
						+ cal.get(Calendar.DAY_OF_MONTH) + "-" + dayTitle[cal.get(Calendar.DAY_OF_WEEK)-1]);
	}

	public static void main(String[] args) {
		
		// 코드를 변경하여 calSet2를 chain으로 호출해보세요.
		new UseCalendar().calendarSet().calSet2();
	
	}

}
