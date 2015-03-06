//我的记事本（界面+功能）
package txt;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Txt extends JFrame implements ActionListener{
	//定义组件，文本框
	JTextArea jta=null;
	
	//菜单条
	JMenuBar jmb=null;
	JMenu jm=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Txt txt=new Txt();
	}
	
	//构造函数
	public Txt(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm=new JMenu("文件");
		//设置助记符
		jm.setMnemonic('F');
		jmi1=new JMenuItem("打开");
		
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");

		jmi2=new JMenuItem("保存");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		
		//一级一级加入
		this.setJMenuBar(jmb);
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open")){
			
			//介绍新的组件 JFileChooser
			JFileChooser jfc1=new JFileChooser();
			jfc1.setDialogTitle("请选择文件");
			jfc1.showOpenDialog(null);
			jfc1.setVisible(true);
			
			//得到用户选择的文件路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				//从文件中读取信息，并显示到textarea组件
				String s="";
				String all="";
				while((s=br.readLine())!=null){
					all+=s+"\r\n";
				}
				jta.setText(all);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					fr.close();
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		else if(e.getActionCommand().equals("save")){
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为");
			jfc.showOpenDialog(null);
			jfc.setVisible(true);
			
			//得到保存路径
			String file=jfc.getSelectedFile().getAbsolutePath();
			
			//准备写入指定文件路径
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				
				bw.write(this.jta.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}

}
