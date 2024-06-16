 **_NOTE:_**  This project is best run on Eclipse. There is also no main method since the main goal of this project is to practice unit testing and write clean code. 

## What is RPN Calculator?
RPN Calculator follow the **Reverse Polish Notation** in which the operator symbol is placed after the arguments being operated on. For example, regular algebraic expression (4 + 2 * 5) / (1 + 3 * 2)  would look like 4 2 5 * + 1 3 2 * + /  in reverse Polish expression. 


## How does RPN Calculator work?
An RPN calculator is stack-based. Numbers are pushed onto the stack and operations then operate on the numbers that are in the stack and may pop one or more numbers to use in their calculation.

Using the example in above section, we calculate by following the pattern of user input in a stack-base structure.

![Example 1](https://i.imgur.com/q2RNDmM.png)

Learn more [here](https://leachlegacy.ece.gatech.edu/revpol/)

## Project UML
![UML](https://github.com/USM-COS470-S21/rpn-calculator-aidan-ho-solo/blob/main/Model.png)
<details>
<summary>Version 1.0 Goals</summary>

## Version 1.0 Goals
1. Operations
   - [x] Addition
   - [x] Subtraction
   - [x] Multiplication
   - [x] Division
   - [x] Modulus
   - [x] void clear()
   - [x] int size()
   - [x] string flag()

2. Engine functions
   - [x] void push(String)
   - [x] string pop()
   - [x] string peek(int)
   - [x] void execute(string)
</details>

<details>
<summary>Version 2.0 Goals</summary>
	
## Version 2.0 Goals
   - [x] Bitwise: &, |, ^, ~, <<, >>	( ~ turn number into negative and cause overflow)
   - [x] Relational: ==, !=, >, <, >=, <=	
   - [x] Logical: &&, ||, !	(Any number that is not 0 is false)		
	
   - [x] (d)uplicate: duplicates the top item on the stack
   - [x]	(r)everse: swap top two stack values peek(0) and peek(1)
	   	// Raise stack underflow if not enough items for both
</details>

<details>
<summary>Version 3.0 Goals</summary>

## Version 3.0 Goals
1. Signed and Unsigned mode using **#** (Hash Sign)
   - [x] setSignRange() // set sign range base on Word-size and mode(signed/unsigned)
   - [x] SwitchSignMode.java // switch from the current mode... 
        
         - flip current Signed to Unsigned or Unsigned to Signed
         - update new the Word-size range by calling setSignRange();
         - convert all number on stack into the new sign

</details>

## Version 4.0 Goals
- [x] Add variables and a way to store/retrieve them in calculations
	
	Ex:
		
		push(“10”)
		execute(“=myvar”)	// pop’s element and assigns to `myvar`
		push(“5”)
		push(“myvar”)
		execute(“+”)
		result = pop()  // result == 15

		
#### Version 4.0 Methods
	RpnVariable.java
	- setter and getter for variable
	- performOperator()
	- addNewVariable()
	- addVariableOperatorAndPerform()
	- isVariable()
	- stripVariableInput()
	- edited enter() and execute()

	OperatorFactory.java
	-addVariableOperation()


#### Version 4.0 New classes
	- RpnVariable.java
	- RpnVariableMap.java
	- StoreVariable.java (as an operator class)
