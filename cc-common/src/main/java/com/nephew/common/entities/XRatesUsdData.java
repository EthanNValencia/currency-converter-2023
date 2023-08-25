package com.nephew.common.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/***
 * This class holds currency related data.
 */
@Entity
@Table(name = "x_rates")
public class XRatesUsdData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String base;
	private String quote;
	private String date;
	private String description;
	private String xRate;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
	
	


	public String getxRate() {
		return xRate;
	}

	public void setxRate(String xRate) {
		this.xRate = xRate;
	}

	/***
	 * The mutator method for the description variable.
	 * 
	 * @param description It requires a string containing the currency description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/***
	 * Standard accessor method that is used to return the object description.
	 * 
	 * @return Returns the full currency description.
	 */
	public String getDescription() {
		return description;
	}

	/***
	 * Standard accessor method that is used to return the object date record.
	 * 
	 * @return Returns the date. It should be in the format of: YYYY-MM-DD.
	 */
	public String getDate() {
		return date;
	}

	/***
	 * Standard mutator method. Should only be used for testing purposes.
	 * 
	 * @param date Requires the date. It should be in the format of: YYYY-MM-DD.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/***
	 * Standard mutator method that sets the object name.
	 * 
	 * @param name Requires the specified name.
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}

	/***
	 * Standard mutator method that sets the object rate.
	 * 
	 * @param rawRate Requires the specified rate.
	 */
	public void setXRate(String xRate) {
		this.xRate = xRate;
	}

	/***
	 * The accessor method for the field that stores the name.
	 * 
	 * @return Returns the data that is contained in the specified variable.
	 */
	public String getQuote() {
		return quote;
	}

	/***
	 * The accessor method for the field that stores the rate.
	 * 
	 * @return Returns the data that is contained in the specified variable.
	 */
	public String getXRate() {
		return xRate;
	}

	/***
	 * Zero parameter constructor. It is great for testing.
	 */
	public XRatesUsdData() {
		// No parameters required.
	}

	/***
	 * Single parameter ServerCurrency constructor.
	 */
	public XRatesUsdData(String name) {
		this.quote = name;
	}

	/***
	 * This is a two parameter constructor for the server currency object.
	 * 
	 * @param name    It takes a name (this is meant to be the name of the
	 *                currency).
	 * @param rawRate It takes a rate (this is meant to be the exchange rate).
	 */
	public XRatesUsdData(String name, String rawRate) {
		this.quote = name;
		this.xRate = rawRate;
	}

	/***
	 * This is a 3 parameter constructor. It requires the name, rate, and
	 * description.
	 * 
	 * @param name        It takes a name (this is meant to be the name of the
	 *                    currency).
	 * @param rawRate     It takes a rate (this is meant to be the exchange rate).
	 * @param description It takes the description of the object.
	 */
	public XRatesUsdData(String name, String rawRate, String description) {
		this.quote = name;
		this.xRate = rawRate;
		this.description = description;
	}

	/***
	 * The ServerCurrency is a child class of the CC_Directory.Currency class. It
	 * only differs in that it has an addition date variable.
	 * 
	 * @param name    It requires the name of the currency.
	 * @param rawRate It requires the exchange rate from USD to itself.
	 * @param date    It requires the date on which this exchange rate was recorded.
	 */
	public XRatesUsdData(String quote, String rawRate, String date, String description) {
		this.base = "USD";
		this.quote = quote;
		this.xRate = rawRate;
		this.date = date;
		this.description = description;
	}

	
	/***
	 * Overridden toString method that is mostly useful for testing.
	 * 
	 * @return It returns the object variables in a string, useful for testing
	 *         purposes.
	 */
	@Override
	public String toString() {
		return "XRatesData [name=" + quote + ", date=" + date + ", description=" + description + ", rawRate=" + xRate
				+ "]";
	}

	/***
	 * This is the overridden equals method that is useful for comparing
	 * ServerCurrency objects with the goal of eliminating duplicates.
	 * 
	 * @param o It takes a generic object to be compared.
	 * @return It returns whether or not the hashcode of each object is equal or
	 *         not.
	 */
	@Override
	public boolean equals(Object o) {
		XRatesUsdData that = (XRatesUsdData) o;
		return Objects.equals(hashCode(), that.hashCode());
	}

	/***
	 * This is the overridden hash code method that is useful for comparing
	 * ServerCurrency objects with the goal of eliminating duplicates.
	 * 
	 * @return It uses the object name and date as a basis for comparison.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(quote, date);
	}
}