#! /bin/bash 

if [[ $1 == 0 ]]; then
       #If $1 ==0	
	echo "Number is 0"
elif [[ $1 < 2 ]]; then
       #If $1 < 2	
	echo "Number is less than 2"
else 
	#If $1 >= 2 
	echo "Number is 2 or more"
fi #Closing If Statement 

exit 
