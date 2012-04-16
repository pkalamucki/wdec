package pl.edu.pw.wdec.wiev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JSpinner;

import pl.edu.pw.wdec.data.ChartPoint;
import pl.edu.pw.wdec.data.EntryData;
import pl.edu.pw.wdec.utils.ChartPointsGenerator;
import pl.edu.pw.wdec.utils.EntryDataBean;

public class Wejscie extends JPanel{
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3724977009236403349L;
	
	private static final Double MIN_RISK = 0.0;
	private static final Double MAX_RISK = 1.0;
	private static final Double STEP = 0.01;
	
	private javax.swing.JSpinner amortyzacja;
    private javax.swing.JSpinner gotowka;
    private javax.swing.JLabel majatekLabel;
    private javax.swing.JLabel zdolnoscLabel;

    private javax.swing.JLabel maksKredytLabel;
    private javax.swing.JLabel gotowkaLabel;
    private javax.swing.JLabel zadluzenieLabel;
    private javax.swing.JLabel amortyzacjaLabel;
    private javax.swing.JLabel kosztyLabel;
    private javax.swing.JLabel oprocKontaLabel;
    private javax.swing.JLabel oprocKredytuLabel;
    private javax.swing.JLabel podatekLabel;
    private javax.swing.JSpinner koszty;
    private javax.swing.JButton liczenie;
    private javax.swing.JSpinner majatek;
    private javax.swing.JSpinner maxKredyt;
    private javax.swing.JSpinner oprocentowanieBank;
    private javax.swing.JSpinner oprocentowanieKredytu;
    private javax.swing.JSpinner podatek;
    private javax.swing.JSpinner zadluzenie;
    private javax.swing.JSpinner zdolnosc;
    
    private Wykres wykresPanel;
    private EntryData data;

    
	public Wykres getWykresPanel() {
		return wykresPanel;
	}

	public Wejscie(){       
		data = EntryDataBean.getEntryData();
        Set<ChartPoint> points = ChartPointsGenerator.generateChartPoints(data, MIN_RISK, MAX_RISK, STEP);
        wykresPanel = new Wykres(points);
		initComponents();
	}

