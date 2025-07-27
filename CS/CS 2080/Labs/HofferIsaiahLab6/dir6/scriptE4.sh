#! /bin/bash 
#ScriptE4.sh

while read line; do
	echo $line
	if [[ $line == *99* ]]; then 
		echo "leaving" 
		break 	
	fi
done < data.txt 

exit 

