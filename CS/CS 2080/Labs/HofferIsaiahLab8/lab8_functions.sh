#! /bin/bash 
# lab8_functions.sh


#LAB-Q B1
#-----------------------------------------------------------------------
#Function to take any # of arguments, display arguments, # of arguments 
arg_counter() {
	echo "Number of Arguments: $#"
	 
	for i in $@
	do
		echo "Argument: $i" 
	done
} #arg_counter Function 

#Calling arg_counter Function 
arg_counter a1 b2 c3 b4 e5 f6 



#LAB-Q B2.1 
#------------------------------------------------------
#Calculates Average 
average() {
	#Variables 
	sum=0
	totalArgs=$#
	
	#Need At least one Integer Argument 
	if [ totalArgs == 0 ]; then 
		echo "Need Integer Argument!" 
		return 1	
	fi 

	#Finding Sum of Arguments 
	for i in $@; do 
		sum=$((sum + i))
	done 

	#Getting Average, 2 decimal places 
	average=$(echo "scale=2; $sum / $totalArgs" | bc) 

	#Printing Average 
	echo "Average: $average" 

	return $?	

} #average Function

#LAB-Q B2.2
#Calling average Function 
average_result=$(average 3 66 92 8 14 4) 
echo "Average $average_result" 



#LAB-Q B3.1
#------------------------------------------------------------
#
line_nums() { 
	line_nums=1
	while read line; do 
		echo "$line_nums: $line" 
		((line_nums++)) 
	done 
} #line_nums Filter Function 

#Calling Filter Function line_nums
echo -e "aa \n bb \n cc \n dd" | line_nums 

#LAB-Q B3.2 
#Count Amount Of Characters 
chars() {
	count=0
	while read line; do
		count=$((count + ${#line})) 	
	done

	echo "Characters: $count" 	
} # chars Filter Function 

#Calling Filter Function chars 
echo The quick brown fox quietly strummed the banjo | chars




#PART C
#LAB-Q C2
#--------------------------------------------
#Getting Libary Functions 
source ./lab8.library 

#Initalizing Variables 
var_a=24
var_b=1
var_c=19 

#LAB-Q C2.1 
#Calling Max Function 
echo "Max: $(max $var_a $var_b)" 

#Calling Min Function 
echo "Min: $(min $var_b $var_c)" 


