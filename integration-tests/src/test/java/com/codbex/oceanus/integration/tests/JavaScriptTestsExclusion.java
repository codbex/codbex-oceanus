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

import java.io.IOException;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

/**
 * Leaves the JavaScript test helpers of the Dirigible tests suite out of every component scan that
 * honours Spring Boot's {@link TypeExcludeFilter} - the application's own scan of
 * {@code org.eclipse.dirigible} as well as the tests' ones: they need the server-side JavaScript
 * engine (GraalJS), which this product does not ship. Registered in
 * {@code META-INF/spring.factories}.
 */
public class JavaScriptTestsExclusion implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        String name = JavaScriptTestsFilter.class.getName();
        if (!beanFactory.containsSingleton(name)) {
            beanFactory.registerSingleton(name, new JavaScriptTestsFilter());
        }
    }

    /** Matches the classes of the Dirigible tests suite's JavaScript test package. */
    static final class JavaScriptTestsFilter extends TypeExcludeFilter {

        private static final String JAVASCRIPT_TESTS_PACKAGE = "org.eclipse.dirigible.integration.tests.api.javascript.";

        @Override
        public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
            return metadataReader.getClassMetadata()
                                 .getClassName()
                                 .startsWith(JAVASCRIPT_TESTS_PACKAGE);
        }

        @Override
        public boolean equals(Object other) {
            return other != null && getClass() == other.getClass();
        }

        @Override
        public int hashCode() {
            return getClass().hashCode();
        }
    }
}
