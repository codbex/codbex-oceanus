/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package com.codbex.oceanus.integration.tests.common;

import org.eclipse.dirigible.commons.config.Configuration;
import org.eclipse.dirigible.integration.tests.api.javascript.cms.CmsSuiteIT;
import org.eclipse.dirigible.tests.util.PortUtil;

class OceanusCmsSuiteIT extends CmsSuiteIT {

    static {
        Configuration.set("DIRIGIBLE_SFTP_PORT", Integer.toString(PortUtil.getFreeRandomPort()));
    }
}
