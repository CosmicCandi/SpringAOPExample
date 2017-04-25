package com.fdmgroup.academy.enums;

import java.util.Random;

public enum Company {
	BOA, UBS, RBS, CITI, JPMORGAN, MORGANSTANLEY, METLIFE, BARCLAYS, HSBC,
	FANNIE_MAE, WELLS_FARGO, RAYMOND_JAMES, RBC, BAML, SIRIUS_XM, CREDIT_SUISSE, JOHNSON_JOHNSON,
	MCKINSEY;

	public static Company getRandom() {

		Company[] companies = Company.values();
		Random random = new Random();

		return companies[random.nextInt(companies.length)];
	}
}