package com.rohitsinha.codingchallenge;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Class to represent a cell in the spreadsheet
 *
 * @author Rohit Sinha
 */
public class Cell {

  private final Pattern splitRegex = Pattern.compile("\\s+");

  private final int row;
  private final int col;
  private final LinkedList<com.rohitsinha.codingchallenge.ReferenceToken> references;
  private final LinkedList<com.rohitsinha.codingchallenge.Token> tokenList;
  private final String contents;
  private int unresolvedRefs;
  private boolean evaluated;
  private double evaluatedValue;

  public Cell(int row, int col, String contents) throws RuntimeException {
    this.row = row;
    this.col = col;
    this.contents = contents;
    this.unresolvedRefs = 0;
    this.references = new LinkedList<com.rohitsinha.codingchallenge.ReferenceToken>();
    this.tokenList = new LinkedList<com.rohitsinha.codingchallenge.Token>();
    this.parse();
  }

  public String getContents() {
    return contents;
  }

  public int getUnresolvedRefs() {
    return unresolvedRefs;
  }

  public void setUnresolvedRefs(int unresolvedRefs) {
    this.unresolvedRefs = unresolvedRefs;
  }

  public double getEvaluatedValue() {
    return evaluatedValue;
  }

  public void setEvaluatedValue(double evaluatedValue) {
    this.evaluatedValue = evaluatedValue;
  }

  public boolean isEvaluated() {
    return evaluated;
  }

  public void setEvaluated(boolean evaluated) {
    this.evaluated = evaluated;
  }

  public LinkedList<com.rohitsinha.codingchallenge.Token> getTokenList() {
    return tokenList;
  }

  public LinkedList<com.rohitsinha.codingchallenge.ReferenceToken> getReferences() {
    return references;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Cell cell = (Cell) o;

    if (col != cell.col) return false;
    if (row != cell.row) return false;
    if (!contents.equals(cell.contents)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return (String.valueOf(row) + String.valueOf(col)).hashCode();
  }

  private void parse() throws RuntimeException {
    String[] strArray = splitRegex.split(contents);
    com.rohitsinha.codingchallenge.TokenFactory tokenFactory = new com.rohitsinha.codingchallenge.TokenFactory();
    for (String s : strArray) {
      com.rohitsinha.codingchallenge.Token tok = tokenFactory.makeToken(s);
      if (tok.getClass().equals(com.rohitsinha.codingchallenge.ReferenceToken.class)) {
        references.add(((com.rohitsinha.codingchallenge.ReferenceToken) tok));
        unresolvedRefs++;
      }
      tokenList.add(tok);
    }
  }
}
