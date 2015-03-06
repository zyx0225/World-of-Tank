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
		this.setTitle("绘图");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//定义Panel，用于绘图和实现绘图的区域
class Mypanel extends JPanel{
	//覆盖JPanel中paint的方法
	//Graphics是绘图的重要类，可以理解成一只画笔
	public void paint(Graphics g){  
		//1.调用父类函数初始化，不能少
		super.paint(g);
		//先画一个圆
		//g.drawOval(10, 10, 30, 30);
		g.drawRect(10, 10, 30, 30);
		//设置颜色，填充圆形
		g.setColor(Color.red);
		g.fillOval(10, 10, 30, 30);	
		
		//画图片
		Image im=
				Toolkit.getDefaultToolkit().getImage
				(Panel.class.getResource("/pretty_flowers_2-wallpaper-1600x900.jpg"));
		g.drawImage(im, 90, 90, 80, 50, this);
		
		//画字
		g.setColor(Color.black);
		g.setFont(new Font("华文彩云", Font.BOLD, 15));
		g.drawString("呵呵呵，菊花", 70, 70);
	}
}