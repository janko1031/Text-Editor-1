package test;

import javax.swing.JTextArea;
//Is thi really working?
//Yes it is working :)
public class CutCopyPaste {
	final getClipboard Clip1 = new getClipboard();

	final ToClipboard Clip2 = new ToClipboard();

	public void Cut(JTextArea txtArea) {

		String selectedTxt = txtArea.getSelectedText();
		int pocetak = txtArea.getSelectionStart();
		int kraj = txtArea.getSelectionEnd();
		String startText = txtArea.getText().substring(0, pocetak);
		String endText = txtArea.getText().substring(kraj,
				txtArea.getText().length());
		Clip2.setClipboard(selectedTxt);
		txtArea.setText(startText + endText);

	}

	public void Delete(JTextArea txtArea) {

		int pocetak = txtArea.getSelectionStart();
		int kraj = txtArea.getSelectionEnd();
		String preText = txtArea.getText().substring(0, pocetak);
		String posleText =txtArea.getText().substring(kraj,
				txtArea.getText().length());

		txtArea.setText(preText + posleText);
	}

	public void Copy(JTextArea txtArea) {
		String txt = txtArea.getSelectedText();
		Clip2.setClipboard(txt);
	}

	public void Paste(JTextArea txtArea) {
		int pocetak = txtArea.getSelectionStart();
		String startText = txtArea.getText().substring(0, pocetak);
		String endText = txtArea.getText().substring(pocetak);
		final String fromClip = Clip1.getClip();
		String text = startText + fromClip + endText;

		txtArea.setText(text);

	}
}
