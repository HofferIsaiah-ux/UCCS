#! /bin/bash

if [[ -z $1 ]]; then
       #If String Is Empty 	
	echo "This string is empty" 
else 	
	#If String Is Not Empty 
	echo "This string has contents"
       if [[ $1 == "goodbye" ]]; then 
       		#If String Says Goodbye 
		echo "String is goodbye" 
 	else 
		#String Says Anything Else 
		echo "String is not goodbye" 
	fi #End Nested If Statement 		
fi #End If Statement 

exit
