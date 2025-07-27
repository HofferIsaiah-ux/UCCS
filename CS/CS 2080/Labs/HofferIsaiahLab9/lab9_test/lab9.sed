#! /bin/bash
# lab9.sed



sed '{  
s/dog/cat/g
7s/mouse/MOOSE/g
14,20s/mouse/MOOSE/g
9s/orange/APPLES/g
/Hello/s/flea/LEAF/g 
/The/,/problem/s/mountain/MOONTUNE/g
/change/c\I am different now 
#1i\----------------------------------------------------
#$ a\======================================================
#1,15{s/x/!/g; s/y/#/g} 
#16,$s/[xy]/*/g
#s/\<flea flea\>/flea/g
#s/\<LEAF LEAF\>/LEAF/g 
#s/\<mountain mountain\>/mountain/g 
#s/\<orange orange\>/orange/g
#s/\<MOONTUNE MOONTUNE\>/MOONTUNE/g
#/delete/d
#/orange mouse flea cat mountain/d
#/orange/d; /mouse/d; /flea/d; /cat/d; /mountain/d   
}' test2.txt



