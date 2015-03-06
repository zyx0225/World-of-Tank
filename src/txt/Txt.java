//�ҵļ��±�������+���ܣ�
package txt;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Txt extends JFrame implements ActionListener{
	//����������ı���
	JTextArea jta=null;
	
	//�˵���
	JMenuBar jmb=null;
	JMenu jm=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Txt txt=new Txt();
	}
	
	//���캯��
	public Txt(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm=new JMenu("�ļ�");
		//�������Ƿ�
		jm.setMnemonic('F');
		jmi1=new JMenuItem("��");
		
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");

		jmi2=new JMenuItem("����");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		
		//һ��һ������
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
			
			//�����µ���� JFileChooser
			JFileChooser jfc1=new JFileChooser();
			jfc1.setDialogTitle("��ѡ���ļ�");
			jfc1.showOpenDialog(null);
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ�·��
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				//���ļ��ж�ȡ��Ϣ������ʾ��textarea���
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
			jfc.setDialogTitle("���Ϊ");
			jfc.showOpenDialog(null);
			jfc.setVisible(true);
			
			//�õ�����·��
			String file=jfc.getSelectedFile().getAbsolutePath();
			
			//׼��д��ָ���ļ�·��
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
