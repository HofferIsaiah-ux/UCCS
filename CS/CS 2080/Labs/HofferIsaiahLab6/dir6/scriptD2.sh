#! /bin/bash 
#ScriptD2.sh


for string in 1abcXYZ "34" "243" A24 2aaaPQR; do

	case $string in 
		[a-zA-Z]* ) echo "Starts with a letter" ;;
		[0-9][0-9]* ) echo "Starts with 2 numbers" ;;
		*XYZ | *PQR ) echo "Ends with XYZ or PQR" ;;
		*[aA]* ) echo "Contains an a" ;;
		* ) echo "Found something else" ;;	
	esac
done

exit 
