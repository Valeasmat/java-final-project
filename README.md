# University project
## Project UML Structure
## Description

This program has 6 functionalities available
1. Print all teachers and their data:
This option shows the data of the active teachers in the university
Result Example:
```
╔═══════╤═════════════════╤═════╤═════════╤══════════╗
║ ID    │ NAME            │ AGE │ SALARY  │ TYPE     ║
╠═══════╪═════════════════╪═════╪═════════╪══════════╣
║ 1VA43 │ VALERIA ASMAT   │ 30  │ 25850.0 │ FullTime ║
╟───────┼─────────────────┼─────┼─────────┼──────────╢
║ 4RI49 │ RICARDO CHANG   │ 36  │ 10000.0 │ PartTime ║
╟───────┼─────────────────┼─────┼─────────┼──────────╢
║ 3AN42 │ ANTONIO CUELLAR │ 27  │ 15000.0 │ PartTime ║
╟───────┼─────────────────┼─────┼─────────┼──────────╢
║ 2RA44 │ RAMIRO ALEGRE   │ 31  │ 14190.0 │ FullTime ║
╚═══════╧═════════════════╧═════╧═════════╧══════════╝
```
2. Print Course Data
This option shows the data of the course selected by inserting the id, if it's a non-existent id, it will show no data
Result Example:
```

╔════╤════════════╗
║ ID │ NAME       ║
╠════╪════════════╣
║ 1  │ CALCULUS   ║
╟────┼────────────╢
║ 2  │ PHYSICS    ║
╟────┼────────────╢
║ 3  │ LITERATURE ║
╚════╧════════════╝

--------------------------------------------------
Insert the id of the course selected:2
--------------------------------------------------
COURSE: PHYSICS
CLASSROOM: 300B
TEACHER:
╔═══════╤═══════════════╗
║ ID    │ NAME          ║
╠═══════╪═══════════════╣
║ 2RA44 │ RAMIRO ALEGRE ║
╚═══════╧═══════════════╝

STUDENTS ENROLLED:
╔═══════╤══════════════╗
║ ID    │ NAME         ║
╠═══════╪══════════════╣
║ 5MA31 │ MARIA RAMOS  ║
╟───────┼──────────────╢
║ 9JU33 │ JUAN QUISPE  ║
╟───────┼──────────────╢
║ 6AN33 │ ANGIE FLORES ║
╟───────┼──────────────╢
║ 8IR35 │ IRINA CHAVEZ ║
╚═══════╧══════════════╝
```
3. Create and assign student
This option enables the student creation given a valid name and age. If a courseId valid is inserted, the student will be enrolled, otherwise he will only be enrolled at the university, but in any course.
Result example:
```
Insert student's full name,at least 3 characters
Insert name:
Lina Reyes
Insert student's age: 
23
Select course to enroll:
--------------------------------------------------
╔════╤════════════╗
║ ID │ NAME       ║
╠════╪════════════╣
║ 1  │ CALCULUS   ║
╟────┼────────────╢
║ 2  │ PHYSICS    ║
╟────┼────────────╢
║ 3  │ LITERATURE ║
╚════╧════════════╝

--------------------------------------------------
Insert the id of the course selected:1
Student created id: 11LI33,now enrolled in the university
Student enrolled successfully 
╔════════╤════════════╤═════╗
║ ID     │ NAME       │ AGE ║
╠════════╪════════════╪═════╣
║ 11LI33 │ LINA REYES │ 23  ║
╚════════╧════════════╧═════╝
```

