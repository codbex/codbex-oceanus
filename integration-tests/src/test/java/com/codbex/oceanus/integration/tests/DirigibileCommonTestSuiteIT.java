package com.codbex.oceanus.integration.tests;

import org.eclipse.dirigible.commons.config.Configuration;
import org.eclipse.dirigible.integration.tests.api.SecurityIT;
import org.eclipse.dirigible.integration.tests.api.javascript.cms.CmsSuiteIT;
import org.eclipse.dirigible.tests.util.PortUtil;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({//
        CmsSuiteIT.class, //
        SecurityIT.class //
})
public class DirigibileCommonTestSuiteIT {

    static {
        Configuration.set("DIRIGIBLE_SFTP_PORT", Integer.toString(PortUtil.getFreeRandomPort()));
    }
}
