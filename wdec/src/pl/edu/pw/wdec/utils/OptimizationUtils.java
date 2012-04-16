package pl.edu.pw.wdec.utils;

import java.util.List;
import java.util.Map;

import org.ojalgo.netio.Message;

import pl.edu.pw.wdec.data.EntryData;
import pl.edu.pw.wdec.data.OutputData;
import se.optimatika.ampl.JAMPL;

public class OptimizationUtils {
	
	private static JAMPL jampl;

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
		List<Message> messages = optimize();
		outputData = fillOutputData(messages);
		profit = getProfit(messages);
		map.put(profit, outputData);
		return profit;
	}
	
	/**
	 * Wyciaga z listy komunikatow AMPLa wartosc zysku
	 * @param messages - lista komunikatow AMPLa
	 * @return - zysk wyliczony przez solwer
	 */
	private static Double getProfit(List<Message> messages) {
		//TODO wyci¹gn¹æ wartoœæ profitu z komunikatów
		return null;
	}

	/**
	 * Wyciaga z listy komunikatow AMPLa wartosci ktore nalezy podac w symulatorze
	 * @param messages - lista komunikatow AMPLa
	 * @return - wypelniony obiekt {@linkplain OutputData}
	 */
	private static OutputData fillOutputData(List<Message> messages) {
		//TODO zape³niæ outputData na podstawie komunikatów
		return null;
	}

	/**
	 * uruchamia optymalizacje AMPLa na podstawie danych przygotowanych przez prepareOptimization
	 * @return lista zawierajaca wartosci zmiennych po zakonczonej optymalizacji
	 */
	private static List<Message> optimize() {
		//TODO przygotowaæ komende do wyslania do ampla
		String command = "reset; ";
		return jampl.communicate(new Message(command));
		
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
		//TODO przygotowaæ pliki .mod, .dat itp
	}	

}
