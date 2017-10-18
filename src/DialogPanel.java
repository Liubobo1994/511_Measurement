import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Time.Time;

public class DialogPanel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	static JTextField jtf_1 = null ;
	static JTextField jtf_2 = null ;
	static JTextField jtf_3 = null ;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public DialogPanel() {
		
		setTitle("参数设置");
		setBounds(350, 150, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(2, 3, -2, 30));
		contentPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(ControlPanel.cl);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel jlb_1 = new JLabel("皮带速度");
		jlb_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jlb_1);
		
		jtf_1 = new JTextField();
		jtf_1.setColumns(10);
		contentPanel.add(jtf_1);
		
		JLabel jlb_13 = new JLabel("m/s");
		jlb_13.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jlb_13);
		
		JLabel jlb_2 = new JLabel("物料密度");
		jlb_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jlb_2);
		
		jtf_2 = new JTextField();
		jtf_2.setColumns(10);
		contentPanel.add(jtf_2);
		
		JLabel jlb_23 = new JLabel("t/m3");
		jlb_23.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jlb_23);
		
/*		JLabel jlb_3 = new JLabel("最大瞬时质量");
		jlb_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jlb_3);
		
		jtf_3 = new JTextField();
		jtf_3.setColumns(10);
		contentPanel.add(jtf_3);
		
		JLabel jlb_33 = new JLabel("kg/s");
		jlb_33.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(jlb_33);
*/
	}

}