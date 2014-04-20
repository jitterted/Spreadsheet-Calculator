Spreadsheet Calculator
==================

A simple textual spreadsheet calculator based on java.
Developed for a coding challenge.

## Supported Functionalities
1. Supports operations on negative and positive Integers and cell based references.
2. Detects and reports circular dependencies between cells
3. Supported Operations as of now:
	1. Additon `+`
	2. Subtraction `-`
	3. Multiplication `*`
	4. Division `/`
	5. Increment `++`
	6. Decrement `--`

## File Description
| Filename        | Description          |
| ------------- |-------------|
| Token.java      | Abstract token class |
| OperatorToken.java  | Concrete class derived from `Token.java ` to represent operators as Tokens | 
| ReferenceToken.java | Concrete class derived from `Token.java ` to represent Cell References as Tokens|
| ValueToken.java | Concrete class derived from `Token.java ` to represent Values (operands) as Tokens|
| TokenFactory.java | Factory to get appropriate type of Token from the above list of tokens |
|Cell.java| Class which represents the cells in a spreadsheet's workbook|
|Operators.java| Class to represent all the supported operators and their operations.|
|CircularDependencyException.java| Custom Exception class for Circular Dependency|
|WorkBook.java|Composition over `Cells` to provides a matrix of  cells and support their evaluation|
|Spreadsheet.java| The main spreadsheet calculation class|
|Utils.java| Class containing some utility functions|
|PrettyPrinter.java| Class for priting a matrix in a pretty format. Source code taken from [here](http://stackoverflow.com/a/11384393/2228512)|
|SpreadsheetTest.java| A raw Test class just to bundle up running tests against different input files|

## Testing
The program has been tested on following operating systems:

1. Mac OSX 10.9.2


##Version
1.0 beta

##Contact Information
Please report any bugs or issues to:
[talktorohit54@gmail.com](mailto:talktorohit54@gmail.com)

##License
[MIT License](https://github.com/rohitsinha54/Spreadsheet-Calculator/blob/master/LICENSE)



