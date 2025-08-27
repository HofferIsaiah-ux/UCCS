#! /bin/bash 
# ScriptA.sh 

#Section A1
# Default Option Parameters 
option_a="default_a"
option_b="default_b"
option_c="not_present"

echo "Number of Arguments: $#" 

#Displaying Arugments 
echo "Arguments: $@"

#Section A2

#Stop Error Message 
optstring=":a:b:c"

#Giving Values to Option Variables 
while getopts $optstring optname 
do 
	case $optname in 
		a) # Set option_a to $OPTARG 
			option_a="$OPTARG"
			;;
		b) # Set option_b to $OPTARG 
			option_b="$OPTARG"
			;;
		c) # Set option_c to present if it is found 
			option_c="present"
			;;
		\?) # Print Error if \? error is found 
			echo "Error" 
			;;
	esac 
done 

#Printing Options 
echo "option_a: $option_a"
echo "option_b: $option_b"
echo "option_c: $option_c"

echo "" 
#Section A4
#Shifting 1 
shift $((OPTIND - 1)) 

#Remaining Arguments 
echo "Arguments Now: $#" 

#Section A5
#Print Arguments Again
echo "Arguments: " 
for i in $@
do 
	echo $i
done 

echo "" 
#Section A6
#Print And Removing Remaining Arguments
echo "Arguments: " 
while (( $# != 0 ))  
do 
	echo $1
	shift 
done 

exit 
