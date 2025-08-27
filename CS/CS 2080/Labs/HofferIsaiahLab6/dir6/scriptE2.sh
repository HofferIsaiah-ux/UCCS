#! /bin/bash 
#ScriptE1.sh


count=0
> count_result.txt

while (( count < 4 )); do
	echo $count >> count_result.txt
	(( count++ ))	
done 

cat count_result.txt

exit 

