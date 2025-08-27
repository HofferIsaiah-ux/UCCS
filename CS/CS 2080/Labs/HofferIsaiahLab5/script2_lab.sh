#! /bin/bash 

# Variables 
sum=$(($1+$2+$3)) # sum of arguments 
average=$(($sum/$#)) # Integer average 
average2=$(echo "scale = 4; $sum/$#" | bc) # Decimal average 

# Displaying Results 
echo "The numbers are: $1   $2   $3" 
echo "Their sum is: $sum" 
echo "Their integer average is: $average"
echo "Their acual average is: $average2" 

exit 
