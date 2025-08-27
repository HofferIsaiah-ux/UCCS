&nbsp;		Notes for Final 



Problem 1: BASIC COMMANDS AND SED

&nbsp;	Basic Commands: ls, cd, rm, rm-r, mv, cp

&nbsp;	Sed Commands: 

&nbsp;		Basic Formats: sed options s/old-pattern/new-pattern/flags input.txt 

&nbsp;			       sed s/old-pattern/new-pattern/2 input.txt - replace nth (2 here) match

&nbsp;			       sed s/old-pattern/new-pattern/g input.txt - replace all matches in a line 

&nbsp;			       sed -n s/old-pattern/new-pattern/p - print only changed lines, need -n 

&nbsp;			       sed 's/old-pattern/new-pattern/w output.txt' input.txt - write output to file 

&nbsp;			       sed '3r changes.txt' input.txt - read line changes from file 

&nbsp;		 	       sed -f script.sed input.txt - read sed script from a file 

&nbsp;			       sed '2s/old/new/' input.txt - specific line (2) 

&nbsp;			       sed '2,5s/old/new/' input.txt - specific lines (2-5) 

&nbsp;			       sed '/string/s/old/new/ input.txt - replace pattern with specific string 

&nbsp;			       sed '/start-line/,/end-line/s/old/new/' input.txt - replace lines starting with start line string and ending with end-line string 

&nbsp;			       sed '#\\d' - delete line (2) 

&nbsp;			       sed 'i\\string' input.txt - *insert before* line, use another \\ for another line, can use # and string matching 

&nbsp;			       sed 'a\\string' - same a 'i\\' except *after* 

&nbsp;			       sed 'c\\string' - *replace* line with string, same formats as 'i\\'

&nbsp;			       sed 'y/old-char/new-char/' input.txt - replace characters on given lines 

&nbsp;		-n - stop automatic printing ('sed -n' ... input.txt)

&nbsp;		-e - allow multiple commands (sed -e ...; ... input.txt)

&nbsp;		Grouping Commands: sed 'addresses{

&nbsp;					command

&nbsp;					command 

&nbsp;				   }' input.txt 



Problem 2: OUTPUT OF SED COMMANDS 

&nbsp;	sed = stream editor 

&nbsp;	sed options 'script' input-files 

&nbsp;		- reads line by line 

&nbsp;		-outputs edited data to STDOUT



Problem 3: MAKEFILE

&nbsp;	Targets: 

&nbsp;		- File names, separated by spaces

&nbsp;		- Usually only one per rule

&nbsp;	Prerequisites:

&nbsp;		- File names, separated by spaces  

&nbsp;		- Must exist 

&nbsp;		- command is run if files are younger than target files

&nbsp;	Commands: 

&nbsp;		-Recipe used to make the target 

&nbsp;		-use @ to stop command from printing 

--------------------------------------------------------------------- 

&nbsp;	CC = gcc 

&nbsp;	CFLAGS = -Wall 

&nbsp;		-g: debugger info 

&nbsp;		-B: build everything, even if not out of date 

&nbsp;		

&nbsp;	OBJECTS = main.o ultis.o # List of Object files 

&nbsp;		

&nbsp;	# Default target (build the executable) 

&nbsp;	all: myprogram



&nbsp;	#Rule to link the object files into final executable 

&nbsp;	myprogram: $(OBJECTS)

&nbsp;		$(CC) $(FFLAGS) $(OBJECTS) -o myprogram 

&nbsp;	

&nbsp;	# Rule to compile main.c into main.o

&nbsp;	main.o: main.c

&nbsp;		$(CC) -c main.c 



&nbsp;	# Rule to compile utils.c into utils.o 

&nbsp;	utils.o: utils.c 

&nbsp;		$(CC) -c utils.c 



&nbsp;	# Clean rule to remove object files 

&nbsp;	clean: 

&nbsp;		rm -f $(OBJECTS) 

------------------------------------------------------------------

&nbsp;	.PHONY: TARGET1 TARGET2...



&nbsp;	$@: The Target Filename 

&nbsp;	$<: The First Prerequisite

&nbsp;	$^: The List of Prerequisites, excluding duplicate elements 

&nbsp;	$?: The List of Prerequisites that are newer than the target  

&nbsp;	

Question 4: UNDERSTAND MAKEFILE

&nbsp;	





Question 5: GAWK

&nbsp;	Basic Format: 

&nbsp;		gawk options 'script' input.txt 









Question 6: More Basic Commands 

&nbsp;	Commands: head, tail, grep, ps, top, kill, sort, etc 



Question 7: Chmod 

&nbsp;	

&nbsp;	Numeric: r(4) w(2) x(1) 

&nbsp;	Symbolic : User Owner (u), Group Owner (g), Others (o)

&nbsp;		   write (w), read (r), execute (x) 

&nbsp;			use + to add permissions 

&nbsp;			use - to remove permissions 

&nbsp;			use = to reset permissions 

&nbsp;			 

&nbsp;	

Question 8: Script writing and Reading Input From Console 











Question 9: Script Writing With Case Statements and File Globs for Loops 











Question 10: Script Writing using GETOPTS And OPTSTRING And Receiving OPTARG and Using OPTIND to Shift 









&nbsp;

&nbsp;	



