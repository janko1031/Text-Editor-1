package test;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class refresh {

	public String refStats(JTextArea txtArea) {

		String[] w = txtArea.getText().split(" ");
		int number = w.length;
		String words = Integer.toString(number);
		Tekst t = new Tekst();
		String l = t.brLinija(txtArea);
		String text = "words: " + words + "  Lines:" +l;
		return text;
	}
}
