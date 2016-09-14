import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;


public class FlagLoader extends SwingWorker<List<Flag>, Void>
{
	private static final String IMAGE_DIRECTORY = "pics";
	
	private DefaultListModel<Flag> flagModel;
	
	public FlagLoader(DefaultListModel<Flag> flagModel)
	{
		this.flagModel = flagModel;
	}
	
	@Override
	protected List<Flag> doInBackground() throws Exception
	{
		File dir = new File(IMAGE_DIRECTORY);
		List<Flag> flags = new ArrayList<>();
		
		//check if directory doesn't exist
		if(!dir.exists())
		{
			System.out.println("Could not find directory '" + IMAGE_DIRECTORY + "' to load images from");
			return flags;
		}
		
		//iterate through all files in the directory, and create a Flag object for each
		for(File f : dir.listFiles())
		{
			final String NAME = f.getName();
			try
			{
				flags.add(new Flag(NAME.replaceAll("\\..*", ""), ImageIO.read(f)));
				System.out.println("Successfully loaded flag for " + NAME);
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("FlagLoader had problems processing file with name " + NAME);
			}
		}
		
		return flags;
	}
	
	@Override
	public void done()
	{
		System.out.println("FLAG LOADER DONE!");
		try
		{
			List<Flag> flags = get();
			for(Flag f : flags)
				flagModel.addElement(f);
		}
		catch(InterruptedException | ExecutionException e)
		{
			e.printStackTrace();
			System.out.println("get() failed in FlagLoader");
		}
	}

}
