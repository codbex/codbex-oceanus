package com.codbex.oceanus.integration.tests;

import org.eclipse.dirigible.integration.tests.api.SecurityIT;
import org.eclipse.dirigible.integration.tests.api.javascript.cms.CmsSuiteIT;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({//
        CmsSuiteIT.class, //
        SecurityIT.class //
})
public class DirigibileCommonTestSuiteIT {
}
