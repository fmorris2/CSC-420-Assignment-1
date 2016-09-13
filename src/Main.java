import java.awt.EventQueue;

public class Main
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> {initGui();});
	}
	
	private static void initGui()
	{
		FlagFrame frame = new FlagFrame();
		frame.setVisible(true);
	}

}
