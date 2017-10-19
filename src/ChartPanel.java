import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;


public class ChartPanel extends Panel{
	    private static final int MAX_SAMPLES = 10000;
	    private  int index = 0;
	    private  long[] time = new long[MAX_SAMPLES];
	    private  double[] val = new double[MAX_SAMPLES];
	  static  DateFormat fmt = DateFormat.getDateTimeInstance();
	    private javax.swing.JPanel dataPanel;
	    private  javax.swing.JTextArea dataTextArea;
	    private javax.swing.JScrollPane jScrollPane1;
	    DecimalFormat df=new DecimalFormat("0.0000");//返回的数据格式
	    /** Creates new form DataWindow */
	    public ChartPanel() {
	        initComponents();
	    }

	    public ChartPanel(String ieee) {
	        initComponents();
	        setName(ieee);

	    }

	    public  void addData(long t, double v) {
	        time[index] = t;
	        val[index++] = v;
	        String FormatedValue= (df.format(v));
	        dataTextArea.append(fmt.format(new Date(t)) + "    value = " +FormatedValue + "\n");
	        dataTextArea.setCaretPosition(dataTextArea.getText().length());
	        repaint();
	    }
	    
	    public void UpGrade()
	    {
	    	repaint();
	    }

	    // Graph the sensor values in the dataPanel JPanel
	    public void paint(Graphics g) {
	        super.paint(g);
	        int left = dataPanel.getX() +10;       // get size of pane
	        int top = dataPanel.getY() + 10;
	        int right = left + dataPanel.getWidth() - 20;
	        int bottom = top + dataPanel.getHeight() - 20;

	        int y0 = bottom - 20;                   // leave some room for margins
	        int yn = top;
	        int x0 = left + 33;
	        int xn = right;
	        double vscale = (yn - y0) / 100;      // light values range from 0 to 800
	        double tscale = 1.0 / 20.0;           // 1 pixel = 2 seconds = 2000 milliseconds

	        // draw X axis = time
	        g.setColor(Color.BLACK);
	        g.drawLine(x0, yn, x0, y0);
	        g.drawLine(x0, y0, xn, y0);
	        int tickInt = 60 / 2;
	        for (int xt = x0 + tickInt; xt < xn; xt += tickInt) {   // tick every 1 minute
	            g.drawLine(xt, y0 + 5, xt, y0 - 5);
	            int min = (xt - x0) / (60 / 2);
	            g.drawString(Integer.toString(min), xt - (min < 10 ? 3 : 7) , y0 + 20);
	        }

	        // draw Y axis = sensor reading
	        g.setColor(Color.BLUE);
	        for (int vt = 120; vt > 0; vt -= 20) {         // tick every 200
	            int v = y0 + (int)(vt * vscale);
	            g.drawLine(x0 - 5, v, x0 + 5, v);
	            g.drawString(Integer.toString(vt), x0 - 38 , v + 5);
	        }

	        // graph sensor values
	        int xp = -1;
	        int vp = -1;
	        for (int i = 0; i < index; i++) {
	            int x = x0 + (int)((time[i] - time[0]) * tscale);
	            int v = y0 + (int)(val[i] * vscale);
	            if (xp > 0) {
	                g.drawLine(xp, vp, x, v);
	            }
	            xp = x;
	            vp = v;
	        }
	    }
	   
	    /** This method is called from within the constructor to
	     * initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is
	     * always regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // //GEN-BEGIN:initComponents
	    private void initComponents() {

	        this.setBounds(100, 100, 700, 800);
			this.setPreferredSize(new Dimension(670,700));
			setBackground(SystemColor.control);
			setForeground(Color.WHITE);
			
			
			JLabel jLabel=new JLabel("实时体积流量变化示意图");
			dataPanel = new JPanel();
		    jScrollPane1 = new JScrollPane();
		    dataTextArea = new JTextArea();
			
		    jLabel.setBackground(new Color(255, 255, 255));
			jLabel.setBounds(100, 100, 10, 10);
			add(jLabel,BorderLayout.NORTH);
			
	       

	        dataPanel.setBackground(new Color(255, 255, 255));
	        dataPanel.setMinimumSize(new Dimension(650, 450));
            dataPanel.setPreferredSize(new Dimension(650, 450));
	        add(dataPanel, java.awt.BorderLayout.CENTER);

	        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        jScrollPane1.setMinimumSize(new Dimension(650, 140));
	        jScrollPane1.setPreferredSize(new Dimension(650, 140));

	        dataTextArea.setColumns(20);
	        dataTextArea.setEditable(false);
	        dataTextArea.setRows(4);
	        jScrollPane1.setViewportView(dataTextArea);

	         add(jScrollPane1, java.awt.BorderLayout.SOUTH);

	       
	    }// //GEN-END:initComponents

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    
	    // End of variables declaration//GEN-END:variables
}
