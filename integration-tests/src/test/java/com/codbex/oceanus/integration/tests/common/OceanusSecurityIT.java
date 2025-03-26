package com.codbex.oceanus.integration.tests.common;

import org.eclipse.dirigible.commons.config.Configuration;
import org.eclipse.dirigible.integration.tests.api.SecurityIT;
import org.eclipse.dirigible.tests.util.PortUtil;

class OceanusSecurityIT extends SecurityIT {

    static {
        Configuration.set("DIRIGIBLE_SFTP_PORT", Integer.toString(PortUtil.getFreeRandomPort()));
    }
}
