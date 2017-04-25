The purpose of this exercise is to gain practical experience using Spring AOP.

The classes provided model the operations of our Academy - 
Candidates are assessed, new Trainees enter the Academy, Mounties go out on site.

Every time an event takes place, a line of text prints to the console.

Your job is to remove all of these println() statements from the provided 
code, without altering the functionality of the program.  All println()
statements are marked with TODO comments for your convenience.

Part 1: XML

Move all println() statements to advice methods within AOPLoggerXML.java.
Configure AOP using XML tags in the provided file academy-xml.xml.

Part 2: Annotations

Load the ApplicationContext from the provided file academy-annotations.xml.
Recreate exactly the same functionality as in the original program by
creating advice methods within AOPLoggerAnnotations.java.
Configure AOP using annotations in the AOPLoggerAnnotations class.

Part 3: Bonus

Add log4j to the system and replace all println() log statements with
calls to log4j Loggers.