4. Create course
This option enables the course creation given a valid course name and classroom. If a teacherId valid is inserted and a list of studentsId are inserted, they will be assigned to the course in creation. Otherwise, the course will be created but it won't have teacher or students assigned.
Result example:
```
Insert name:
Python
Insert course classroom (at least 3 characters):
300A
Select teacher to assign:
--------------------------------------------------
╔═══════╤═════════════════╗
║ ID    │ NAME            ║
╠═══════╪═════════════════╣
║ 1VA43 │ VALERIA ASMAT   ║
╟───────┼─────────────────╢
║ 4RI49 │ RICARDO CHANG   ║
╟───────┼─────────────────╢
║ 3AN42 │ ANTONIO CUELLAR ║
╟───────┼─────────────────╢
║ 2RA44 │ RAMIRO ALEGRE   ║
╚═══════╧═════════════════╝

--------------------------------------------------
Insert id selected: 1va43
Proceed to insert the ids of the students to enroll:
How many students are going to be enrolled?
2
Select from the list id nro.1
--------------------------------------------------
╔════════╤═══════════════════╗
║ ID     │ NAME              ║
╠════════╪═══════════════════╣
║ 5MA31  │ MARIA RAMOS       ║
╟────────┼───────────────────╢
║ 11LI33 │ LINA REYES        ║
╟────────┼───────────────────╢
║ 7CA37  │ CAMILO BUENDIA    ║
╟────────┼───────────────────╢
║ 9JU33  │ JUAN QUISPE       ║
╟────────┼───────────────────╢
║ 6AN33  │ ANGIE FLORES      ║
╟────────┼───────────────────╢
║ 8IR35  │ IRINA CHAVEZ      ║
╟────────┼───────────────────╢
║ 10LO41 │ LORENZO DELACOURT ║
╚════════╧═══════════════════╝

--------------------------------------------------
Insert id selected: 8ir35
Select from the list id nro.2
--------------------------------------------------
╔════════╤═══════════════════╗
║ ID     │ NAME              ║
╠════════╪═══════════════════╣
║ 5MA31  │ MARIA RAMOS       ║
╟────────┼───────────────────╢
║ 11LI33 │ LINA REYES        ║
╟────────┼───────────────────╢
║ 7CA37  │ CAMILO BUENDIA    ║
╟────────┼───────────────────╢
║ 9JU33  │ JUAN QUISPE       ║
╟────────┼───────────────────╢
║ 6AN33  │ ANGIE FLORES      ║
╟────────┼───────────────────╢
║ 8IR35  │ IRINA CHAVEZ      ║
╟────────┼───────────────────╢
║ 10LO41 │ LORENZO DELACOURT ║
╚════════╧═══════════════════╝

--------------------------------------------------
Insert id selected: 6an33
--------------------------------------------------
Course created successfully
COURSE: PYTHON
CLASSROOM: 300A
TEACHER:
╔═══════╤═══════════════╗
║ ID    │ NAME          ║
╠═══════╪═══════════════╣
║ 1VA43 │ VALERIA ASMAT ║
╚═══════╧═══════════════╝

STUDENTS ENROLLED:
╔═══════╤══════════════╗
║ ID    │ NAME         ║
╠═══════╪══════════════╣
║ 6AN33 │ ANGIE FLORES ║
╟───────┼──────────────╢
║ 8IR35 │ IRINA CHAVEZ ║
╚═══════╧══════════════╝
```
5. List courses in which a student is enrolled
This option shows a list of courses in which a given student is enrolled. If id is not valid, it will show a message explaining the result.
Result example:
```
Select id student to start search:
--------------------------------------------------
╔════════╤═══════════════════╗
║ ID     │ NAME              ║
╠════════╪═══════════════════╣
║ 5MA31  │ MARIA RAMOS       ║
╟────────┼───────────────────╢
║ 11LI33 │ LINA REYES        ║
╟────────┼───────────────────╢
║ 7CA37  │ CAMILO BUENDIA    ║
╟────────┼───────────────────╢
║ 9JU33  │ JUAN QUISPE       ║
╟────────┼───────────────────╢
║ 6AN33  │ ANGIE FLORES      ║
╟────────┼───────────────────╢
║ 8IR35  │ IRINA CHAVEZ      ║
╟────────┼───────────────────╢
║ 10LO41 │ LORENZO DELACOURT ║
╚════════╧═══════════════════╝

--------------------------------------------------
Insert id selected: 8ir35
--------------------------------------------------
Student 8IR35 is enrolled in: 
╔════╤══════════╗
║ ID │ NAME     ║
╠════╪══════════╣
║ 1  │ CALCULUS ║
╟────┼──────────╢
║ 2  │ PHYSICS  ║
╟────┼──────────╢
║ 4  │ PYTHON   ║
╚════╧══════════╝
```
6. Quit
Exits the application
