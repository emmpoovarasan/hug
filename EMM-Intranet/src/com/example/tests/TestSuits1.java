package com.example.tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.*;

public class TestSuits1 extends TestCase {

	public static Test suite()
	{
	TestSuite suite = new TestSuite();
	suite.addTestSuite(findElementsInSignIn.class);
	suite.addTestSuite(SignInPage.class);
	suite.addTestSuite(SignInPageFR.class);
	suite.addTestSuite(SignInPageDE.class);
	return suite;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRunner.run(suite());
	}

}
