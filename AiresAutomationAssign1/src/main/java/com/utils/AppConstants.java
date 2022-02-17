package com.utils;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.commons.text.CharacterPredicates;

public class AppConstants {
	static final public String EmployeeFirstName = "Test";
	static final public String EmployeeLastName = "Assignment";
	static final public String RelocationPolicyType="Domestic Policy";
	static final public String OriginCity="Amsterdam";
	static final public String OriginState="New York";
	static final public String OriginCountry="USA";
	static final public String DestCity="Albany";
	static final public String DestState="New York";
	static final public String DestCountry="USA";
	static final public String AssignmentType="Short-Term EE Only";
	static final public String AuthorizedBy="Pritam Dash";
	static final public String INITIATION_SUBMISSION_SUCCESS_MESSAGE = "The initiation for # is in the submission process. You will receive an email notification when the initiation has been successfully submitted.";
	static final public String EXPENSE_SUBMISSION_MESSAGE = "Your employer requires you to maintain original receipts in your possession for 1 year for government audit purposes.";



	public static String randomStringGenerator(int len) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('A', 'Z')
				.filteredBy(CharacterPredicates.LETTERS)
                .build();
        return generator.generate(len);
	}


	
}
