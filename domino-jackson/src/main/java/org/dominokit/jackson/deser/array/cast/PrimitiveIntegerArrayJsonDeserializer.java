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

package org.dominokit.jackson.deser.array.cast;

import org.dominokit.jackson.JacksonContextProvider;
import org.dominokit.jackson.JsonDeserializationContext;
import org.dominokit.jackson.JsonDeserializerParameters;
import org.dominokit.jackson.deser.BaseNumberJsonDeserializer;
import org.dominokit.jackson.deser.array.AbstractArrayJsonDeserializer;
import org.dominokit.jackson.stream.JsonReader;

/** Default {@link org.dominokit.jackson.JsonDeserializer} implementation for array of int. */
public class PrimitiveIntegerArrayJsonDeserializer extends AbstractArrayJsonDeserializer<int[]> {

  private static final PrimitiveIntegerArrayJsonDeserializer INSTANCE =
      new PrimitiveIntegerArrayJsonDeserializer();

  /**
   * @return an instance of {@link
   *     org.dominokit.jackson.deser.array.cast.PrimitiveIntegerArrayJsonDeserializer}
   */
  public static PrimitiveIntegerArrayJsonDeserializer getInstance() {
    return INSTANCE;
  }

  private PrimitiveIntegerArrayJsonDeserializer() {}

  /** {@inheritDoc} */
  @Override
  public int[] doDeserializeArray(
      JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
    return JacksonContextProvider.get().integerArrayReader().readArray(reader);
  }

  /** {@inheritDoc} */
  @Override
  protected int[] doDeserializeSingleArray(
      JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
    return new int[] {
      BaseNumberJsonDeserializer.IntegerJsonDeserializer.getInstance()
          .deserialize(reader, ctx, params)
    };
  }
}
