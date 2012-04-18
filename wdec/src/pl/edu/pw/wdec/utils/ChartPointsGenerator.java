package pl.edu.pw.wdec.utils;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pw.wdec.data.ChartPoint;
import pl.edu.pw.wdec.data.EntryData;
/**
 * Klasa narzedziowa umozliwiajaca wygenerowanie punktow do wykresu
 * @author cor
 *
 */
public class ChartPointsGenerator {
	
	/**
	 * Generuje zbior {@linkplain ChartPoint} - punktow na wykresie w zadanym zakresie ryzyka i z danym skokiem
	 * @param data - parametry wejsciowe - stan symulacji
	 * @param minRisk - minimalne ryzyko dla ktorego bedzie wyznaczany wykres
	 * @param maxRisk - maksymalne ryzyko dla ktorego bedzie wyznaczany wykres
	 * @param step - wartosc skoku, o ktory zwieszy sie ryzyko w kolejnej iteracji
	 * @return - zbior punktow wyznaczajacych wykres
	 */
	public static List<ChartPoint> generateChartPoints(EntryData data, Double minRisk, Double maxRisk, Double step) {
		List<ChartPoint> points = new ArrayList<ChartPoint>();
		Double risk = minRisk;
		while (risk <= maxRisk) {
			ChartPoint point = new ChartPoint();
			point.setRisk(risk);
			Double profit = OptimizationUtils.OptimizeProfit(data, risk);
			point.setProfit(profit);
			
			points.add(point);
			
			risk += step;
		}
		return points;
	}
}
