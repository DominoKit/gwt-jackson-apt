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

package org.dominokit.jackson.server.deser.map.key;

import org.dominokit.jackson.deser.map.key.BaseNumberKeyDeserializer;
import org.junit.Test;

/** @author Nicolas Morel */
public class ByteKeyDeserializerTest extends AbstractKeyDeserializerTest<Byte> {

  @Override
  protected BaseNumberKeyDeserializer.ByteKeyDeserializer createDeserializer() {
    return BaseNumberKeyDeserializer.ByteKeyDeserializer.getInstance();
  }

  @Override
  @Test
  public void testDeserializeValue() {
    assertDeserialization(new Byte("34"), "34");
    assertDeserialization(new Byte("1"), "1");
    assertDeserialization(Byte.MIN_VALUE, "-128");
    assertDeserialization(Byte.MAX_VALUE, "127");
  }
}