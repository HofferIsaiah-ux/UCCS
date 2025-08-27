#! /bin/bash
#ScriptD1.sh

for string in hello apple happy Thursday; do

	case $string in 
		hello )	echo "Hello";;
		apple )	echo "apple";;
		* ) 	echo "don't know";; 
	esac

done 

exit 
