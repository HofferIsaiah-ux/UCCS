#include <stdio.h>
#include "math_utils.h"

int main() {
	int a, b, result;
	char operator;

	// Get user input for two numbers and operator
	printf("Enter first number: ");
	scanf("%d", &a);
	printf("Enter operator (+, -, *, /): ");
	scanf(" %c", &operator); // Note the space before %c to consume the newline
	printf("Enter second number: ");
	scanf("%d", &b);

	// Perform the operation based on the user input
	switch (operator) {
		case '+':
			result = add(a, b);
		break;
		case '-':
			result = subtract(a, b);
		break;
		case '*':
			result = multiply(a, b);
		break;
		case '/':
			result = divide(a, b);
		break;
		default:
			printf("Error: Invalid operator\n");
		return 1;
	}	
	
	printf("Result: %d\n", result);

	return 0;
}
