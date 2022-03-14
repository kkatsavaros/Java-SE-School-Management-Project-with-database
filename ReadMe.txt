Java-SE-School-Management-Project-with-database


1. This is a Java Standard Edition School Management Programm with Database.

It is a very good project for a Java student to get familiar with Java Object Oriented Programmming.


2. Σκεπτικό μου για την δημιουργία της βάσης δεδομένων:
Ενα Course έχει πολλούς Students και ένας Student μπορεί να παρακολουθήσει πολλά Courses, άρα έχουν σχέση πολλά προς πολλά, οπότε έφτιαξα τον πίνακα zfk_courses_students.

Ενα Course έχει πολλούς Trainers και ένας Trainer μπορεί να διδάξει σε πολλά Courses, άρα έχουν σχέση πολλά προς πολλά, οπότε έφτιαξα τον πίνακα zfk_courses_trainers.

Ενα Course έχει πολλά Assignments και ένα Assignment μπορεί να αποδοθεί σε πολλά courses, άρα έχουν σχέση πολλά προς πολλά, οπότε έφτιαξα τον πίνακα zfk_courses_assignments.



3. Η schema είναι στον φάκελο together, αλλά έχω φτιάξει και μία οπτική εικόνα της όλης βάσης δεδομένων με τα synthetic data του πρώτου project




4. Εβαλα αρκετά data στους 4 αρχικούς πίνακες και με το πρόγραμμα μπήκαν και στους τρεις πίνακες (πολλά προς πολλά).



5.SQL Queries:

a. SELECT * FROM Students;

b. SELECT * FROM trainers;

c. SELECT * FROM assignments; 

d. SELECT * FROM courses; 
-----------------------------------
e. All the students per Course:

SELECT students.SLastName, courses.CTitle
from students, courses
where students.SCourseTitle=courses.CTitle;




f. All the trainers per Course:

SELECT trainers.TLastName, courses.CTitle
from trainers, courses
where trainers.TCourseTitle=courses.CTitle;




g. All the Assignments per Course:

SELECT assignments.ATitle, courses.CTitle
from assignments, courses
where assignments.ACourseTitle=courses.CTitle;


----------------------------------------
h. Assignments per Course per Student:

SELECT students.SLastName, courses.CTitle, assignments.ATitle, assignments.ADescription
FROM students, courses, assignments
WHERE students.SCourseTitle=courses.CTitle
and assignments.ACourseTitle=courses.CTitle;




g. A list of students that belong to more than one courses.

SELECT students.SLastName,students.SFirstName, COUNT(*) 
FROM students
group by students.SLastName
HAVING COUNT(*)>1



6. 
α. Εχω κάνει σύνδεση με την βάση δεδομένων και απάντησα στα queries χρησιμοποιώντας μοντέλα DAO και DTO.


β. Εχω κάνει σύνδεση με την βάση δεδομένων και από το πρόγραμμα μπορεί κάποιος να εισάγει δεδομένα στους 4 βασικούς πίνακες courses,students,trainers και assignments, και μετά με διάφορες μεθόδους γίνεται αυτόματα εισαγωγή και στους 3 πίνακες (πολλά προς πολλά) που έχω προαναφέρει για την δημιουργία συσχετίσεων.



Κατσάβαρος Κωνσταντίνος


