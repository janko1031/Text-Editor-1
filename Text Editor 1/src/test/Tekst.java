package test;

import java.io.*;

import javax.swing.JTextArea;

public class Tekst extends TxtGUI {
	public String ucitaj() {

		try {
			BufferedReader in = new BufferedReader(new FileReader("tekst.txt"));
			boolean kraj = false;
			String tekst = "";

			while (!kraj) {

				String pom = in.readLine();
				if (pom == null)
					kraj = true;
				else
					tekst = tekst + pom + "\n";

			}
			in.close();
			return tekst;

		} catch (Exception e) {
			return null;

		}

	}

	public String brLinija(JTextArea textaArea) {
		String lines = Integer.toString(textaArea.getLineCount() - 1);

		return lines;

	}

}
