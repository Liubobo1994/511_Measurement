import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class DisplayPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisplayPanel() {
		this.setBounds(100, 100, 700, 800);
		this.setPreferredSize(new Dimension(670,0));
		this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u663E\u793A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(SystemColor.control);
		setForeground(Color.WHITE);
	}

}
