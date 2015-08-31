/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-08-28 at 03:36:32 UTC 
 * Modify at your own risk.
 */

package com.brain_power.glassbus.backend.glassBus.model;

/**
 * Model definition for GetResponse.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the glassBus. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class GetResponse extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String encodedImageString;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String messageHeader;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String messageStatus;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private UserAccount user;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getEncodedImageString() {
    return encodedImageString;
  }

  /**
   * @param encodedImageString encodedImageString or {@code null} for none
   */
  public GetResponse setEncodedImageString(java.lang.String encodedImageString) {
    this.encodedImageString = encodedImageString;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessageHeader() {
    return messageHeader;
  }

  /**
   * @param messageHeader messageHeader or {@code null} for none
   */
  public GetResponse setMessageHeader(java.lang.String messageHeader) {
    this.messageHeader = messageHeader;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessageStatus() {
    return messageStatus;
  }

  /**
   * @param messageStatus messageStatus or {@code null} for none
   */
  public GetResponse setMessageStatus(java.lang.String messageStatus) {
    this.messageStatus = messageStatus;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public UserAccount getUser() {
    return user;
  }

  /**
   * @param user user or {@code null} for none
   */
  public GetResponse setUser(UserAccount user) {
    this.user = user;
    return this;
  }

  @Override
  public GetResponse set(String fieldName, Object value) {
    return (GetResponse) super.set(fieldName, value);
  }

  @Override
  public GetResponse clone() {
    return (GetResponse) super.clone();
  }

}