package tank;
import java.awt.*;

import javax.swing.*;

public class Demo9 extends JFrame{
	Mypanel mp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9 d=new Demo9();
	}
	public Demo9(){
		mp=new Mypanel();
		this.add(mp);
		this.setTitle("��ͼ");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//����Panel�����ڻ�ͼ��ʵ�ֻ�ͼ������
class Mypanel extends JPanel{
	//����JPanel��paint�ķ���
	//Graphics�ǻ�ͼ����Ҫ�࣬��������һֻ����
	public void paint(Graphics g){  
		//1.���ø��ຯ����ʼ����������
		super.paint(g);
		//�Ȼ�һ��Բ
		//g.drawOval(10, 10, 30, 30);
		g.drawRect(10, 10, 30, 30);
		//������ɫ�����Բ��
		g.setColor(Color.red);
		g.fillOval(10, 10, 30, 30);	
		
		//��ͼƬ
		Image im=
				Toolkit.getDefaultToolkit().getImage
				(Panel.class.getResource("/pretty_flowers_2-wallpaper-1600x900.jpg"));
		g.drawImage(im, 90, 90, 80, 50, this);
		
		//����
		g.setColor(Color.black);
		g.setFont(new Font("���Ĳ���", Font.BOLD, 15));
		g.drawString("�ǺǺǣ��ջ�", 70, 70);
	}
}