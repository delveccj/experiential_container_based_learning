# Maven Lab Project #

---

**Project**: Create a Proof Of Concept to Read and Translate a Streaming REST JSON Reply into an Object.

**Created By**: Joe Smith

**Date Created**: April 14, 2024

**Version**: 1.0

**Target Community of Interest**: ACME Corp's senior management.

---
**Goal**
The goal of this project is to connect and interact with the Polygon API.  This provider has real time stock quotes.

**Summary**
In this project, we will explore the concepts of REST endpoints and interfaces, and implement missing functionalities in a provided project. They will ensure the project passes all unit tests, interact with a live REST endpoint, and finally, push their completed project to a Git repository.
We will demonstrate that there is a path for ACME Corp to use the Polygon API and begin development of a real time stock 
recommender system.

**References**
To help you complete this lab, refer to the following resources:
1. [Polygon API](https://polygon.io/)
2. [Polygon API Getting Started Guide](https://polygon.io/docs/stocks/getting-started)
3. [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)
4. [Spring Guide: Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

**Performance Parameters**
The success of this project will be evaluated based on:
1. **Correctness**: Ensuring the RESTful service and all functionalities work as intended.
2. **Maven Configuration**: Proper setup and configuration of the `pom.xml` file.
3. **Unit Tests**: Successfully passing all unit tests.
4. **Live Endpoint Testing**: Verifying the project works with the live Polygon REST endpoint.
5. **Git Repository**: Pushing the completed project to a public Git repository and providing the URL.
---
**Tasks**

**Task 1: Setting Up the Environment**
1. From the command line, issue these two commands in the `/usercode` directory:
   ```sh
   chmod a+x add_maven_to_path.sh
   source ./add_maven_to_path.sh

If you do an ls in the the /usercode directory and it looks like this, you executed the scripts correctly!  The scripts make the pom command executable.  Notice that the image goes through the steps you are instructed to do above.  The coloring of some of the files turns to green at conclusion of the steps.  That color indicates it is executable and may be called from the command line.

Then, from the command line run the following.  We used the maven command from within VisualStudio code UI previously.  For this project, simply use the one from the command line as that is how it will be graded:
   ```sh
mvn validate
```
You should see output like this - though yours probably won't say BUILD SUCCESS at this point:

**Task 2.  Review Project Directories**

Let's take a look at these directories and understand what is in them! Look at the image below:

.m2 - holds the dependencies downloaded by pom.xml

.vscode - holds the configuration file for the VisualStudio project.  This is not the same as the pom.xml configuration!

src - holds the Java source code

src/main/java/edu/canisius/csc213/project2 - source code for Project 2.  The file Controller.java is intended to be run from the command line.  You will notice that this project has a Java package structure (edu.canisius.csc213.project2).

src/test/java/edu/canisius/csc213/project2 - test code for Project2.  You will notice that some of the files are mirrored.  For example, there is a Controller.java in the source code directory and a matching ControllerTest.java in the test code directory.

target - this is where the compiled code goes at the end.

This is a standard layout of directories for a Java maven project.

NOTE:  If you environment goes to sleep and needs to reinitialize, or you open it for the first time for the day - it may take some time for the files to populate.  My guess is the container is being restarted and the files are being copied to those directories.  Be patient!  They WILL copy over!

**Task 3.  Test Tasks**

We discussed in class the concept of test first development.  This project is an example of that concept in action.  There are nine tests in the project.  To run the tests you can simply call

mvn test

It will compile the code and run the tests.  You will know you have passed the tests when you see this output:



However, the code is a mess!  The source code is not fully implemented.  So, what is and what is not fully implemented?  All the code in the test directory is fully implemented.  So, nothing needs to be changed there.  This is not the case in the main directory.

Here are the classes that are fully implemented and you do not need to edit as part of this project:

```
Controller.java

StockQuoteProvider.java

MockStockQuoteProvider.java
```

Here are the classes that are not fully implemented and you will need to correct part of this project:

PloygonStockQuoteProvider.java - This needs to:

1.  Correctly implement StockQuoteProvider interface.  The interface contains comments that explain how the functions are intended to function.  You should also reference the unit test tests in RestEndpointUrlCreationTest when you have implemented the missing interface function. It explains how the method should function. This one is medium hard.

2.  Look at getStockQuote.  Its logic is correct.  However, the sendGetRequest method, which it calls, is not implemented.  This method is meant to reach out to the Polygon rest provider with the url created in getEndpointURL.  If you look at the constructor of Controller.java this shows you how the provider is used.  You:  1. Get the url for the rest endpoint, and 2. Get the StockQuote object using the provider and the url.  The trick for the sendGetRequest method - how do you, from Java, connect to a URL, get its returned content, and capture it to a string. This one is pretty hard.

StockQuote.java - It is completely empty!  Just look at StockQuoteTest.java and ControllerTest.java to figure out what it needs to have in it! This one is easy.

PolygonJsonReplyTranslator.java - There is one method in here that needs to be filled out.  It currently returns null.  This class takes the Polygon JSON reply and parses it, and the creates a StockQuote object that is returned.  Note, you must use the com.fasterxml.jackson library to parse the JSON.  Also, you will need to add something to the pom.xml file to make this work.  This one is hard - parsing JSON can be frustrating.

There are not many files that need to be changed.  However, it requires understanding how the Controller.java works as a whole.

Your approch should be the following:

1. Get all the code to compile first.  There are bunch of errors in the source code that are simply related to missing methods - get those to work first.  Event if it just returns null.

2. Knock off the tests next.  Get StockQuoteTest.java and ControllerTest.java to work. That might be a good idea to start. Move on from there.

**Task 4.  Live Code Test**

Having the tests passing are great.  However, they use a mock implementation.  This was discussed in class.  How do you know that all of this will work against the live Polygon REST endpoint?  You have to manually test it.  Note, testing the live functionality is typically not part of a Unit tests responsability.  It would be an automated test that is at a conceptually higher level.  In this case, that automated test will be you!

Run the main method of Controller.java and, at the command line, supply the two required arguments (you will need to figure out how do this in VisualStudio code).  Make sure that the live connection works.  You'll be surprised that it does - the only thing that might go wrong is an incorrect implementation of the sendGetRequest method.

**Task 5. Push to git**

You will last create a repository in git.  You will push your code to this repository.  We will go through an example of how to do this the week of April 22!  You will know how to do it.

Add a comment at the top of Controller.java that is the URL to your public repositry.  

### Scoring Rubric:

1 pt for each of the 9 tests

1 pt for the git URL comment in Controller.java. URL actually reflects the assignments code.

