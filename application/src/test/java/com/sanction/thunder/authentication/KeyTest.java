package com.sanction.thunder.authentication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KeyTest {

  @Test
  void testHashCodeSame() {
    Key keyOne = new Key("name", "secret");
    Key keyTwo = new Key("name", "secret");

    assertAll("Assert equal key properties",
        () -> assertEquals(keyOne.hashCode(), keyTwo.hashCode()),
        () -> assertEquals(keyOne.getName(), keyTwo.getName()),
        () -> assertEquals(keyOne.getSecret(), keyTwo.getSecret()));
  }

  @Test
  void testHashCodeDifferent() {
    Key keyOne = new Key("name", "secret");
    Key keyTwo = new Key("differentName", "differentSecret");

    assertAll("Assert unequal key properties",
        () -> assertNotEquals(keyOne.hashCode(), keyTwo.hashCode()),
        () -> assertNotEquals(keyOne.getName(), keyTwo.getName()),
        () -> assertNotEquals(keyOne.getSecret(), keyTwo.getSecret()));
  }

  @Test
  @SuppressWarnings({"SimplifiableJUnitAssertion", "EqualsWithItself"})
  void testEqualsWithSelf() {
    Key keyOne = new Key("name", "secret");

    assertTrue(() -> keyOne.equals(keyOne));
  }

  @Test
  @SuppressWarnings("SimplifiableJUnitAssertion")
  void testEqualsWithDifferentObjectType() {
    Key keyOne = new Key("name", "secret");
    Object objectTwo = new Object();

    assertFalse(() -> keyOne.equals(objectTwo));
  }

  @Test
  void testToString() {
    Key key = new Key("testKey", "testSecret");
    String expected = "Key [name=testKey, secret=testSecret]";

    assertEquals(expected, key.toString());
  }
}
