package pl.edu.pw.wdec.wiev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import org.jfree.data.function.PowerFunction2D;

import pl.edu.pw.wdec.data.ChartPoint;
import pl.edu.pw.wdec.data.OutputData;
import pl.edu.pw.wdec.utils.EntryDataBean;
import pl.edu.pw.wdec.utils.MappingFactory;
import pl.edu.pw.wdec.utils.OptimizationUtils;

public class Wyjscie extends JPanel{
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1278932452289395686L;
	private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    
    
    private javax.swing.JButton wyjscieButton;
    private javax.swing.JSpinner jakosc;
    private javax.swing.JSpinner kredyt;
    private javax.swing.JSpinner magazyn;
    private javax.swing.JSpinner tv;
    private javax.swing.JSpinner wolumen;
    private javax.swing.JSpinner internet;
    private javax.swing.JSpinner cena;
	
    private Wykres wykresPanel;

	private JLabel infoLabel;
	private JLabel zyskLabel;
	private JLabel ryzykoLabel;
	private JLabel koszt_zmLabel;
	private JLabel koszt_cLabel;
	

	private JLabel zysk;
	private JLabel ryzyko;
	private JLabel koszt_zm;
	private JLabel koszt_c;
	
	private OutputData data;
    
    
	public Wyjscie(){
		initComponents();
				
	}

