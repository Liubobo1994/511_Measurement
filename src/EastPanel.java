  import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class EastPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EastPanel() {
		this.setBounds(100, 100, 300, 800);
		this.setPreferredSize(new Dimension(300,0));

		 ControlPanel cp = new ControlPanel();
		 this.add(cp,BorderLayout.NORTH );
		 
		 StatePanel sp = new StatePanel();
		 this.add(sp,BorderLayout.CENTER);
	}

}
