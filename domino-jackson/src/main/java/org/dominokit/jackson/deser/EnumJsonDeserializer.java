/*
 * Copyright 2013 Nicolas Morel
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

package org.dominokit.jackson.deser;

import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializer;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.stream.JsonReader;

/**
 * Default {@link org.dominokit.jackson.JsonDeserializer} implementation for {@link java.lang.Enum}.
 *
 * @param <E> Type of the enum
 */
public class EnumJsonDeserializer<E extends Enum<E>> extends JsonDeserializer<E> {

  /**
   * newInstance
   *
   * @param enumClass class of the enumeration
   * @param values {@link E[]}
   * @param <E> the enum type
   * @return a new instance of {@link org.dominokit.jackson.deser.EnumJsonDeserializer}
   */
  public static <E extends Enum<E>> EnumJsonDeserializer<E> newInstance(
      Class<E> enumClass, E[] values) {
    return new EnumJsonDeserializer<E>(enumClass, values);
  }

  private final Class<E> enumClass;
  private final E[] values;

  /**
   * Constructor for EnumJsonDeserializer.
   *
   * @param enumClass class of the enumeration
   * @param values {@link E[]} enum values
   */
  protected EnumJsonDeserializer(Class<E> enumClass, E[] values) {
    if (null == enumClass) {
      throw new IllegalArgumentException("enumClass cannot be null");
    }
    this.enumClass = enumClass;
    this.values = values;
  }

  /** {@inheritDoc} */
  @Override
  public E doDeserialize(
      JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
    try {
      return getEnum(values, reader.nextString());
    } catch (IllegalArgumentException ex) {
      if (ctx.isReadUnknownEnumValuesAsNull()) {
        return null;
      }
      throw ex;
    }
  }

  public <E extends Enum<E>> E getEnum(E[] values, String name) {
    for (int i = 0; i < values.length; i++) {
      if (values[i].name().equals(name)) {
        return values[i];
      }
    }
    throw new IllegalArgumentException(
        "[" + name + "] is not a valid enum constant for Enum type " + getEnumClass().getName());
  }

  /**
   * Getter for the field <code>enumClass</code>.
   *
   * @return a {@link java.lang.Class} object.
   */
  public Class<E> getEnumClass() {
    return enumClass;
  }
}
