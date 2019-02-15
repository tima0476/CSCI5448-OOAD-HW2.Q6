# CSCI5448-OOAD-HW2.Q6
Homework 2 Question 6 solution for CSCI 5448 - Object Oriented Analysis and Design

Name: Timothy Mason

Collaborators: none

This is a Java program.  Assumes the JDK is installed, and `javac` plus `java` are in the path.  Programmed and tested
using:

```
java 10.0.2 2018-07-17
Java(TM) SE Runtime Environment 18.3 (build 10.0.2+13)
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.2+13, mixed mode)
```

My original solution from Homework 1 was written in Python.  I have not made any changes to the high level design.  Note: This
design assumes all shapes are regular polygons and therefore having a center point and radius
in the base class (common to all shapes) makes sense.

**Discussion:** In light of what has been discussed in class, if I were to redesign this
application I would use a delegation pattern rather than inheritance.  Instead
of a shapes base class I might define a shapes interface, and then the various
shapes such as Circle, Square, and Triangle would implement the Shapes
interface.  I also would further specialize each specific shape class to
remove the regular polygon restriction.  For example, the Triangle could be
modified to allow definition on a non-isosceles triangle.  (The center could
then be computed as the average of the 3 points)

## Execution instructions:

From a Unix or MacOS command line, execute `./run.sh`

In Windows, open a command shell (`cmd.exe`), then execute `run.bat` from the directory with the source files.
