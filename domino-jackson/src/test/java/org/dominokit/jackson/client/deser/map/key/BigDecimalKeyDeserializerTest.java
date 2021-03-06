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

package org.dominokit.jackson.client.deser.map.key;

import java.math.BigDecimal;
import org.dominokit.jackson.deser.map.key.BaseNumberKeyDeserializer.BigDecimalKeyDeserializer;

/** @author Nicolas Morel */
public class BigDecimalKeyDeserializerTest extends AbstractKeyDeserializerTest<BigDecimal> {

  @Override
  protected BigDecimalKeyDeserializer createDeserializer() {
    return BigDecimalKeyDeserializer.getInstance();
  }

  @Override
  public void testDeserializeValue() {
    String value = "15487846511321245665435132032454.1545815468465578451323888744";
    BigDecimal expected = new BigDecimal(value);
    assertDeserialization(expected, value);
  }
}
