import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FlagFrame extends JFrame
{
	private static final long serialVersionUID = 8755370338653071604L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FlagFrame()
	{
		setResizable(false);
		setTitle("CSC 420: Homework 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JList<Flag> countryList = new JList<Flag>();
		contentPane.add(countryList);
	}

}
