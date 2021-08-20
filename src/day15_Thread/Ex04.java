package day15_Thread;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex04 {
	public static void main(String[] args) {
			
			JFrame frame = new JFrame("TEST");
			Container c = frame.getContentPane();	// 안에 글씨 
			JLabel label = new JLabel("Hello GUI"); 	// 안에 글씨 쓰기
			
			c.add(label);							//글씨를 저장
			
			frame.setLocation(1000,200);	//가로,세로 위치 설정
			
			frame.setPreferredSize(new Dimension(500,200));  // 창 사이즈 조정
			frame.pack();							//설정값 적용
			
			Font font = new Font(null,0,32);		// 폰트 설정, 글꼴/형태/크기
			label.setFont(font);					//  폰트 저장
			label.setHorizontalAlignment(JLabel.CENTER);	// 폰트번경, 위치
			
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램 꺼주는거
			for(int i=0;;i++)
			label.setText(i+"안녕");   	// 글씨 변경하기
			
			
			
	}
}
