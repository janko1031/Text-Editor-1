package test;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Open {

	public void openTxt(JTextArea txtArea) {

		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"txt Files", "txt");
			chooser.setFileFilter(filter);

			File selectedFile;

			BufferedReader in;
			FileReader reader = null;
			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {

				selectedFile = chooser.getSelectedFile();

				if (selectedFile.canRead() && selectedFile.exists()) {
					txtArea.setText("");
					reader = new FileReader(selectedFile);
				}
			}

			in = new BufferedReader(reader);

			String inputLine = in.readLine();

			while (inputLine != null) {


				txtArea.append(inputLine + "\n");

				inputLine = in.readLine();
			}
			in.close();
		}

		catch (IOException ex) {
			txtArea.append("Error Processing File:\n" + ex.getMessage() + "\n");
		}

		catch (NullPointerException ex) {
			
		}
	}

	
}