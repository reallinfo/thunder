package com.sanction.thunder.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.FixtureHelpers;

import java.util.StringJoiner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailTest {
  private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

  // Test object should use the same values as the JSON object in 'resources/fixtures/email.json'
  private final Email email = new Email("test@test.com", true, "token");

  @Test
  void testJsonSerialization() throws Exception {
    String expected = MAPPER.writeValueAsString(
        MAPPER.readValue(FixtureHelpers.fixture("fixtures/email.json"), Email.class));

    assertEquals(expected, MAPPER.writeValueAsString(email));
  }

  @Test
  void testJsonDeserialization() throws Exception {
    Email fromJson = MAPPER.readValue(FixtureHelpers.fixture("fixtures/email.json"), Email.class);

    assertEquals(email, fromJson);
  }

  @Test
  @SuppressWarnings({"SimplifiableJUnitAssertion", "EqualsWithItself"})
  void testEqualsWithSelf() {
    assertTrue(email.equals(email));
  }

  @Test
  @SuppressWarnings("SimplifiableJUnitAssertion")
  void testEqualsWithDifferentObjectType() {
    Object objectTwo = new Object();

    assertFalse(email.equals(objectTwo));
  }

  @Test
  void testHashCodeSame() {
    Email emailOne = new Email("test@test.com", true, "token");
    Email emailTwo = new Email("test@test.com", true, "token");

    assertEquals(emailOne.hashCode(), emailTwo.hashCode());
  }

  @Test
  void testHashCodeDifferent() {
    Email emailOne = new Email("test@test.com", true, "token");
    Email emailTwo = new Email("differentTest@test.com", true, "token");

    assertNotEquals(emailOne.hashCode(), emailTwo.hashCode());
  }

  @Test
  void testToString() {
    String expected = new StringJoiner(", ", "Email [", "]")
        .add(String.format("address=%s", "test@test.com"))
        .add(String.format("verified=%b", "true"))
        .add(String.format("verificationToken=%s", "token"))
        .toString();

    assertEquals(expected, email.toString());
  }
}
