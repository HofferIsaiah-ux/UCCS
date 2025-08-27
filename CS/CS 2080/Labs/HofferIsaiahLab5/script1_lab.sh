#! /bin/bash
 

echo "Hello ${1:-anoynmous} your number is ${2:-9999}" 

echo "Magic word version 1: ${3#a*b}" # Shortest match front 
echo "Magic word version 2: ${3%r*a}" # Shortest match back 
echo "Magic word version 3: ${3##a*b}" # Longest match front 
echo "Magic word version 4: ${3%%r*a}" # Longest match back 

exit  

