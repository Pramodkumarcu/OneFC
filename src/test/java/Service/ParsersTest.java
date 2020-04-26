package Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParsersTest {

  @Test
  void validateFilePath() {
    Parsers parser = new Parsers();
    assertTrue(parser.validateFilePath("/com/onefc/resources/test/test.csv"),
        "test case failed for Test Case 1");
    assertTrue(parser.validateFilePath("/com/onefc/resources/data.csv"),
        "test case failed for Test Case 2");
  }

  @Test
  void parseFile() {
  }
}