

package pl.edu.pw.wdec.wiev;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import pl.edu.pw.wdec.data.ChartPoint;
import pl.edu.pw.wdec.data.EntryData;
import pl.edu.pw.wdec.utils.EntryDataBean;

public class Wykres extends javax.swing.JPanel implements MouseListener,
		MouseMotionListener {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7795729958934279485L;
	private static final double MIN_DISTANCE_FROM_POINT = 20;
	private JFreeChart chart;
	private XYSeriesCollection dataset;

	private XYSeries series;
	private DefaultXYItemRenderer renderer;
	
	
	private Wyjscie wyjsciePanel;
	JLabel zyskLabel;
	JLabel ryzykoLabel;
	private JTextArea ryzykoVal;
	private JTextArea zyskVal;
	private JLabel info;
	JButton b;
	
	private List<ChartPoint> points;
	
	private EntryData entryData;
	
	/** Creates new form wykres */
	public Wykres(List<ChartPoint> points) {
		this.points = points;
		this.entryData = EntryDataBean.getEntryData();
		initComponents();

	}


	private void initComponents() {
		dataset = new XYSeriesCollection();
		renderer = new DefaultXYItemRenderer();
		series = new XYSeries("dane");
		buttonPanel = new JPanel();
		b = new JButton("Optymalizuj");
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				optymalizuj();
				
			}
		});
		
		buttonPanel.setBounds(0, 400, 500, 180);
		
		zyskLabel = new JLabel("Zysk");
		ryzykoLabel = new JLabel("Ryzyko");
		info = new JLabel("Wybrany punkt");
		
		zyskVal = new JTextArea();
		zyskVal.setEnabled(false);
		zyskVal.setDisabledTextColor(Color.black);
		zyskVal.setText("0.0");
		ryzykoVal = new JTextArea();
		ryzykoVal.setEnabled(false);
		ryzykoVal.setDisabledTextColor(Color.black);
		ryzykoVal.setText("0.0");
		
		//buttonPanel.add(b);
		generateChart();

        javax.swing.GroupLayout pleLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(pleLayout);
        pleLayout.setHorizontalGroup(
            pleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        pleLayout.setVerticalGroup(
            pleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ple2Layout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(ple2Layout);
        ple2Layout.setHorizontalGroup(
            ple2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        ple2Layout.setVerticalGroup(
            ple2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout wykresLayout = new javax.swing.GroupLayout(this);
        this.setLayout(wykresLayout);
        wykresLayout.setHorizontalGroup(
            wykresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wykresLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(wykresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(chartPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        wykresLayout.setVerticalGroup(
            wykresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wykresLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(wykresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                		.addComponent(zyskLabel)
                    	.addGap(10,10,10)
                    	.addComponent(ryzykoLabel))
                .addGroup(wykresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    	.addComponent(b))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
        	buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonLayout.createSequentialGroup()
            	.addGap(70, 70, 70)
            	.addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            			.addComponent(b)
            			.addGroup(buttonLayout.createSequentialGroup()
            				.addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            					.addComponent(info)
            					.addComponent(zyskLabel)
            					.addComponent(ryzykoLabel))
            					.addGap(18, 18, 18)
            				.addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            					.addComponent(zyskVal)
            					.addComponent(ryzykoVal,javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
            		.addGap(18, 18, 18))
            	
        );
        buttonLayout.setVerticalGroup(
        	buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
               .addGap(10, 10, 10)
               		.addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               			 .addComponent(info))
                    	.addGap(10,10,10)
                    .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    	.addComponent(zyskLabel)
                        .addComponent(zyskVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ryzykoVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ryzykoLabel))
                .addGap(15, 15, 15)
               	.addComponent(b)
               	.addGap(33, 33, 33))
        );
	}

	/* musi przyjmowac jakis dataset */
	@SuppressWarnings("deprecation")
	private void generateChart() {

		createData();

		chart = ChartFactory.createXYLineChart("Wykres Zysku i Ryzyka", "Ryzyko", "Zysk",
				dataset, PlotOrientation.VERTICAL, true, true, true);

		plot = chart.getXYPlot();
		domainAxis = plot.getDomainAxis();
		rangeAxis = plot.getRangeAxis();

		renderer.setShapesVisible(true);
		renderer.setLinesVisible(true);
		chart.getXYPlot().setRenderer(renderer);


		plot.setOutlinePaint(Color.black);

		chartPanel = new ChartPanel(chart);
		// chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

		chartPanel.setMouseZoomable(false);
		chartPanel.setMinimumDrawWidth(0);
		chartPanel.setMinimumDrawHeight(0);
		chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
		chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
		chartPanel.addMouseListener(this);
		chartPanel.addMouseMotionListener(this);

		chartPanel.setBackground(Color.white);
		chartPanel.setBounds(10, 10, 500, 380);
	}

	public void change(List<ChartPoint> points) {
		this.points = points;
		dataset.removeAllSeries();
		series.clear();
		chartPanel.removeAll();
		chartPanel.revalidate(); // This removes the old chart

		createData();

		chartPanel.repaint();
		repaint();
	//	System.out.println("change");
	}

	private javax.swing.JPanel buttonPanel;
	private ChartPanel chartPanel;
	private XYPlot plot;
	private ValueAxis domainAxis;
	private ValueAxis rangeAxis;
	private Double lastBound;

	@Override
	public void mouseClicked(MouseEvent e) {
		XYSeries series_one = new XYSeries("punkt wybrany");
		series_one.clear();
		dataset.removeAllSeries();
		dataset.addSeries(series);
		chartPanel.revalidate();
		Point2D p2d = chartPanel.translateJava2DToScreen(e.getPoint());

		
		if (p2d == null)
			return;

		
		if(p2d.getX()<0){
			return;
		}

		float x = (float) (domainAxis.java2DToValue((float) p2d.getX(),
				chartPanel.getScreenDataArea(), plot.getDomainAxisEdge()));
		float y = (float)rangeAxis.java2DToValue((float) p2d.getY(),
				chartPanel.getScreenDataArea(), plot.getRangeAxisEdge());
		
		
		
		if(p2d.getX()<0 || x<0){
			return;
		}
		

		if(x>1){
			x = 1;
		}

		ryzykoVal.setText(Float.toString(x));
		zyskVal.setText(Float.toString(y));
		buttonPanel.repaint();

		series_one.add(x, y);
		
		dataset.addSeries(series_one);
		
	//	System.out.println(">>> released at " + p2d + " (" + x + "," + y + ")");
		
		
			
		drawBounding(p2d);
	}

	public void createData() {
		for (ChartPoint point : points) {
			
			series.add(point.getRisk(), point.getProfit());
		}
		dataset.addSeries(series);
	}

	private void drawBounding(Point2D p2d) {
		Graphics2D g2d = (Graphics2D) chartPanel.getGraphics();
		g2d.setPaint(Color.BLACK);
		g2d.setXORMode(Color.WHITE);

		if (p2d == null)
			return;
		
		if(p2d.getX()<0){
			return;
		}
		
		if(p2d.getX()<0){
			return;
		}
		
		Ellipse2D.Double last = new Ellipse2D.Double(p2d.getX()
				- MIN_DISTANCE_FROM_POINT,
				p2d.getY() - MIN_DISTANCE_FROM_POINT,
				MIN_DISTANCE_FROM_POINT * 2, MIN_DISTANCE_FROM_POINT * 2);
		if (lastBound != last) {
			// remove last bounding
			if (lastBound != null) {
				g2d.draw(lastBound);
			}
			g2d.draw(last);
			lastBound = last;
		}
	}
	
	public void optymalizuj(){		
		wyjsciePanel.setValues(java.lang.Double.parseDouble(ryzykoVal.getText()));
		wyjsciePanel.repaint();
	}
	
	public void setWyjscie(Wyjscie w){
		this.wyjsciePanel = w;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}


	public void changeButtonPanel(ChartPoint point) {
		XYSeries series_one = new XYSeries("punkt wybrany");
		series_one.clear();
		dataset.removeAllSeries();
		dataset.addSeries(series);
		chartPanel.revalidate();
		ryzykoVal.setText(""+point.getRisk());
		zyskVal.setText(""+point.getProfit());
		
		series_one.add(point.getRisk(), point.getProfit());
		
		dataset.addSeries(series_one);
		
		buttonPanel.repaint();
	}
}
