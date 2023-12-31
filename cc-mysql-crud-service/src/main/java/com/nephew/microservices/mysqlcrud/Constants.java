package com.nephew.microservices.mysqlcrud;

public class Constants {

	public enum CALENDRICAL_PERIOD {
		DAYS, WEEKS, MONTHS, YEARS
	}
	
    // Should I still use these?
    static String[] CREATE_TABLES = {
    		"CREATE TABLE IF NOT EXISTS cur_db.cur_description (currency_name VARCHAR(25), currency_description VARCHAR(250), PRIMARY KEY(currency_name));",
            "CREATE TABLE IF NOT EXISTS cur_db.cur_date (currency_date DATE, PRIMARY KEY(currency_date));",
            "CREATE TABLE IF NOT EXISTS cur_db.cur (currency_name VARCHAR(25), currency_rate varchar(25), currency_date DATE, PRIMARY KEY(currency_name, currency_date), CONSTRAINT fk_cur_name FOREIGN KEY (currency_name) REFERENCES cur_description(currency_name), CONSTRAINT fk_cur_date FOREIGN KEY (currency_date) REFERENCES cur_date(currency_date));",
            "CREATE TABLE IF NOT EXISTS cur_db.cur_calc (first_currency_name VARCHAR(25), second_currency_name VARCHAR(25), currency_rate DECIMAL(30, 15), currency_date DATE, PRIMARY KEY(first_currency_name, second_currency_name, currency_date), CONSTRAINT fk_calc_fir_cur_name FOREIGN KEY (first_currency_name) REFERENCES cur_description(currency_name), CONSTRAINT fk_calc_sec_cur_name FOREIGN KEY (second_currency_name) REFERENCES cur_description(currency_name), CONSTRAINT fk_calc_cur_date FOREIGN KEY (currency_date) REFERENCES cur_date(currency_date));"
            };

}
