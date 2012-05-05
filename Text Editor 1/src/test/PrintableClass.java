package test;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


public class PrintableClass implements Printable {

	@Override
	public int print(Graphics arg0, PageFormat arg1, int arg2)
			throws PrinterException {
		
		return 0;
	}

}
