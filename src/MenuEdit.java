import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuEdit {
	
	JMenuBar menuBar = new JMenuBar();
	public MenuEdit()
	{
		//一级菜单
		JMenu File = new JMenu("文件");
		JMenu SetConfig = new JMenu("设置参数");
		JMenu Display = new JMenu("显示");
		JMenu Help = new JMenu("帮助(H)");
		
		//二级菜单
		JMenuItem File_1 = new JMenuItem("打开");
		File.add(File_1);
		JMenuItem File_2 = new JMenuItem("保存");
		File.add(File_2);
		
		JMenuItem SetConfig_1 = new JMenuItem("默认参数");
		SetConfig.add(SetConfig_1);
		JMenuItem SetConfig_2 = new JMenuItem("设置参数");
		SetConfig.add(SetConfig_2);
		JMenuItem SetConfig_3 = new JMenuItem("初始参数测量");
		SetConfig.add(SetConfig_3);
		ControlListener cl=new ControlListener();
		SetConfig_2.addActionListener(cl);
		SetConfig_3.addActionListener(cl);

		
		JMenuItem Display_1 = new JMenuItem("显示");
		Display.add(Display_1);
		
		JMenuItem Help_1 = new JMenuItem("帮助");
		Help.add(Help_1);
		
		menuBar.add(File);
		menuBar.add(SetConfig);
		menuBar.add(Display);
		menuBar.add(Help);
	}



	

}
