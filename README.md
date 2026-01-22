campusconnect is a backend project which implements a real university management system.
With entities like the User, StudentProfile, InstructorProfile, Course, Faculty, Department which all real world entities in a university system.

#User
-This is the main entity if the system which undergoes authentication and also gives rise to the Instructor and Student profile through the enumerations based on their role
-The student and instructor repository are solely dependent on the user repository , as in the student is also saved as an outcome of the setUser(user) in my suthentication service a s the student 
is actually referenced from the user and the user also points to the student. This same concept applies to the instructor as the relationship between instructor and user is the same as that between 
student and users.
-There also exist an admin role in this system who has rights to some special priveledges like performing all CRUD logics on any entity as long has he/she has being registered and authenticated.
