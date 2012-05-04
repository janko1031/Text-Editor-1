package test;
import test.TxtGUI;
import test.SaveAs;
import test.Tekst;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DialogS extends JDialog  {
  JTextArea text= new JTextArea();
	private final JPanel contentPanel = new JPanel();

	private void cancel() {

		setVisible(false);
	}

	public static void main(String[] args) {
		try {
			DialogS dialog = new DialogS();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public DialogS() {
		setBounds(100, 100, 380, 125);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lblDialog = new JLabel("Would you like to save chages?");
			lblDialog.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblDialog);
		}
		{
			JList list = new JList();
			contentPanel.add(list);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("Yes");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
			
		
//			txtExt retTxt= new txtExt(t);
						JFileChooser fileC = new JFileChooser();
						
						int ret = fileC.showSaveDialog(fileC);

						
						if (ret == javax.swing.JFileChooser.APPROVE_OPTION) {
							java.io.File sFile = fileC.getSelectedFile();
							SaveAs s = new SaveAs();
							JTextArea s2s= new JTextArea();
							String s2= "sa";
							s2s.setText(s2);
							s.saveAs( s2s);
						}
						
						fileC.setVisible(false);
						cancel();
					}
				});
				okButton.setActionCommand("Yes");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

			{
				JButton btnNo = new JButton("No");
				btnNo.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					
					}
				});
				buttonPane.add(btnNo);
			}
			{

				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
