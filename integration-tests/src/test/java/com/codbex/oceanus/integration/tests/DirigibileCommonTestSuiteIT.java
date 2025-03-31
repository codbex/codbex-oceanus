package com.codbex.oceanus.integration.tests;

import org.eclipse.dirigible.commons.config.Configuration;
import org.eclipse.dirigible.tests.util.PortUtil;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({//
// no tests for now, until https://github.com/eclipse-dirigible/dirigible/pull/4829 is released
// CmsSuiteIT.class, //
// SecurityIT.class //
})
public class DirigibileCommonTestSuiteIT {

    static {
        Configuration.set("DIRIGIBLE_SFTP_PORT", Integer.toString(PortUtil.getFreeRandomPort()));
    }
}
