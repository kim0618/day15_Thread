package day15_Thread;

class A{
	public void start() {
		System.out.println("부모 start 실행");
		run();
	}
	public void run() {
		System.out.println("부모 run 실행");
	}
}

class B extends A{
	public void run() {
		System.out.println("자식 run 실행");
	}
}

class A02 extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("A01 : "+i);
		}
	}
}
class B02 extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("B01 : "+i);
		}
	}
}
public class Ex02 {
	public static void main(String[] args) {
		
		A02 a = new A02();
		B02 b = new B02();
		
		a.setDaemon(true);
		b.setDaemon(true);
		
		a.start();
		b.start();
		
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
		System.out.println("프로그램 종료");
		
		
	}
}
