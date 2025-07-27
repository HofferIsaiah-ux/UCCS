#! /bin/bash 
# ScriptB.sh 

# Section B1
filename_var="" 

#Using getopts to read -f option 
while getopts ":f:" opt 
do 
	case "$opt" in
		f) 
			filename_var=$OPTARG
			;;
		\?)
			echo "Error"
			;;
	esac
done 

#If -f was not found, prompt user for name 
if [ -z $filename_var ] 
then 
	read -p "Enter file name: " filename_var 
fi 

#Printing File Name 
echo "File Name: $filename_var" 

#Section B2
#Checking if file is regular, exists, and has content 
if [ -f $filename_var ] && [ -s $filename_var ] 
then 
	echo "Valid File Name" 
	IFS=, 

	#Read each line of field by field 
	while read name sport score team 
	do 
		echo "Name: $name" 
		echo "Sport: $sport" 
		echo "Score: $score" 
		echo "Team: $team" 
		echo "" 
	done < $filename_var 
else 
	echo "Error: $filename_var not a valid file" 
	exit 1 
fi 

#Section B3
exit $? 
