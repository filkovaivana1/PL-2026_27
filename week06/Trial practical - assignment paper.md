---
title: "Programming Languages (CSCI 2430): Trial practical"
subtitle: "Week 6, academic year 2026/27. Time: 60 minutes. This trial does not count for the grade."
---

## Rules

1. Closed book. No phone, no AI tools, no old solutions, no help from other students.
2. You may use IntelliJ IDEA and the Java documentation inside the IDE.
3. This paper stays in the room. Do not photograph it and do not copy it.
4. Create a new private GitHub repository named `proglang-trial` plus your name. Add Dejan and Ivana as collaborators.
5. Commit after every finished step. Push before the time ends. Work that is not pushed in time is not graded.
6. After the time you explain your solution in a short talk of about five minutes and make one small change live.

## Setup

1. Copy the folder `trial` that you received into your new repository folder and open it in IntelliJ IDEA.
2. All your classes go into the package `trial`, in `src/main/java/trial`.
3. The class `Main` is given. It does not compile until your classes exist. When everything works, its output must match the expected output at the end of this paper.
4. All fields must be `private`. All classes, constructors and methods named below must be `public`.

## Assignment 1: Student (30 points)

Write the class `Student`.

1. Fields: the index number (a `String`), the name (a `String`) and a list of grades (whole numbers).
2. Constructor `Student(String index, String name)`. A name that is `null` or blank becomes `"Unknown"`.
3. Getters `getIndex()` and `getName()`.
4. `boolean addGrade(int grade)`: only grades from 5 to 10 are accepted. An accepted grade is stored and the method returns `true`. Any other value is refused: nothing is stored and the method returns `false`.
5. `int gradeCount()`: how many grades are stored.
6. `int passedCount()`: how many stored grades are 6 or higher.
7. `double average()`: the average of the grades that are 6 or higher. When there is no such grade, the result is `0.0`.
8. `toString()` in exactly this format: `4711 Ana Petrova, passed 2, average 9.0`

| Points | For |
|---|---|
| 8 | fields, constructor, the rule for the name, getters |
| 8 | `addGrade` with its rule, `gradeCount` |
| 10 | `passedCount` and `average`, including the case without passed grades |
| 4 | `toString` |

## Assignment 2: Courses and a semester (30 points)

**Part A.** Write the abstract class `Course`.

1. Fields: code (a `String`), title (a `String`) and ects (an `int`). Constructor `Course(String code, String title, int ects)`. An ects value below 1 becomes 1. Getters for all three.
2. Two abstract methods: `boolean isPassed(int points)` and `String kind()`.
3. Two courses are equal when their codes are equal. Write `equals` and `hashCode`.
4. `toString()` in exactly this format: `CSCI2440 Internet Programming (6 ECTS, project)`. The last word is the result of `kind()`.

**Part B.** Write two subclasses.

1. `LectureCourse`: it is passed with 50 points or more. `kind()` returns `"lecture"`.
2. `ProjectCourse`: it has one more field that says whether the project was handed in. At the start it was not. The method `void handInProject()` sets it, `boolean isProjectHandedIn()` reads it. The course is passed only when the project was handed in and the points are 60 or more. `kind()` returns `"project"`.

**Part C.** Write the class `Semester`. It has a list of courses.

1. `boolean addCourse(Course course)`: a course that is equal to one that is already there is refused with `false`. Otherwise it is stored and the method returns `true`.
2. `int courseCount()` and `int totalEcts()`.
3. `int passedEcts(Map<String, Integer> points)`: the map holds the points of one student, with the course code as the key. The method returns the sum of the ects of all courses that the student passed. A course that has no entry in the map counts as not passed.

| Points | For |
|---|---|
| 10 | Part A: abstract class, rule for ects, `equals` and `hashCode`, `toString` |
| 10 | Part B: both subclasses with `super(...)`, `@Override` and the right pass rules |
| 10 | Part C: `addCourse` without duplicates, `totalEcts`, `passedEcts` |

## Expected output of Main

```
Grade 11 accepted? false
4711 Ana Petrova, passed 2, average 9.0
Same code again? false
Passed ECTS before the project: 6
Passed ECTS after the project: 12
CSCI2440 Internet Programming (6 ECTS, project)
```
