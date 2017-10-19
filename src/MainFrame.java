import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


 public class MainFrame extends JFrame {

	private JPanel contentPane;
    public static  ChartPanel chartPanel = new ChartPanel("瞬时体积流量");

		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1000, 700);
		this.setTitle("体积流量测量");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		MenuEdit menuedit = new MenuEdit();
	    setJMenuBar(menuedit.menuBar);
	  
	    //    DisplayPanel dp = new DisplayPanel();
       contentPane.add(chartPanel, BorderLayout.WEST);
	    
	    EastPanel ep = new  EastPanel();
	    contentPane.add(ep,BorderLayout.EAST);
	    ep.setLayout(new BorderLayout(0, 0));
	    
	}

	

}
