package day15_Thread;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Time extends Login_get_set{
	private Date date;
	private SimpleDateFormat simpl;
	public void setDate(){
		date = new Date();
		simpl =	new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
	}
	public String getDate() {
		return simpl.format(date);
	}
	public String ti() {
		for(int i=0; i<10; i++) {
			setDate();
			System.out.println(getDate());
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
		login();
		return null;
	}
}

class Win7 {
	private HashMap map;
	private ArrayList funcList;
	public void function(String funcName){
		if(map.containsKey(funcName)){
			System.out.println(map.get(funcName)+"실행합니다.");
		}else{System.out.println("실행합니다.");}
	}
	public ArrayList getFuncList(){
		funcList = new ArrayList();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			funcList.add(it.next());
		}
		return funcList;
	}
	public void setMap() {
		map = new HashMap();
		map.put("계산기", "calc.exe");
		map.put("메모장", "notepad.exe");
	}
	public void display(){ 
		ArrayList list = null;
		setMap();
		Scanner input = new Scanner(System.in);
		System.out.println("===== 환영합니다 =====");
		int sel=0;
		String funcName=null;
		while(true){
			System.out.println("1.기능");
			System.out.println("2.off");
			System.out.print("입력 >>>> ");
			sel = input.nextInt();
			switch(sel){
				case 1:
					list=getFuncList();
					System.out.println("사용  가능 기능");
					for(int i=0;i<list.size();i++)
						System.out.println(i+1+" : "+list.get(i));
					System.out.print("사용할 기능 입력: ");
					funcName=input.next();
					function(funcName);
					break;
				case 2:
					System.out.println("프로그램 종료!!!");
					return;
			}
		}
	}
	
}

class Login_get_set extends Win7{
	private String saveId=null,savePw=null,id=null,pw=null;
	public String getSaveId() {
		return saveId;
	}
	public void setSaveId(String id) {
		this.saveId = id;
	}
	public String getSavePw() {
		return savePw;
	}
	public void setSavePw(String pw) {
		this.savePw = pw;
	}
	private int n1;
	Scanner input = new Scanner(System.in);
	
	public void login() {
		Read re = new Read();
		while(true) {
			System.out.println("1.로그인 2.가입 3.로그아웃");
			System.out.print(">>> ");
			n1 = input.nextInt();
			if(n1 == 1) {
				System.out.println("아이디 입력 : ");
				id = input.next();
				System.out.println("비밀번호 : ");
				pw = input.next();
				if(log(id,pw) == 0) {
				System.out.println("인증 성공");
				re.print();
				display();
				}else {
					System.out.println("인증 실패");
				}
			}else if(n1 == 2) {
				System.out.println("가입 id : ");
				saveId = input.next();
				System.out.println("가입 pw : ");
				savePw = input.next();
				setSaveId(id);
				setSavePw(pw);
				System.out.println("인증 성공");		
			}
			else {
				System.out.println("인증 실패");
				break;
			}
		}
	}
	
	public int log(String id, String pw) {
		if(getSaveId() != null && getSavePw() != null) {
		if(getSaveId().equals(id) && getSavePw().equals(pw)){
			return 0;
		}else {
			return 1;
			
		}
		}
		return 1;
	}
}

class Read extends Thread{
	public void print() {
		Time t = new Time();
		t.setDate();
	JFrame frame = new JFrame("Test");
	Container c = frame.getContentPane();	// 안에 글씨 쓰기
	JLabel label = new JLabel(ri()); 	// 안에 글씨
	
	c.add(label);							//글씨를 저장
	
	frame.setLocation(1000,200);	//가로,세로 위치 설정
	
	frame.setPreferredSize(new Dimension(500,200));  // 창 사이즈 조정
	frame.pack();							//설정값 적용
	
	Font font = new Font(null,0,32);		// 폰트 설정, 글꼴/형태/크기
	label.setFont(font);					//  폰트 저장
	label.setHorizontalAlignment(JLabel.CENTER);	// 폰트번경, 위치
	
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램 꺼주는거
//	for(int i=0;;i++)
	//	label.setText(i+"안녕");
	}
	public String ri() {
		Time t = new Time();
		for(int i=0; ; i++) {
			t.setDate();
			System.out.println(t.getDate());
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
}
}

public class Quiz01 {
	public static void main(String[] args) {
	//	Login_get_set lo = new Login_get_set();
		
		Time ti = new Time();
	//	lo.login();
		ti.ti();
	}
}
