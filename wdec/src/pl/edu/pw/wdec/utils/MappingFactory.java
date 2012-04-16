
package pl.edu.pw.wdec.utils;

import java.util.HashMap;
import java.util.Map;

import pl.edu.pw.wdec.data.OutputData;
/**
 * Klasa fabryka mapujaca wyliczony zysk na parametry wyjsciowe
 * @author cor
 *
 */
public class MappingFactory {

	private static Map<Double, OutputData> map;
	
	public static synchronized Map<Double, OutputData> getProfitOutputMap() {
		if (map == null) {
			map = new HashMap<Double, OutputData>();
		}
		return map;
	}

}
