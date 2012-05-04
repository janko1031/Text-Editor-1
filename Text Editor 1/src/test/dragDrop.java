package test;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextArea;


public class dragDrop {
	public void drop(final JTextArea text){
	text.setDropTarget(new DropTarget() {

		public synchronized void drop(DropTargetDropEvent evt) {
			try {
				evt.acceptDrop(DnDConstants.ACTION_COPY);
				List<File> droppedFiles = (List<File>) evt
						.getTransferable().getTransferData(
								DataFlavor.javaFileListFlavor);
				for (File file : droppedFiles) {

					try {
						BufferedReader in;
						FileReader reader = null;

						reader = new FileReader(file);

						in = new BufferedReader(reader);

						String inputLine = in.readLine();

						while (inputLine != null) {

							text.append(inputLine + "\n");

							inputLine = in.readLine();
						}
						in.close();
					}

					catch (IOException ex) {
						text.append("Error Processing File:\n"
								+ ex.getMessage() + "\n");
					}

					catch (NullPointerException ex) {
						text.append("Open File Cancelled:\n"
								+ ex.getMessage() + "\n");
					}

				}

			}

			catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	);
	}
}
