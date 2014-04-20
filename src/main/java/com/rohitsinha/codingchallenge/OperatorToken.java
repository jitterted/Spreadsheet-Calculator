package main.java.com.rohitsinha.codingchallenge;

/**
 * Class to represent Operators as Tokens
 *
 * @author Rohit Sinha
 */
public class OperatorToken extends Token {

	public OperatorToken(Operators operator) {
		setToken(operator.getOperator());
	}

	public Operators getParsedValue() {
		return Operators.get(getToken());
	}

}
