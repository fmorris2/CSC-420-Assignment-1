import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

public class FlagFrame extends JFrame
{
	private static final long serialVersionUID = 8755370338653071604L;
	
	private JPanel contentPane;
	private JList<Flag> countryList;
	private DefaultListModel<Flag> countryListModel;
	private JLabel imageLabel;

	/**
	 * Create the frame.
	 */
	public FlagFrame()
	{
		countryListModel = new DefaultListModel<>();
		setResizable(false);
		setTitle("CSC 420: Homework 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Load flags with our separate swing worker
		new FlagLoader(countryListModel).execute();
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		countryList = new JList<Flag>();
		countryList.addListSelectionListener((ListSelectionEvent e) -> changeImage(e));
		
		scrollPane.setViewportView(countryList);
		countryList.setModel(countryListModel);
		
		imageLabel = new JLabel("");
		contentPane.add(imageLabel);
	}
	
	private void changeImage(ListSelectionEvent e)
	{
		Flag f = countryList.getSelectedValue();
		Image scaledImage = f.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(scaledImage));
	}

}
