package com.codbex.oceanus.integration.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({//
// no tests for now, until https://github.com/eclipse-dirigible/dirigible/pull/4829 is released
// CmsSuiteIT.class, //
// SecurityIT.class //
})
public class DirigibileCommonTestSuiteIT {

}
