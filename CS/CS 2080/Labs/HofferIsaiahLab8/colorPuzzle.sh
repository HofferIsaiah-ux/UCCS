#! /bin/bash 
#
declare -a colors
colors[10]=blue
colors[15]=yellow
colors[99]=teal
colors[22]=green
slots=("${!colors[@]}")
echo ${slots[@]} 
num_indices=${#slots[@]}
echo $num_indices 
for (( i = num_indices; i >= 0; i-- )); do
echo ${colors[ ${slots[ $i ]} ]}
done



