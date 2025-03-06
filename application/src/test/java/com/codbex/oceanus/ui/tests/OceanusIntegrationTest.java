package com.codbex.oceanus.ui.tests;

import org.eclipse.dirigible.tests.UserInterfaceIntegrationTest;
import org.eclipse.dirigible.tests.util.PortUtil;
import org.springframework.context.annotation.Import;

@Import(TestConfigurations.class)
public abstract class OceanusIntegrationTest extends UserInterfaceIntegrationTest {

    static {
        System.setProperty("DIRIGIBLE_SFTP_PORT", Integer.toString(PortUtil.getFreeRandomPort()));
    }

}
