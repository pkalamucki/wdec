/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * mainPanel.java
 *
 * Created on 2011-12-30, 23:30:48
 */

package pl.edu.pw.wdec.wiev;


public class MainPanel extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8030418658776182659L;
	private Wejscie wejscieTab;
	private Wyjscie wyjscieTab;
	private Wykres wykresPanel;

	private javax.swing.JTabbedPane jTabbedPane1;

	/** Creates new form mainPanel */
	public MainPanel() {
		initComponents();
	}

	private void initComponents() {

		jTabbedPane1 = new javax.swing.JTabbedPane();

		wejscieTab = new Wejscie();

		wyjscieTab = new Wyjscie();
		
		wykresPanel = wejscieTab.getWykresPanel();
		wykresPanel.setWyjscie(wyjscieTab);
		wyjscieTab.setWykresPanel(wykresPanel);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTabbedPane1.addTab("Wejscie", wejscieTab);

		wyjscieTab.setAlignmentX(1.0F);
		wyjscieTab.setAlignmentY(1.0F);

		jTabbedPane1.addTab("Wyjscie", wyjscieTab);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				wykresPanel);
		wykresPanel.setLayout(jPanel3Layout);
		jTabbedPane1.addTab("Wykres", wykresPanel);


		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTabbedPane1,
								200, 523,
								600)
						.addGap(18,18,18)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTabbedPane1,
								200, 560,
								840)
						.addGap(18,18,18)));
		this.setBounds(100, 100, 100, 300);
		pack();
	}

}
