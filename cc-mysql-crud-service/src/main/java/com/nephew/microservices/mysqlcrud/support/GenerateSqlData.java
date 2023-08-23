package com.nephew.microservices.mysqlcrud.support;

public class GenerateSqlData {

	private final static String[] CURRENCY_NAMES = { "USD", "AED", "ARS", "AUD", "BGN", "BHD", "BND", "BRL", "BWP",
			"CAD", "CHF", "CLP", "CNY", "COP", "CZK", "DKK", "EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR",
			"IRR", "ISK", "JPY", "KRW", "KWD", "KZT", "LKR", "LYD", "MUR", "MXN", "MYR", "NOK", "NPR", "NZD", "OMR",
			"PHP", "PKR", "PLN", "QAR", "RON", "RUB", "SAR", "SEK", "SGD", "THB", "TRY", "TTD", "TWD", "VEF", "ZAR" };

	// Example
	// INSERT INTO pair (base_currency, quote_currency) VALUES ('USD', 'EUR'),
	// ('EUR', 'USD');
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO pair (base_currency, quote_currency) VALUES ");
		for (int i = 0; i < CURRENCY_NAMES.length; i++) {
			for (int j = 0; j < CURRENCY_NAMES.length; j++) {
				if (i != j) {
					stringBuilder.append("('" + CURRENCY_NAMES[i] + "','" + CURRENCY_NAMES[j] + "'),");
				}
				if (i == CURRENCY_NAMES.length - 1 && j == CURRENCY_NAMES.length - 1) {
					stringBuilder.deleteCharAt(stringBuilder.length() - 1);
					stringBuilder.append(";");
				}
			}
		}
		System.out.println(stringBuilder);
		/*
		 * Should generate 53*53+53 = 2862 pairs.
		 */
	}

}
