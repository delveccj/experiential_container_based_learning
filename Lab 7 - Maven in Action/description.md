This lab's objectives are

1. Have you use maven, and

2. Create and implement a pom.xml file.

Step 1:  Creating a Proper Project Structure:

Look at Book.java.  You will see that it resides in the root level of the project.  When using maven and a properly packaged Java project, you need to use a proper directory structure.  The same applies for Python projects in case you are wondering.  So, your first step is to make your project structure look like this:

usercode/
├── src/
│   └── main/
│       └── java/
│           └── Book.java
└── pom.xml
This is key for Java maven projects - having the correct directory structure.

Step 2: Running the code:

You will notice we have an immediate problem.  If you open Book.java you will see the imports are not found.  Like this:



How will we get the imports in there?  Look at the pom.xml file.  There is a comment where you can add dependencies.  But there are none.  

Task 1: You are to add the dependency for Apache Commons Logging version 1.2.  It is up to you to find how to add it!

Step 3.  Running Maven:

Now that you have the dependency in the pom.xml - it is time to use this great utility!  Scroll to the location for the Maven project in the tree to the left - found here:



These are the lifecycle options.  You have:

validate:The validate command checks the project's configuration files (such as pom.xml) to ensure they are valid and correct. It's mainly used for validating the project setup before starting the actual build process.

compile:The compile command compiles the source code of the project. It compiles all Java source files (*.java) in the src/main/java directory and generates corresponding class files in the target/classes directory.

clean:The clean command is used to clean the project by deleting the target directory. This directory contains all the compiled classes, generated files, and built artifacts created during the build process. Running mvn clean removes this directory, allowing for a fresh build without any artifacts from previous builds.

install:The install command is used to install the project's artifacts (JARs, WARs, etc.) into the local Maven repository. This local repository is typically located in the user's home directory (~/.m2/repository). Installing artifacts makes them available for use by other projects on the local machine.  It actually calls a bunch of commands - all in one.  It calls:

Validate: Maven validates the project, ensuring that all necessary information is available for the build.
Compile: Maven compiles the main source code of the project.
Test: Maven executes the tests in the project.
Package: Maven packages the compiled code into a distributable format (e.g., JAR, WAR).
Integration-test: Maven runs integration tests against the packaged code.
Verify: Maven performs additional checks to verify the package is valid and meets quality criteria.
Install: Maven installs the package into the local repository, making it available for other projects on the same machine.
These are just the basics.  For now, it is all you will need to know.  Run these commands - see what happens.  They have a triangle to the right that allows you to run them.

A typical sequence is 

mvn validate
mvn clean
mvn install

Take a look at what happens after the install command is run. You will see a new folder is create. It is called target.  Open it and exam its contents.  You will see a jar file is created named Lab8-1.jar.  This packages the class file so others may reuse it.  Its is the output of the build process.  The name of the jar file was determined by attributes defined in the pom file.  These are typically called artifacts.

Try to run it at the command line - not much happens.  Here is how.  From the terminal, cd to the target directory.  Then run:



java -jar Lab8-1.jar
Onto the next task.

Task 2: Making a Runnable Jar File

You need to create a section that adds a custom build.  It will generate an executable Jar file - one that runs the main method of Book.java.  Note, it needs to be smart enough to package in that third party library!   Here, Google it or ask ChatGPT (or Bing chat - no need to login!).

The jar file you create this time must be named:

Lab8-1-jar-with-dependencies.jar
At that point, rerun the java -jar command.  It will run the main method of Book.java.  You will know it works if it outputs the information about The Great Gatsby.

Step 4

If you have completed all the above - the tests should pass!

