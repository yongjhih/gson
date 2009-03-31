package com.google.gson;

import junit.framework.TestCase;

import java.io.StringReader;

/**
 * Unit test for {@link JsonParser}
 * 
 * @author Inderjeet Singh
 */
public class JsonParserTest extends TestCase {
  
  private JsonParser parser;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    parser = new JsonParser();
  }
  
  public void testParseString() {
    String json = "{a:10,b:'c'}";
    JsonElement e = parser.parse(json);
    assertTrue(e.isJsonObject());
    assertEquals(10, e.getAsJsonObject().get("a").getAsInt());
    assertEquals("c", e.getAsJsonObject().get("b").getAsString());
  }

  public void testParseReader() {
    StringReader reader = new StringReader("{a:10,b:'c'}");
    JsonElement e = parser.parse(reader);
    assertTrue(e.isJsonObject());
    assertEquals(10, e.getAsJsonObject().get("a").getAsInt());
    assertEquals("c", e.getAsJsonObject().get("b").getAsString());
  }
}
