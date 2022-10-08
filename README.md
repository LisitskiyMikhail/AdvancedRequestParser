# RequestParser
The program starts with one of the parameter sets and processes these parameters.
The program starts with one of the following parameter sets:
-c name sex bd
-r id
-u id name sex bd
-d id
Parameter values:
name - name, String
sex - gender, "m" or "f", one letter
bd - date of birth in the following format 15/04/1990
-c - adds a person with the given parameters to the end of allPeople, displays id (index) on the screen
-r - displays information about a person with id: name sex (m/f) bd (format 15-Apr-1990)
-u - updates the data of the person with the given id
-d - performs a logical removal of a person with id, replaces all his data with null
