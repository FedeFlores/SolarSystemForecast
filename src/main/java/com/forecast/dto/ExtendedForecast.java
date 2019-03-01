package com.forecast.dto;

public class ExtendedForecast {

	private Long dryDays;
	private Long rainDays;
	private String maxRainDay;
	private Long optimalDays;

	/**
	 * @return the dryDays
	 */
	public Long getDryDays() {
		return dryDays;
	}

	/**
	 * @param dryDays the dryDays to set
	 */
	public void setDryDays(Long dryDays) {
		this.dryDays = dryDays;
	}

	/**
	 * @return the rainDays
	 */
	public Long getRainDays() {
		return rainDays;
	}

	/**
	 * @param rainDays the rainDays to set
	 */
	public void setRainDays(Long rainDays) {
		this.rainDays = rainDays;
	}

	/**
	 * @return the maxRainDay
	 */
	public String getMaxRainDay() {
		return maxRainDay;
	}

	/**
	 * @param maxRainDay the maxRainDay to set
	 */
	public void setMaxRainDay(String maxRainDay) {
		this.maxRainDay = maxRainDay;
	}

	/**
	 * @return the optimalDays
	 */
	public Long getOptimalDays() {
		return optimalDays;
	}

	/**
	 * @param optimalDays the optimalDays to set
	 */
	public void setOptimalDays(Long optimalDays) {
		this.optimalDays = optimalDays;
	}

}
