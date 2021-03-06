/*
 * Copyright 2014 Nicolas Morel
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

package org.dominokit.jackson.ser.bean;

import java.util.Set;
import org.dominokit.jackson.JsonSerializationContext;
import org.dominokit.jackson.stream.JsonWriter;

/** Abstract AbstractValueBeanJsonSerializer class. */
public abstract class AbstractValueBeanJsonSerializer<T> extends AbstractBeanJsonSerializer<T> {

  private final BeanPropertySerializer<T, ?> serializer;

  /** Constructor for AbstractValueBeanJsonSerializer. */
  protected AbstractValueBeanJsonSerializer() {
    super();
    this.serializer = initValueSerializer();
  }

  /**
   * initValueSerializer
   *
   * @return a {@link org.dominokit.jackson.ser.bean.BeanPropertySerializer} object.
   */
  protected abstract BeanPropertySerializer<T, ?> initValueSerializer();

  /** {@inheritDoc} */
  @Override
  protected void serializeObject(
      JsonWriter writer,
      T value,
      JsonSerializationContext ctx,
      Set<String> ignoredProperties,
      IdentitySerializationInfo identityInfo,
      ObjectIdSerializer<?> idWriter,
      String typeName,
      String typeInformation) {
    serializer.serialize(writer, value, ctx);
  }
}
