package com.rohitsinha.codingchallenge;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Class just to bundle up testing against different files.
 */
@RunWith(Parameterized.class)
public class SpreadsheetTest {

  private static final int STATUS_CODE_FAILURE = 1;
  private final String filepath;
  private final String expectedResult;
  private Spreadsheet appTest;

  public SpreadsheetTest(String filepath,
                         String expectedResult) {
    this.filepath = filepath;
    this.expectedResult = expectedResult;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> configs() {
    return Arrays.asList(new Object[][]{
        {"input1.txt", "20.00000\n" +
            "20.00000\n" +
            "20.00000\n" +
            "8.66667\n" +
            "3.00000\n" +
            "1.50000"},
        {"input2.txt", "Not Evaluated (Circular Dependency)\n" +
            "Not Evaluated (Circular Dependency)\n" +
            "Not Evaluated\n" +
            "Not Evaluated (Circular Dependency)\n" +
            "3.00000\n" +
            "Not Evaluated"},
        {"input3.txt", "6.00000\n" +
            "Not Evaluated (Circular Dependency)\n" +
            "3.00000\n" +
            "12.00000\n" +
            "6.00000\n" +
            "9.00000\n" +
            "15.00000\n" +
            "10.00000\n" +
            "4.00000"},
        {"input4.txt", "6.00000\n" +
            "-11.00000\n" +
            "3.00000\n" +
            "12.00000\n" +
            "6.00000\n" +
            "9.00000\n" +
            "15.00000\n" +
            "10.00000\n" +
            "4.00000"},
        {"input5.txt", "-6.00000\n" +
            "1.00000\n" +
            "3.00000\n" +
            "0.00000\n" +
            "6.00000\n" +
            "9.00000\n" +
            "3.00000\n" +
            "10.00000\n" +
            "4.00000"}
    });
  }

  @Before
  public void initialize() {
    appTest = new Spreadsheet();
  }

  @Test
  public void testApp() {
    try {
      appTest.setInputScanner(new Scanner(new File(filepath)));
    } catch (FileNotFoundException e) {
      System.err.println("Caught FileNotFoundException: Unable to find the specified input test file: " +
                             filepath);
      System.exit(STATUS_CODE_FAILURE);
    }
    appTest.processWorkbook();
    appTest.evaluate();
    assertEquals(expectedResult, appTest.getResults());
  }
}
