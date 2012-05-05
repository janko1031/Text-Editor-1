package test;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class TxtGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TxtGUI frame = new TxtGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public TxtGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		final JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
		final DialogS dialog = new DialogS();
		scrollPane.setViewportView(textArea);
		// String globalText = textArea.getText();
		final StatusBar st = new StatusBar();
		st.setVisible(false);
		getContentPane().add(st, java.awt.BorderLayout.SOUTH);
		textArea.getInputMap().put(KeyStroke.getKeyStroke("control x"), "Cut");
		textArea.getInputMap().put(KeyStroke.getKeyStroke("control c"), "Copy");
		textArea.getInputMap()
				.put(KeyStroke.getKeyStroke("control v"), "Paste");
		textArea.getInputMap()
				.put(KeyStroke.getKeyStroke("control p"), "Print");

		dragDrop dropText = new dragDrop();
		dropText.drop(textArea);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);
		JMenuItem mntmCut_2 = new JMenuItem("Cut");
		mntmCut_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CutCopyPaste cut = new CutCopyPaste();

				cut.Cut(textArea);

			}
		});

		JMenuItem mntmCut_1 = new JMenuItem("Copy Ctrl+c");
		mntmCut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CutCopyPaste copy = new CutCopyPaste();

				copy.Copy(textArea);
			}
		});

		JMenuItem mntmCut_3 = new JMenuItem("Cut Ctrl+x");
		mntmCut_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CutCopyPaste cut = new CutCopyPaste();

				cut.Cut(textArea);
			}
		});
		popupMenu.add(mntmCut_3);
		popupMenu.add(mntmCut_1);

		JMenuItem mntmPaste_1 = new JMenuItem("Paste Ctrl+v");
		mntmPaste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CutCopyPaste paste = new CutCopyPaste();

				paste.Paste(textArea);

			}

		});
		popupMenu.add(mntmPaste_1);

		JMenuItem mntmSelectAll_1 = new JMenuItem("Select all");
		mntmSelectAll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.selectAll();

			}
		});

		JMenuItem mntmDelete = new JMenuItem("Delete Del");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CutCopyPaste del = new CutCopyPaste();

				del.Delete(textArea);
			}
		});
		popupMenu.add(mntmDelete);

		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);

		JMenuItem refSt = new JMenuItem("Refresh statisitics");
		refSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				refresh rf = new refresh();
				String t = rf.refStats(textArea);
				st.setText(t);

			}

		});

		popupMenu.add(refSt);
		popupMenu.add(mntmSelectAll_1);

		final JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (!textArea.getText().equals(null)) {

					dialog.show();
				} else {

					textArea.setText(null);
				}
			}

		});

		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Open op = new Open();
				op.openTxt(textArea);

			}
		});
		mnFile.add(mntmOpen);


		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JMenuItem mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SaveAs save = new SaveAs();
				save.saveAs(textArea);
			}
		});
		mnFile.add(mntmSaveAs);

		JMenuItem mntmPrint = new JMenuItem("Print... Ctrl+p");
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat pf = pjob.defaultPage();
				pjob.setPrintable(new PrintableClass(), pf);
				try {
					if (pjob.printDialog()) {
						pjob.print();
					}
				} catch (PrinterException e) {
				}
			}
		});
		mnFile.add(mntmPrint);

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut Ctrl+x");
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CutCopyPaste cut = new CutCopyPaste();

				cut.Cut(textArea);

			}
		});

		

		JSeparator separator_3 = new JSeparator();
		mnEdit.add(separator_3);
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy Ctrl+c");
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CutCopyPaste copy = new CutCopyPaste();

				copy.Copy(textArea);

			}
		});
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste Ctrl+v");
		mntmPaste.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				CutCopyPaste paste = new CutCopyPaste();

				paste.Paste(textArea);

			}
		});
		mnEdit.add(mntmPaste);

		JMenuItem mntmClear = new JMenuItem("Clear all");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
			}
		});

		JMenuItem mntmSelectAll = new JMenuItem("Select all Ctrl+a");
		mntmSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.selectAll();

			}
		});

		JMenuItem mntmDelete_1 = new JMenuItem("Delete Del");
		mntmDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CutCopyPaste del = new CutCopyPaste();

				del.Delete(textArea);
			}
		});
		mnEdit.add(mntmDelete_1);

		

		JSeparator separator = new JSeparator();
		mnEdit.add(separator);
		mnEdit.add(mntmSelectAll);
		mnEdit.add(mntmClear);

		JMenu mnView = new JMenu("View");
		mnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		menuBar.add(mnView);

		final JCheckBoxMenuItem chSTbar = new JCheckBoxMenuItem("Satus Bar");
		chSTbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] w = textArea.getText().split(" ");
				int number = w.length - 1;
				String words = Integer.toString(number);
				Tekst t = new Tekst();
				String l = t.brLinija(textArea);

				if (chSTbar.isSelected()) {
					st.setVisible(true);
				} else
					st.setVisible(false);
				st.setText("words: " + words + " Lines:" + l);
			}
		});
		mnView.add(chSTbar);

		final JCheckBoxMenuItem chWWrap = new JCheckBoxMenuItem("Word Wrap");
		chWWrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chWWrap.isSelected()) {
					textArea.setLineWrap(true);
				} else
					textArea.setLineWrap(false);
			}
		});
		mnView.add(chWWrap);

		final JCheckBoxMenuItem chLine = new JCheckBoxMenuItem(
				"Show line number");
		chLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt1 = textArea.getText();
				String liniije[] = txt1.split("\n");
				String txtLine = "";

				for (int i = 0; i < liniije.length; i++) {
					txtLine = txtLine + i + ": " + liniije[i] + "\n";

				}

				if (!chLine.isSelected()) {

					textArea.setText(txt1);
				} else
					textArea.setText(txtLine);
			}
		});
		mnView.add(chLine);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Component frame = null;
				JOptionPane
						.showMessageDialog(frame, "This is cool text editor");

			}
		});

		mnHelp.add(mntmAbout);

	}

	

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

	}

}