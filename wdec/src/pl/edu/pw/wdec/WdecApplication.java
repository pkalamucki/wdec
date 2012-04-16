package pl.edu.pw.wdec;

import javax.swing.SwingUtilities;

import pl.edu.pw.wdec.wiev.MainPanel;

public class WdecApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainPanel().setVisible(true);
			}
		});
	}

}
