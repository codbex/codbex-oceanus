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
package org.eclipse.dirigible;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Like Spring Boot's own component scan, the scan leaves the test configurations to the tests that
 * import them, and honours the type exclusions registered in the context: the product's
 * {@code JavaScriptTestsExclusion} leaves out the JavaScript test helpers of the Dirigible tests
 * suite, which need the server-side JavaScript engine (GraalJS) this product does not ship.
 */
@SpringBootConfiguration
@ComponentScan(basePackages = {"org.eclipse.dirigible", "com.codbex"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
class DirigibleCommonTestsConfiguration {
    // this class is needed for the dirigible tests suite
}
