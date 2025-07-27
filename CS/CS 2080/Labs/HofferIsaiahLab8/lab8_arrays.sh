#! /bin/bash 
# lab8_arrays.sh

#LAB-Q A1
#-------------------------------------------------
#Creating an Array
declare -a array_1 

#Filling Array {10..15} 
for ((i = 0; i <= 5; i++))  
do
	array_1[$i]=$((10 + i)) 
done 

#LAB-Q A1.1
#Printing Length Of Array 
echo ${#array_1[*]} 


#LAB-Q A1.2
#Printing Array Values
echo "Values In Array_1: "  
for i in ${array_1[@]}
do
	echo $i
done  



#LAB-Q A2
#--------------------------------------------------
#Creating New Array
array_2=("bash" "is the" "coolest" "scripting language") 

#LAB-Q A2.1
#Printing Array 
echo "Original Array: ${array_2[*]}" 

#LAB-Q A2.2
#Adding String 
array_2+=( "I don't think so!") 

#Displaying New Array
echo "New Array: ${array_2[*]}"



#LAB-Q A3
#--------------------------------------------------
#Creating Another Array 
fruit[0]=orange fruit[1]=tomato fruit[7]=apple fruit[200]=cherry

#LAB-Q A3.1 
#Printing Fruit Array Size 
echo "Fruit Array Length: ${#fruit[*]}"

#LAB-Q A3.2
#Printing Array Content 
for i in ${!fruit[@]}
do
	echo "fruit[$i] ${fruit[$i]}"
done 

#LAB-Q A3.3 
#Adding String 
fruit+=("plum") 

for i in ${!fruit[@]} 
do 
	if [[ ${fruit[$i]} == "plum" ]] 
	then  
		echo "The plum index is found at index $i" 
	fi

done 



#LAB-Q A4 
#---------------------------------------------------
#Another Array 
string1="aa,bb,cc,dd"
#Putting string1 into new array, string_array 
IFS=, read -a string_array <<< $string1

#Displaing Array 
echo "String_Array Says: " 
for i in ${string_array[@]}
do
       	echo $i
done 

#Words in Array
num_items=${#string_array[@]}

#Displaying Results
echo "There are $num_items items in string_array" 



#LAB-Q A5 
#--------------------------------------------------
#New Array 
IFS=: path_array=($PATH) 

#LAB-Q A5.1 
#Printing Array
echo "Path_Array Gives: "
for i in ${path_array[@]} 
do
	echo $i
done

#LAB-Q A5.2
#Number of Directories 
echo "Number of directories in path_array: ${#path_array[@]}"



#LAB-Q A6 
#---------------------------------------------------
#Another Array 
dir=$(pwd) 
file_name_array=($dir/testDir/*.txt $dir/testDir/*.doc) 

#LAB-Q A6.1 
#Pring Length And Contents 
echo "File_Name_Array Contans: ${file_name_array[@]} 
Length Of File is ${#file_name_array[@]}"













