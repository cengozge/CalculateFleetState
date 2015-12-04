# CalculateFleetState
Read input file and count filled, empty and mostly filled states of hosts. 

----------------------------------------
Sample Input File:

10,M1,6,0,0,0,0
16,M1,4,0,1,1,1
18,M1,4,0,0,0,0
19,M1,4,1,1,1,1
20,M1,4,0,0,0,1
21,M1,4,0,1,1,1
22,M1,4,0,1,0,1
23,M1,4,1,1,0,1
77,M2,7,1,1,1,1,1,1,1
78,M2,7,1,1,0,1,0,1,1
79,M2,7,1,1,1,1,0,1,1
80,M2,5,1,1,1,1,0
81,M2,7,1,0,1,1,1,1,1
82,M6,7,1,0,0,0,0,0,1
83,M1,4,1,1,0,1
84,M2,7,0,0,1,1,1,1,1
87,M3,12,1,1,1,1,0,0,0,1,1,1,1,1
89,M3,13,1,0,1,1,1,1,1,0,0,1,1,1,1,1
91,M3,14,1,0,0,0,0,0,1,0,0,1,1,1,1,1
92,M1,4,1,1,0,1
93,M3,14,0,0,1,1,1,1,1,0,0,1,1,1,1,1
94,M4,14,0,0,1,1,1,1,1,0,0,1,1,1,1,1
-----------------------------------------

Sample Output of this file:

EMPTY: M1=18;M2=7;M3=17
FULL: M1=22;M2=33;M3=37
MOST FILLED: M1=4,0;M2=7,0;M3=12,3

My assumptions:
1- While reading the input file, instance type will be
 controlled and if it is valid, a line will assign to
 an object and added to a list. If it is not valid,
 it will be written into a log file with its instance
 type.
2- There are 3 files; input file, output file and log
file. These files are given in config.properties file
for their location. You can change the directories
from project directory->resources->config.properties 
file.
