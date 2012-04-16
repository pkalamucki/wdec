package pl.edu.pw.wdec.utils;

import pl.edu.pw.wdec.data.EntryData;


/**
 * Klasa udostepniajaca globalne parametry wejsciowe z klasy {@linkplain EntryData}
 * @author cor
 *
 */
public class EntryDataBean {
	
	private static EntryData entryData;
	
	public static synchronized EntryData getEntryData() {
		if (entryData == null) {
			entryData = new EntryData(1000000.0, 800000.0, 300000.0,
					0.0, 10000.0, 5000.0, 6.0, 4.0,
					19.0, 400000.0);
		}
		return entryData;
	}
}
