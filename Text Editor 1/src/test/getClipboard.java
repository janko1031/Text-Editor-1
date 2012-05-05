package test;


	import java.awt.Toolkit;
	import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

	public class getClipboard {


		public String getClip(){
			Toolkit toolkit1 = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit1.getSystemClipboard();
			String result1 = null;
			
			try {
				result1 = (String) clipboard.getData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException | IOException e) {
				
				
			}
			return result1;
		}
		
}
