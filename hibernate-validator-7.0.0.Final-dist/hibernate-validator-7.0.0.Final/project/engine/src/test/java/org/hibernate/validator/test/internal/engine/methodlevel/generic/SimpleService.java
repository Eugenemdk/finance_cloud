/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.test.internal.engine.methodlevel.generic;

import jakarta.validation.constraints.NotNull;

/**
 * @author Hardy Ferentschik
 */
public interface SimpleService<C> {
	void configure(@NotNull C config);

	void doIt(@NotNull C config);
}
