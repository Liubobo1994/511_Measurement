import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Font;

import Time.Time;;

public class StatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	static JTextField jtf_1;
	
	static JTextField jtf_3;
	static JTextField jtf_4;
	static JTextField jtf_5;
	static JTextField jtf_6;
   	static JTextField jtf_7;
	static JTextField jtf_8;
	static JTextField jtf_9;
	
	public StatePanel() {
		this.setBounds(0, 220, 300, 406);
		this.setPreferredSize(new Dimension(0,350));
		this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u72B6\u6001", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(SystemColor.control);
		setForeground(Color.WHITE);
		
		this.setLayout(new GridLayout(9, 3, -40, 18));
		
		JLabel jlb_1 = new JLabel("开始时间");
		jlb_1.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_1);
		
		
		jtf_1 = new JTextField();
		jtf_1.setColumns(10);
		add(jtf_1);
		
		JLabel jlb_13 = new JLabel(" ");
		add(jlb_13);
		
		JLabel jlb_2 = new JLabel("当前时间");
		jlb_2.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_2);
		
		JTextField jtf_2 = new JTextField();
		jtf_2.setColumns(10);
		add(jtf_2);
		//获取当前系统时间
		new Time(jtf_2).getTime();
		
		JLabel jlb_23 = new JLabel("");
		add(jlb_23);
		
		JLabel jlb_3 = new JLabel("结束时间");
		jlb_3.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_3);
		
		jtf_3 = new JTextField();
		jtf_3.setColumns(10);
		add(jtf_3);
		
		JLabel jlb_33 = new JLabel("");
		add(jlb_33);
 	
		JLabel jlb_4 = new JLabel("测量时间");
		jlb_4.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_4);
		
		jtf_4 = new JTextField();
		jtf_4.setColumns(10);
		add(jtf_4);
		
		JLabel jlb_43 = new JLabel("");
		add(jlb_43);
		
		JLabel jlb_5 = new JLabel("物料密度");
		jlb_5.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_5);
		
		jtf_5 = new JTextField();
		String strBulkDensity=String.valueOf(SetParameter.bulkDensity);
		jtf_5.setText(strBulkDensity);
		jtf_5.setColumns(10);
		add(jtf_5);
		
		JLabel jlb_53 = new JLabel("                 t/m³");
		add(jlb_53);
		
		JLabel jlb_6 = new JLabel("皮带速度");
		jlb_6.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_6);
		
		jtf_6 = new JTextField();
		String strBeltVelocity=String.valueOf(SetParameter.beltVelocity);
		jtf_6.setText(strBeltVelocity);
		jtf_6.setColumns(10);
		add(jtf_6);
		
		JLabel jlb_63 = new JLabel("                 m/s");
		add(jlb_63);
		
		JLabel jlb_7 = new JLabel("瞬时流量");
		jlb_7.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_7);
		
	    jtf_7 = new JTextField();
		jtf_7.setColumns(10);
		add(jtf_7);
		
		
		JLabel jlb_73 = new JLabel("                 m³/s");
		add(jlb_73);
		
		JLabel jlb_8 = new JLabel("累积体积");
		jlb_8.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_8);
		
		jtf_8 = new JTextField();
		jtf_8.setColumns(10);
		add(jtf_8);
		
		JLabel jlb_83 = new JLabel("                 m³");
		add(jlb_83);
		
		JLabel jlb_9 = new JLabel("累积质量");
		jlb_9.setHorizontalAlignment(SwingConstants.LEFT);
		add(jlb_9);
		
	     jtf_9 = new JTextField();
		jtf_9.setColumns(10);
		add(jtf_9);
		
		JLabel jlb_93 = new JLabel("                  t");
		add(jlb_93);
	}

}
