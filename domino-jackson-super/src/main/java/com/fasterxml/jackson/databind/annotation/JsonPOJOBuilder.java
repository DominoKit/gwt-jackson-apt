/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fasterxml.jackson.databind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to configure details of a Builder class: instances of which are used as Builders
 * for deserialized POJO values, instead of POJOs being instantiated using constructors or factory
 * methods. Note that this annotation is NOT used to define what is the Builder class for a POJO:
 * rather, this is determined by {@link JsonDeserialize#builder} property of {@link
 * JsonDeserialize}.
 *
 * <p>Annotation is typically used if the naming convention of a Builder class is different from
 * defaults:
 *
 * <ul>
 *   <li>By default, setters are expected to have names like `withName()` (for property "name");
 *       override by {@link #withPrefix()} property.
 * </ul>
 *
 * <p>In addition to configuration using this annotation, note that many other configuration
 * annotations are also applied to Builders, for example {@link
 * com.fasterxml.jackson.annotation.JsonIgnoreProperties} can be used to ignore "unknown"
 * properties.
 *
 * @since 2.0
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@com.fasterxml.jackson.annotation.JacksonAnnotation
public @interface JsonPOJOBuilder {
  /** @since 2.9 */
  public static final String DEFAULT_BUILD_METHOD = "build";

  /** @since 2.9 */
  public static final String DEFAULT_WITH_PREFIX = "with";

  /**
   * Property to use for re-defining which zero-argument method is considered the actual
   * "build-method": method called after all data has been bound, and the actual instance needs to
   * be instantiated.
   *
   * <p>Default value is "build".
   *
   * @return String
   */
  public String buildMethodName() default DEFAULT_BUILD_METHOD;

  /**
   * Property used for (re)defining name prefix to use for auto-detecting "with-methods": methods
   * that are similar to "set-methods" (in that they take an argument), but that may also return the
   * new builder instance to use (which may be 'this', or a new modified builder instance). Note
   * that in addition to this prefix, it is also possible to use {@link
   * com.fasterxml.jackson.annotation.JsonProperty} annotation to indicate "with-methods" (as well
   * as com.fasterxml.jackson.annotation.JsonSetter).
   *
   * <p>Default value is "with", so that method named "withValue()" would be used for binding JSON
   * property "value" (using type indicated by the argument; or one defined with annotations.
   *
   * @return String
   */
  public String withPrefix() default DEFAULT_WITH_PREFIX;

  /*
  /**********************************************************
  /* Helper classes
  /**********************************************************
   */

  /**
   * Simple value container for containing values read from {@link JsonPOJOBuilder} annotation
   * instance.
   */
  public class Value {
    public final String buildMethodName;
    public final String withPrefix;

    public Value(JsonPOJOBuilder ann) {
      this(ann.buildMethodName(), ann.withPrefix());
    }

    public Value(String buildMethodName, String withPrefix) {
      this.buildMethodName = buildMethodName;
      this.withPrefix = withPrefix;
    }
  }
}
