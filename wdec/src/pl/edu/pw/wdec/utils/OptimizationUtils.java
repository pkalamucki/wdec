package pl.edu.pw.wdec.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.ojalgo.netio.Message;

import pl.edu.pw.wdec.data.EntryData;
import pl.edu.pw.wdec.data.OutputData;
import se.optimatika.ampl.JAMPL;

public class OptimizationUtils {
	
	private static JAMPL jampl;
	private static String model;
	private static String params;

	/**
	 * <p>Optymalizuje zysk przy zadanych parametrach wejsciowych i akceptowalnym poziomie ryzyka</p>
	 * <p>Po zakonczonej optymalizacji dodaje zmapowane wartosci zysk - parametry wynikowe 
	 * do globalnie dostepnej mapy z {@linkplain MappingFactory}
	 * 
	 * @param data - wektor parametrow wejsciowych symulacji
	 * @param risk - akceptowalne ryzyko
	 * @return - oczekiwany zysk
	 */
	public static Double OptimizeProfit(EntryData data, Double risk) {		
		Map<Double, OutputData> map = MappingFactory.getProfitOutputMap();
		Double profit = 0.0;
		OutputData outputData = null;
		prepareOptimization(data, risk);
		optimize();
		outputData = fillOutputData();
		profit = getProfit();
		map.put(profit, outputData);
		return profit;
	}
	
	/**
	 * Wyciaga z listy komunikatow AMPLa wartosc zysku
	 * @return - zysk wyliczony przez solwer
	 */
	private static Double getProfit() {
		return getValue("przychod");
	}

	/**
	 * Wyciaga z listy komunikatow AMPLa wartosci ktore nalezy podac w symulatorze
	 * @return - wypelniony obiekt {@linkplain OutputData}
	 */
	private static OutputData fillOutputData() {
		OutputData outputData = new OutputData();
		outputData.setCena(getValue("cena"));
		outputData.setJakosc(getValue("jakosc"));
		outputData.setKredyt(getValue("kredyt"));
		outputData.setRata(getValue("rata"));
		outputData.setReklamaMagazyn(getValue("koszt_reklamy_magazyny"));
		outputData.setReklamaNet(getValue("koszt_reklamy_net"));
		outputData.setReklamaTv(getValue("koszt_reklamy_tv"));
		outputData.setWolumen(getValue("wolumen"));
		return outputData;
	}

	public static Double getValue(String string) {
		List<Message> messages = jampl.communicate(new Message("display "+string+";\n"));
		for (Message m : messages) {
			String k = m.toString();
			k = k.replaceAll("\\n", "");
			k = k.replaceAll("display "+ string + " = ", "");
			k = k.replaceAll(";", "");
			return Double.parseDouble(k);
		}
		return null;
	}

	/**
	 * uruchamia optymalizacje AMPLa na podstawie danych przygotowanych przez prepareOptimization
	 * @return lista zawierajaca wartosci zmiennych po zakonczonej optymalizacji
	 */
	private static void optimize() {
		
		String command = "reset;\n"+model+"\n data;\n"+params+" solve;\n";
		jampl.communicate(new Message(command));
		
	}

	/**
	 * Przygotowuje dane potrzebne do uruchomienia optymalizacji.
	 * @param data - dane wesciowe (stan symulacji)
	 * @param risk - ryzyko, dla ktorego bedziemy optymalizowac
	 */
	private static void prepareOptimization(EntryData data, Double risk) {
		if(jampl == null) {
			jampl = new JAMPL();
		}
		model = readfile("model2.mod");
		params = createParams(risk);
	}	
	
	public static String readfile(final String fname) {
		int n;
		final byte buf[] = new byte[1000];
		String s = new String("");
		FileInputStream in;

		try {
			in = new FileInputStream(fname);
		} catch (final FileNotFoundException e) {
			System.err.println(e + " can't open " + fname);
			return e + " can't open " + fname;
		}
		try {
			while ((n = in.read(buf)) > 0) {
				final String s1 = new String(buf, 0, 0, n);
				s = s + s1;
			}
		} catch (final IOException e) {
			System.err.println(e + " readfile error");
			return e + " readfile error";
		}
		return s;
	}
	
	private static String createParams(Double risk) {
		EntryData entry = EntryDataBean.getEntryData();
		String p = new String();
		p += "param koszty_stale := "+entry.getKosztStaly()+";\n";
		p += "param oprocentowanie_konta := "+entry.getProcentKonta()/100+";\n";
		p += "param oprocentowanie_kredytu := "+entry.getProcentKredytu()/100+";\n";
		p += "param aktualna_gotowka := "+entry.getGotowka()+";\n";
		p += "param ryzyko_max := "+risk+";\n";
		p += "param podatek := "+entry.getPodatek()+";\n";
		p += "param kredyt_max := "+entry.getMaxKredyt()+";\n";
		p += "param amortyzacja := "+entry.getAmortyzacja()+";\n";
		p += "param ilosc_etapow_do_konca := "+entry.getIloscEtapowDoKonca()+";\n";
		p += "param zadluzenie := "+entry.getZadluzenie()+";\n";
		return p;
	}

}
