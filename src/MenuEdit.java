import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuEdit {
	
	JMenuBar menuBar = new JMenuBar();
	public MenuEdit()
	{
		//һ���˵�
		JMenu File = new JMenu("�ļ�");
		JMenu SetConfig = new JMenu("���ò���");
		JMenu Display = new JMenu("��ʾ");
		JMenu Help = new JMenu("����(H)");
		
		//�����˵�
		JMenuItem File_1 = new JMenuItem("��");
		File.add(File_1);
		JMenuItem File_2 = new JMenuItem("����");
		File.add(File_2);
		
		JMenuItem SetConfig_1 = new JMenuItem("Ĭ�ϲ���");
		SetConfig.add(SetConfig_1);
		JMenuItem SetConfig_2 = new JMenuItem("���ò���");
		SetConfig.add(SetConfig_2);
		JMenuItem SetConfig_3 = new JMenuItem("��ʼ��������");
		SetConfig.add(SetConfig_3);
		ControlListener cl=new ControlListener();
		SetConfig_2.addActionListener(cl);
		SetConfig_3.addActionListener(cl);

		
		JMenuItem Display_1 = new JMenuItem("��ʾ");
		Display.add(Display_1);
		
		JMenuItem Help_1 = new JMenuItem("����");
		Help.add(Help_1);
		
		menuBar.add(File);
		menuBar.add(SetConfig);
		menuBar.add(Display);
		menuBar.add(Help);
	}



	

}
