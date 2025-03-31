package com.codbex.oceanus.integration.tests.common;

import org.eclipse.dirigible.commons.config.Configuration;
import org.eclipse.dirigible.integration.tests.api.javascript.cms.CmsSuiteIT;
import org.eclipse.dirigible.tests.util.PortUtil;

class OceanusCmsSuiteIT extends CmsSuiteIT {

    static {
        Configuration.set("DIRIGIBLE_SFTP_PORT", Integer.toString(PortUtil.getFreeRandomPort()));
    }
}