	private void initComponents() {
        
        majatekLabel = new javax.swing.JLabel();
        majatek = new javax.swing.JSpinner();
        majatek.setValue(data.getMajatekTrwaly());
        majatek.setEditor(new JSpinner.NumberEditor(majatek,  "###,###,##0.00"));
        majatek.getAccessibleContext().setAccessibleName("majatekInput");
        
        maksKredytLabel = new javax.swing.JLabel();
        maxKredyt = new javax.swing.JSpinner();
        maxKredyt.setValue(data.getMaxKredyt());
        maxKredyt.setEditor(new JSpinner.NumberEditor(maxKredyt,  "###,###,##0.00"));
        
        gotowkaLabel = new javax.swing.JLabel();
        gotowka = new javax.swing.JSpinner();
        gotowka.setValue(data.getGotowka());
        gotowka.setEditor(new JSpinner.NumberEditor(gotowka,  "###,###,##0.00"));
        
        zadluzenieLabel = new javax.swing.JLabel();
        zadluzenie = new javax.swing.JSpinner();
        zadluzenie.setValue(data.getZadluzenie());
        zadluzenie.setEditor(new JSpinner.NumberEditor(zadluzenie,  "###,###,##0.00"));
        
        amortyzacjaLabel = new javax.swing.JLabel();
        amortyzacja = new javax.swing.JSpinner();
        amortyzacja.setValue(data.getAmortyzacja());
        amortyzacja.setEditor(new JSpinner.NumberEditor(amortyzacja,  "###,###,##0.00"));
        
        kosztyLabel = new javax.swing.JLabel();
        koszty = new javax.swing.JSpinner();
        koszty.setValue(data.getKosztStaly());
        koszty.setEditor(new JSpinner.NumberEditor(koszty,  "###,###,##0.00"));
        
        oprocKontaLabel = new javax.swing.JLabel();
        oprocentowanieBank = new javax.swing.JSpinner();
        oprocentowanieBank.setValue(data.getProcentKonta());
        oprocentowanieBank.setEditor(new JSpinner.NumberEditor(oprocentowanieBank,  "###,###,##0.00"));
        
        oprocKredytuLabel = new javax.swing.JLabel();
        oprocentowanieKredytu = new javax.swing.JSpinner();
        oprocentowanieKredytu.setValue(data.getProcentKredytu());
        oprocentowanieKredytu.setEditor(new JSpinner.NumberEditor(oprocentowanieKredytu,  "###,###,##0.00"));
        
        podatekLabel = new javax.swing.JLabel();
        podatek = new javax.swing.JSpinner();
        podatek.setValue(data.getPodatek());
        podatek.setEditor(new JSpinner.NumberEditor(podatek,  "###,###,##0.00"));
        
        
        zdolnoscLabel = new javax.swing.JLabel();
        zdolnosc = new javax.swing.JSpinner();
        zdolnosc.setValue(data.getMaxProdukcja());
		zdolnosc.setEditor(new JSpinner.NumberEditor(zdolnosc, "###,###,##0.00"));
        
        liczenie = new javax.swing.JButton();
	
        
        majatekLabel.setText("Majatek trwaly");

        maksKredytLabel.setText("Maksymalny kredyt");

        gotowkaLabel.setText("Ilosc gotowki");

        zadluzenieLabel.setText("Zadluzenie firm");

        amortyzacjaLabel.setText("Amortyzacja");

        kosztyLabel.setText("Koszty stale");

        oprocKontaLabel.setText("Oprocentowanie konta bankowego");

        oprocKredytuLabel.setText("Oprocentowanie kredytu");

        podatekLabel.setText("Stawka podatku");

        zdolnoscLabel.setText("Maksymalna zdolnosc produkcyjna");
        


        liczenie.setText("Zapisz");
        
        this.setAlignmentX(1.0F);
        this.setAlignmentY(1.0F);
        this.setPreferredSize(new java.awt.Dimension(400, 280));
        
        
        liczenie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				data.setMajatekTrwaly((Double) majatek.getValue());
				data.setMaxKredyt((Double) maxKredyt.getValue());
				data.setGotowka((Double) gotowka.getValue());
				data.setZadluzenie((Double) zadluzenie.getValue());
				data.setAmortyzacja((Double) amortyzacja.getValue());
				data.setKosztStaly((Double) koszty.getValue());
				data.setProcentKonta((Double) oprocentowanieBank.getValue());
				data.setProcentKredytu((Double) oprocentowanieKredytu.getValue());
				data.setPodatek((Double) podatek.getValue());
				data.setMaxProdukcja((Double) zdolnosc.getValue());
				
				//wejscie.generujPkty();
				wykresPanel.change(data);
	//			System.out.println("cre");
				
				
			}
		});
        
        
        javax.swing.GroupLayout wejscieTabLayout = new javax.swing.GroupLayout(this);
        this.setLayout(wejscieTabLayout);
        wejscieTabLayout.setHorizontalGroup(
            wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wejscieTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(liczenie)
                    .addGroup(wejscieTabLayout.createSequentialGroup()
                        .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oprocKontaLabel)
                            .addComponent(kosztyLabel)
                            .addComponent(oprocKredytuLabel)
                            .addComponent(amortyzacjaLabel)
                            .addComponent(zadluzenieLabel)
                            .addComponent(gotowkaLabel)
                            .addComponent(majatekLabel)
                            .addComponent(maksKredytLabel)
                            .addComponent(podatekLabel)
                            .addComponent(zdolnoscLabel))
                        .addGap(18, 18, 18)
                        .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(zdolnosc)
                            .addComponent(podatek)
                            .addComponent(majatek)
                            .addComponent(maxKredyt)
                            .addComponent(gotowka)
                            .addComponent(zadluzenie)
                            .addComponent(amortyzacja)
                            .addComponent(oprocentowanieKredytu)
                            .addComponent(koszty)
                            .addComponent(oprocentowanieBank, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                .addGap(360, 360, 360))
        );
        wejscieTabLayout.setVerticalGroup(
            wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wejscieTabLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majatekLabel)
                    .addComponent(majatek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maksKredytLabel)
                    .addComponent(maxKredyt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gotowkaLabel)
                    .addComponent(gotowka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zadluzenieLabel)
                    .addComponent(zadluzenie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amortyzacjaLabel)
                    .addComponent(amortyzacja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kosztyLabel)
                    .addComponent(koszty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oprocKontaLabel)
                    .addComponent(oprocentowanieBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oprocKredytuLabel)
                    .addComponent(oprocentowanieKredytu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(podatekLabel)
                    .addComponent(podatek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(wejscieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zdolnoscLabel)
                    .addComponent(zdolnosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(liczenie)
                .addGap(33, 33, 33))
        );

	}
	
	
}
