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
package org.dominokit.jackson.deser.array.cast;

import java.util.Stack;
import org.dominokit.jackson.GwtIncompatible;
import org.dominokit.jackson.JacksonContext;
import org.dominokit.jackson.stream.JsonReader;
import org.dominokit.jackson.stream.JsonToken;

/** The default JVM implementation for reading a Double array json */
@GwtIncompatible
public class DefaultDoubleArrayReader implements JacksonContext.DoubleArrayReader {
  /** {@inheritDoc} */
  @Override
  public double[] readArray(JsonReader reader) {
    Stack<Double> doubleStack = new Stack<>();
    reader.beginArray();
    while (JsonToken.END_ARRAY != reader.peek()) {
      if (JsonToken.NULL == reader.peek()) {
        reader.skipValue();
        doubleStack.push(null);
      } else {
        doubleStack.push(reader.nextDouble());
      }
    }
    reader.endArray();
    return doubleStack.stream().mapToDouble(Double::doubleValue).toArray();
  }
}
