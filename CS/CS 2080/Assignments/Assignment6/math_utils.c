#include "math_utils.h"
#include <stdio.h>

// Function to add two numbers
int add(int a, int b) {
	
	return a + b;
}

// Function to subtract two numbers
int subtract(int a, int b) {
	
	return a - b;
}

// Function to multiply two numbers
int multiply(int a, int b) {
	
	return a * b;
}

// Function to divide two numbers (checks for division by zero)
int divide(int a, int b) {
	
	if (b == 0) {
	printf("Error: Division by zero!\n");

	return 0; // Return 0 for division by zero
	}

	return a / b;
}
