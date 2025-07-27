#!/bin/bash

#Checking If File Exists 
if [[ ! -f $1 ]]; then 
	#If File Does Not Exist
	echo "This is not a file" 
elif [[ -z $(cat $1) ]]; then 
	#If File Is Empty 
	echo "This file is empty" 
else 
	#If File Exists And Is Not Empty 
	echo "This file, $1, has content: $(cat $1)"	
fi #End If Statement
 
exit 
