

CampusConnect – University Management Backend System

CampusConnect is a backend application that implements a real-world university management system. It models core academic and administrative operations found in higher education institutions.


---

Overview

The system manages users, authentication, and academic structures such as faculties, departments, courses, students, and instructors. It is designed with proper entity relationships, role-based access control, and data integrity in mind.


---

Core Entities

User

StudentProfile

InstructorProfile

Faculty

Department

Course


All entities reflect real-world university structures and workflows.


---

Authentication & Authorization

The User entity is the central entry point of the system.

Every user must be registered and authenticated before accessing the system.

Roles are defined using enumerations:

STUDENT

INSTRUCTOR

ADMIN



Depending on the assigned role, a user gives rise to either a StudentProfile or an InstructorProfile.


---

Entity Relationships

A User can be associated with one StudentProfile or one InstructorProfile.

Student and Instructor profiles are fully dependent on the User entity.

Profiles are created through setUser(user) during registration and persisted via the User repository.

This ensures:

a single source of truth for authentication

strong referential integrity

clean domain modeling




---

Admin Privileges

Users with the ADMIN role have elevated permissions and can:

Perform full CRUD operations on all entities

Manage faculties, departments, and courses

Assign instructors, heads of department, and other academic roles

Oversee system-wide configurations



---

Features Implemented

Role-based authentication (Admin, Student, Instructor)

Faculty management (create, update, assign, retrieve)

Department management

Course management

Student and Instructor profile management

Secure entity relationships and validations

Clean separation using DTOs and mappers



---

Tech Stack

Java

Spring Boot

JPA / Hibernate

RESTful APIs

PostgreSQL

JWT-based authentication



---

Project Focus

CampusConnect is not a simple CRUD application.
It demonstrates:

Real-world backend system design

Proper use of entity relationships

Role-based access control

Data integrity and consistency

Scalable backend architecture



