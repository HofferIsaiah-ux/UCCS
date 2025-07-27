# Compiler and flags
CC = gcc
CFLAGS = -Wall -g

# List of object files
OBJ = main.o math_utils.o
	
# The target program
TARGET = calculator

# Rule to build the target program
$(TARGET): $(OBJ)
	# now only use the variables defined above and automatic variables ($@ and $^)
	$(CC) $(CFLAGS) -o $@ $^ 

# Rule to compile main.c
main.o: main.c math_utils.h
	# now only use the variables defined above and automatic variables ($< and $@)
	$(CC) $(CFLAGS) -c $<  

# Rule to compile math_utils.c
math_utils.o: math_utils.c math_utils.h
	# now only use the variables defined above and automatic variables ($< and $@)
	$(CC) $(CFLAGS) -c $< 
# Clean up the build files
clean:
	# use rm -f with the OBJ variable
	rm -f $(OBJ)  
# Install
Install:
	# use mkdir to create a directory called program (In the current directory)
	# move the TARGET into the program directory
	mkdir program 
	mv $(TARGET) $(pwd)/program
#clean executable
clean_exe:
	# rm -rf for the program directory
	rm -rf program 
