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

package org.dominokit.jackson.deser.collection;

import java.util.PriorityQueue;
import org.dominokit.jackson.JsonDeserializer;

/**
 * Default {@link org.dominokit.jackson.JsonDeserializer} implementation for {@link
 * java.util.PriorityQueue}.
 *
 * @param <T> Type of the elements inside the {@link java.util.PriorityQueue}
 */
public class PriorityQueueJsonDeserializer<T>
    extends BaseQueueJsonDeserializer<PriorityQueue<T>, T> {

  /**
   * newInstance
   *
   * @param deserializer {@link org.dominokit.jackson.JsonDeserializer} used to deserialize the
   *     objects inside the {@link java.util.PriorityQueue}.
   * @param <T> Type of the elements inside the {@link java.util.PriorityQueue}
   * @return a new instance of {@link
   *     org.dominokit.jackson.deser.collection.PriorityQueueJsonDeserializer}
   */
  public static <T> PriorityQueueJsonDeserializer<T> newInstance(JsonDeserializer<T> deserializer) {
    return new PriorityQueueJsonDeserializer<T>(deserializer);
  }

  /**
   * @param deserializer {@link JsonDeserializer} used to deserialize the objects inside the {@link
   *     PriorityQueue}.
   */
  private PriorityQueueJsonDeserializer(JsonDeserializer<T> deserializer) {
    super(deserializer);
  }

  /** {@inheritDoc} */
  @Override
  protected PriorityQueue<T> newCollection() {
    return new PriorityQueue<T>();
  }
}
