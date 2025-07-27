#!/bin/bash 

#if $1 is empty or $1 equals -h 
if [[ -z $1 ]] || [[ $1 == "-h" ]]; then
       #Display Guide For Script 	
	cat << HELP 		
This script calculates the product of four numbers. 
Enter four real numbers arguments, like this: 
product.sh 13 33 39 16
HELP

#Calculating And Displaying Product 
else	

	product=$(bc << EOF
	scale = 4  
	$1 * $2 * $3 * $4
EOF
)
echo "Product: $product" 

fi # Closing If Statement  
exit
