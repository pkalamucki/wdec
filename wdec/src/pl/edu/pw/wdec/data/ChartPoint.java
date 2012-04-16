package pl.edu.pw.wdec.data;

/**
 * Klasa reprezentujaca punkt na wykresie zysku od ryzyka
 * @author cor
 *
 */
public class ChartPoint {
	private Double risk;
	private Double profit;

	public ChartPoint(Double risk, Double profit) {
		this.risk = risk;
		this.profit = profit;
	}

	public ChartPoint() {
	}

	public Double getRisk() {
		return risk;
	}

	public void setRisk(Double risk) {
		this.risk = risk;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profit == null) ? 0 : profit.hashCode());
		result = prime * result + ((risk == null) ? 0 : risk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChartPoint other = (ChartPoint) obj;
		if (profit == null) {
			if (other.profit != null)
				return false;
		} else if (!profit.equals(other.profit))
			return false;
		if (risk == null) {
			if (other.risk != null)
				return false;
		} else if (!risk.equals(other.risk))
			return false;
		return true;
	}

}
