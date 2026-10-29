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
package com.codbex.oceanus.integration.tests;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Like Spring Boot's own component scan, the scan leaves the test configurations to the tests that
 * import them, and honours {@link JavaScriptTestsExclusion}.
 */
@ComponentScan(basePackages = "org.eclipse.dirigible",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
@TestConfiguration
class TestConfigurations {
}
