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

package com.progressoft.brix.domino.jacksonapt.ser.number;

import com.progressoft.brix.domino.jacksonapt.ser.AbstractJsonSerializerTest;
import com.progressoft.brix.domino.jacksonapt.ser.BaseNumberJsonSerializer.DoubleJsonSerializer;

/**
 * @author Nicolas Morel
 */
public class DoubleJsonSerializerTest extends AbstractJsonSerializerTest<Double> {

    @Override
    protected DoubleJsonSerializer createSerializer() {
        return DoubleJsonSerializer.getInstance();
    }

    public void testSerializeValue() {
        assertSerialization("34.100247", 34.100247);
        assertSerialization("-784.15454", -784.15454d);
        assertSerialization((!System.getProperty("superdevmode").equals("on") ? "5e-324" : "4.9E-324"), Double.MIN_VALUE);
        assertSerialization((!System.getProperty("superdevmode").equals("on") ? "1.7976931348623157e+308" : "1.7976931348623157E308"), Double.MAX_VALUE);
    }
}