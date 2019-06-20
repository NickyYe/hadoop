/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.server.timelineservice.documentstore.collection.document.entity;

import org.apache.hadoop.yarn.api.records.timelineservice.TimelineEvent;
import org.apache.hadoop.yarn.util.TimelineServiceHelper;

import java.util.Map;

/**
 * This class represents a Sub Document for {@link TimelineEvent}
 * when creating a new {@link TimelineEntityDocument}.
 */
public class TimelineEventSubDoc {

  private final TimelineEvent timelineEvent;
  private boolean valid;

  public TimelineEventSubDoc() {
    timelineEvent = new TimelineEvent();
  }

  public TimelineEventSubDoc(TimelineEvent timelineEvent) {
    this.timelineEvent = timelineEvent;
  }

  public String getId() {
    return timelineEvent.getId();
  }

  public void setId(String eventId) {
    timelineEvent.setId(eventId);
  }

  public boolean isValid() {
    return timelineEvent.isValid();
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  public long getTimestamp() {
    return timelineEvent.getTimestamp();
  }

  public void setTimestamp(long ts) {
    timelineEvent.setTimestamp(ts);
  }

  public Map<String, Object> getInfo() {
    return timelineEvent.getInfo();
  }

  public void setInfo(Map<String, Object> info) {
    timelineEvent.setInfo(TimelineServiceHelper.mapCastToHashMap(info));
  }

  @Override
  public int hashCode() {
    return 31 * timelineEvent.getId().hashCode();
  }

  // Only check if id is equal
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof TimelineEventSubDoc)) {
      return false;
    }
    TimelineEventSubDoc otherTimelineEvent = (TimelineEventSubDoc) obj;
    return this.timelineEvent.getId().equals(otherTimelineEvent.getId());
  }

  public TimelineEvent fetchTimelineEvent() {
    return timelineEvent;
  }
}