	private void initComponents(){

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        
        infoLabel = new javax.swing.JLabel();
        zyskLabel = new javax.swing.JLabel();
        ryzykoLabel = new javax.swing.JLabel();
        koszt_zmLabel = new javax.swing.JLabel();
        koszt_cLabel = new javax.swing.JLabel();
        
        jLabel12.setText("Jakosc");
        jLabel13.setText("Wolumen");
        jLabel14.setText("Cena");
        jLabel15.setText("Reklama tv");
        jLabel16.setText("Reklama magazyn");
        jLabel17.setText("Reklama internet");
        jLabel18.setText("Kredyt pobrany");
        
        ryzyko = new JLabel();
        zysk = new JLabel();
        koszt_zm = new JLabel();
        koszt_c = new JLabel();
        
        infoLabel.setText("Wyliczone wartosci:");
        zyskLabel.setText("Zysk");
        ryzykoLabel.setText("Ryzyko");
        koszt_zmLabel.setText("Koszt zmienny");
        koszt_cLabel.setText("");
        
        zysk.setText("0");
        ryzyko.setText("0");
        koszt_zm.setText("0");
        koszt_c.setText("");
        
        
        wyjscieButton = new JButton();
        wyjscieButton.setText("Uaktualnienie wykresu");
        wyjscieButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				//TODO wyliczyæ co potrzebne, czyli wyznaczyæ z parametrów ryzyko i zysk, wstawiæ to do punktu.
				Double ryzyko = wyliczRyzyko();
				Double profit = wyliczProfit();
				
		        ChartPoint point = new ChartPoint(ryzyko, profit);
		        wykresPanel.changeButtonPanel(point);
			}
        });
        
        zysk.setAlignmentX(RIGHT_ALIGNMENT);
        
        
        
        jakosc = new javax.swing.JSpinner();
        jakosc.setValue(0);
        jakosc.setEditor(new JSpinner.NumberEditor(jakosc,  "###,###,##0.00"));

        wolumen = new javax.swing.JSpinner();
        wolumen.setValue(0);
        wolumen.setEditor(new JSpinner.NumberEditor(wolumen,  "###,###,##0.00"));

        cena = new javax.swing.JSpinner();
        cena.setValue(0);
        cena.setEditor(new JSpinner.NumberEditor(cena,  "###,###,##0.00"));

        tv = new javax.swing.JSpinner();
        tv.setValue(0);
        tv.setEditor(new JSpinner.NumberEditor(tv,  "###,###,##0.00"));

        magazyn = new javax.swing.JSpinner();
        magazyn.setValue(0);
        magazyn.setEditor(new JSpinner.NumberEditor(magazyn,  "###,###,##0.00"));

        internet = new javax.swing.JSpinner();
        internet.setValue(0);
        internet.setEditor(new JSpinner.NumberEditor(internet,  "###,###,##0.00"));

        kredyt = new javax.swing.JSpinner();
        kredyt.setValue(0);
        kredyt.setEditor(new JSpinner.NumberEditor(kredyt,  "###,###,##0.00"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            	.addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                	.addComponent(wyjscieButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()      
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addGap(5, 5, 5)
                            .addComponent(infoLabel)
                            .addComponent(zyskLabel)
                            .addComponent(ryzykoLabel)
                            .addComponent(koszt_zmLabel)
                            .addComponent(koszt_cLabel)
                        	)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kredyt)
                            .addComponent(internet)
                            .addComponent(magazyn)
                            .addComponent(tv)
                            .addComponent(cena)
                            .addComponent(wolumen)
                            .addComponent(jakosc)
                            .addComponent(zysk)
                            .addComponent(ryzyko)
                            .addComponent(koszt_zm)
                            .addComponent(koszt_c,javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                .addGap(360, 360, 360))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jakosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(magazyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(internet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(kredyt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zyskLabel)
                    .addComponent(zysk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ryzykoLabel)
                    .addComponent(ryzyko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(koszt_zmLabel)
                    .addComponent(koszt_zm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(koszt_cLabel)
                    .addComponent(koszt_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(33, 33, 33)
                .addComponent(wyjscieButton)
                .addGap(33, 33, 33))
        );
        
	}
	
	public void setValues(Double risk){
		Double profit = OptimizationUtils.OptimizeProfit(EntryDataBean.getEntryData(), risk);
		data = MappingFactory.getProfitOutputMap().get(profit);

        jakosc.setValue(data.getJakosc());
        jakosc.setEditor(new JSpinner.NumberEditor(jakosc,  "###,###,##0.00"));


        wolumen.setValue(data.getWolumen());
        wolumen.setEditor(new JSpinner.NumberEditor(wolumen,  "###,###,##0.00"));

        cena.setValue(data.getCena());
        cena.setEditor(new JSpinner.NumberEditor(cena,  "###,###,##0.00"));


        tv.setValue(data.getReklamaTv());
        tv.setEditor(new JSpinner.NumberEditor(tv,  "###,###,##0.00"));


        magazyn.setValue(data.getReklamaMagazyn());
        magazyn.setEditor(new JSpinner.NumberEditor(magazyn,  "###,###,##0.00"));


        internet.setValue(data.getReklamaNet());
        internet.setEditor(new JSpinner.NumberEditor(internet,  "###,###,##0.00"));

        kredyt.setValue(data.getKredyt());
        kredyt.setEditor(new JSpinner.NumberEditor(kredyt,  "###,###,##0.00"));
        
        zysk.setText(""+profit);
        ryzyko.setText(""+risk);
        koszt_zm.setText(""+OptimizationUtils.getValue("koszt_produkcji"));
        koszt_c.setText("");
	}
	
	public void setZyskText(Float t){
		zysk.setText(Float.toString(t));
	}
	
	public void setRyzykoText(Float t){
		ryzyko.setText(Float.toString(t));
	}
	
	public void setKosztZmText(Float t){
		koszt_zm.setText(Float.toString(t));
	}
	
	public void setKosztCText(Float t){
		koszt_c.setText(Float.toString(t));
	}
	
	public void setWykresPanel(Wykres wykresPanel) {
		this.wykresPanel = wykresPanel;
	}
	
	private Double wyliczRyzyko(){
		Double ryzyko = 0d;

		Double jakoscValue	 = (Double) jakosc.getValue();
		
		Double wolumenValue = (Double) wolumen.getValue();
		
		if(wolumenValue>EntryDataBean.getEntryData().getMaxProdukcja()){
			wolumenValue = EntryDataBean.getEntryData().getMaxProdukcja();
			wolumen.setValue(EntryDataBean.getEntryData().getMaxProdukcja());
		}
		
		Double cenaValue = (Double) cena.getValue();
		Double reklamaTvValue = (Double) tv.getValue();
		Double reklamaMagValue = (Double) magazyn.getValue();
		Double reklamaIntValue = (Double) internet.getValue();
		
		
		ryzyko = 0.35*(cenaValue-15)/15 + 0.23*(100 - jakoscValue)/100 + 0.04*(100000 - reklamaTvValue)/100000+ 0.025*(100000 - reklamaIntValue)/100000+ 0.035*(100000 - reklamaMagValue)/100000;
		
		return ryzyko;
	}
	
	private Double wyliczProfit(){		
		Double profit = 0d;
		Double przychod;
		Double wolnaKasa;
		Double kosztyProdukcji;
		Double wysokoscPodatku;
		Double rata;
		Double kosztyReklamy;
		Double jakoscValue	 = (Double) jakosc.getValue();
		
		Double wolumenValue = (Double) wolumen.getValue();
		
		if(wolumenValue>EntryDataBean.getEntryData().getMaxProdukcja()){
			wolumenValue = EntryDataBean.getEntryData().getMaxProdukcja();
			wolumen.setValue(EntryDataBean.getEntryData().getMaxProdukcja());
		}
		
		Double cenaValue = (Double) cena.getValue();
		Double reklamaTvValue = (Double) tv.getValue();
		Double reklamaMagValue = (Double) magazyn.getValue();
		Double reklamaIntValue = (Double) internet.getValue();
		Double kredytValue = (Double) kredyt.getValue();
		
		Double oprocentowanieKonta = EntryDataBean.getEntryData().getProcentKonta()/100;
		Double oprocentowanieKredytu = EntryDataBean.getEntryData().getProcentKredytu()/100;
		Double podatek = EntryDataBean.getEntryData().getPodatek()/100;
		Double kosztStaly = EntryDataBean.getEntryData().getKosztStaly();
		Double kasaStart = EntryDataBean.getEntryData().getGotowka();
		Double amortyzacja = EntryDataBean.getEntryData().getAmortyzacja();
		Double zadluzenie = EntryDataBean.getEntryData().getZadluzenie();
		Integer liczbaEtapowDoKonca = EntryDataBean.getEntryData().getIloscEtapowDoKonca();
		
		rata = (kredytValue + zadluzenie)*oprocentowanieKredytu + (kredytValue + zadluzenie)/liczbaEtapowDoKonca;
		
		kosztyProdukcji = 0.000014*jakoscValue*jakoscValue*jakoscValue - 0.0017663*jakoscValue*jakoscValue + 0.0965*jakoscValue + 6.78476+ 0.000003*wolumenValue;
		
		kosztyReklamy = reklamaTvValue+reklamaIntValue+reklamaMagValue;
		
		wolnaKasa = kasaStart+kredytValue-rata-amortyzacja-kosztyReklamy-kosztStaly-wolumenValue*kosztyProdukcji;
		
		przychod = wolumenValue*cenaValue + wolnaKasa*oprocentowanieKonta;
		
		wysokoscPodatku = przychod*podatek;
		
		profit = wolnaKasa + przychod - wysokoscPodatku;

		return profit;
	}
}
