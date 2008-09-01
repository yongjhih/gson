/* Generated By:JavaCC: Do not edit this line. JsonParser.java */
package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@SuppressWarnings("all")
final class JsonParser implements JsonParserConstants {

  final public JsonElement parse() throws ParseException {
  JsonElement json = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
      json = JsonObject();
      break;
    case 20:
      json = JsonArray();
      break;
    case DIGITS:
    case QUOTE:
    case 22:
    case 23:
    case 24:
      json = JsonPrimitive();
      break;
    case 17:
      json = JsonNull();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  final private JsonObject JsonObject() throws ParseException {
  JsonObject o = new JsonObject();
    jj_consume_token(15);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOTE:
      Members(o);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(16);
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JsonNull JsonNull() throws ParseException {
  JsonNull json = new JsonNull();
    jj_consume_token(17);
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  final private void Members(JsonObject o) throws ParseException {
    Pair(o);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 18:
      jj_consume_token(18);
      Members(o);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  final private void Pair(JsonObject o) throws ParseException {
  JsonPrimitive property;
  JsonElement value;
    property = JsonString();
    jj_consume_token(19);
    value = JsonValue();
    o.add(property.getAsString(), value);
  }

  final private JsonArray JsonArray() throws ParseException {
  JsonArray array = new JsonArray();
    jj_consume_token(20);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITS:
    case QUOTE:
    case 15:
    case 17:
    case 20:
    case 22:
    case 23:
    case 24:
      Elements(array);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(21);
    array.reverse();
    {if (true) return array;}
    throw new Error("Missing return statement in function");
  }

  final private void Elements(JsonArray array) throws ParseException {
  JsonElement element;
    element = JsonValue();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 18:
      jj_consume_token(18);
      Elements(array);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    array.add(element);
  }

  final private JsonElement JsonValue() throws ParseException {
  JsonElement o = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOTE:
      o = JsonString();
      break;
    case DIGITS:
    case 24:
      o = JsonNumber();
      break;
    case 15:
      o = JsonObject();
      break;
    case 20:
      o = JsonArray();
      break;
    case 22:
      jj_consume_token(22);
             o = new JsonPrimitive(true);
      break;
    case 23:
      jj_consume_token(23);
              o = new JsonPrimitive(false);
      break;
    case 17:
      jj_consume_token(17);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonPrimitive() throws ParseException {
  JsonPrimitive value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOTE:
      value = JsonString();
                          {if (true) return value;}
      break;
    case DIGITS:
    case 24:
      value = JsonNumber();
                          {if (true) return value;}
      break;
    case 22:
      jj_consume_token(22);
             {if (true) return new JsonPrimitive(true);}
      break;
    case 23:
      jj_consume_token(23);
              {if (true) return new JsonPrimitive(false);}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonNumber() throws ParseException {
  String intpart = null,
         fracpart = null,
         exppart = null;
    intpart = JsonInt();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 25:
      fracpart = JsonFrac();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case E:
      exppart = JsonExp();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    Number n;
    if (exppart != null) {
      n = new BigDecimal(intpart + fracpart + exppart);
    } else if (fracpart != null) {
      n = new Double(intpart + fracpart);
    } else {
      // See if the number fits in an integer, or long
      // Use BigInteger only if it is big enough.
      if (intpart.length() < 10) {
        n = new Integer(intpart);
      } else if (intpart.length() < 19) {
        n = new Long(intpart);
      } else {
        n = new BigInteger(intpart);
      }
    }
    {if (true) return new JsonPrimitive(n);}
    throw new Error("Missing return statement in function");
  }

  final private String JsonInt() throws ParseException {
  String digits;
  boolean negative = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 24:
      jj_consume_token(24);
         negative = true;
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    digits = Digits();
    if(negative)
      {if (true) return "-" + digits;}
    {if (true) return digits;}
    throw new Error("Missing return statement in function");
  }

  final private String JsonFrac() throws ParseException {
  String digits;
    jj_consume_token(25);
    digits = Digits();
    {if (true) return "." + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String JsonExp() throws ParseException {
  Token t;
  String digits;
    t = jj_consume_token(E);
    digits = Digits();
    {if (true) return t.image + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String Digits() throws ParseException {
  Token t;
    t = jj_consume_token(DIGITS);
    {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonString() throws ParseException {
  StringBuffer strbuf = new StringBuffer();
    jj_consume_token(QUOTE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CHAR:
    case CNTRL_ESC:
    case HEX_ESC:
      Chars(strbuf);
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    jj_consume_token(ENDQUOTE);
    {if (true) return new JsonPrimitive(strbuf.toString());}
    throw new Error("Missing return statement in function");
  }

  final private void Chars(StringBuffer strbuf) throws ParseException {
  char c;
    c = Char();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CHAR:
    case CNTRL_ESC:
    case HEX_ESC:
      Chars(strbuf);
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    strbuf.insert(0, c);
  }

  final private char Char() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CHAR:
      t = jj_consume_token(CHAR);
      break;
    case CNTRL_ESC:
      t = jj_consume_token(CNTRL_ESC);
      break;
    case HEX_ESC:
      t = jj_consume_token(HEX_ESC);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    if(t.image.length() < 2) {
      {if (true) return t.image.charAt(0);}
    }
    if(t.image.length() < 6) {
      char c = t.image.charAt(1);
      switch(t.image.charAt(1)) {
        //control characters
        case 'b'  : {if (true) return (char) 8;} break;
        case 'f'  : {if (true) return (char) 12;} break;
        case 'n'  : {if (true) return (char) 10;} break;
        case 'r'  : {if (true) return (char) 13;} break;
        case 't'  : {if (true) return (char) 9;} break;
        default   : {if (true) return c;}   //characters that represent themselves
      }
    }
    else {      //hex escape code
      //create an integer from our hex values
      //and then cast into a char
      int i = Integer.valueOf(t.image.substring(2,6), 16).intValue();
      {if (true) return (char) i;}
    }
    throw new Error("Missing return statement in function");
  }

  public JsonParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x1d280c0,0x80,0x40000,0x1d280c0,0x40000,0x1d280c0,0x1c000c0,0x2000000,0x20,0x1000000,0x4c00,0x4c00,0x4c00,};
   }

  public JsonParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public JsonParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JsonParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public JsonParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JsonParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public JsonParser(JsonParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(JsonParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[26];
    for (int i = 0; i < 26; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 26; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}
