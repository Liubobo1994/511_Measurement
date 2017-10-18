import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class ControlPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	static ControlListener cl;//设置监听器 
	
	
	public ControlPanel() {
		this.setBounds(0, 0, 300, 200);
		this.setPreferredSize(new Dimension(0,300));
		this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u63A7\u5236", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(SystemColor.control);
		setForeground(Color.WHITE);
		
		cl = new ControlListener();
	
		
		JButton jb_1 = new JButton("开始测量");
		add(jb_1);
		jb_1.addActionListener(cl);
		
		JButton jb_2 = new JButton("结束测量");
		add(jb_2);
		jb_2.addActionListener(cl);
		
		

	}

}
