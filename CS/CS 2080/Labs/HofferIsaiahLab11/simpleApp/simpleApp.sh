#! /bin/bash 

# Output File 
outFile=$1 


#Startup Message 
echo "Hello from the simple app" | tee -a $outFile

# Variables
number=42 

# Sleep for 30s and +1 to number FOREVER 
while (true); do 

	sleep 30 

	echo $number | tee -a $outFile 

	((number++))

done 


exit 
