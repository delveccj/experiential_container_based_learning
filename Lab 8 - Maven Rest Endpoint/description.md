# Maven Rest Endpoint #
This lab will have many moving parts!  Large scale programming has many moving parts - it is not just about coding.  I will step you through it.  Let's do the following:

---

**Project**: Develop a Tutorial for New Interns that Demonstrates to Easily Create a REST Endpoint with Maven.

**Created By**: Joe Smith

**Date Created**: April 1, 2024

**Version**: 1.0

**Target Community of Interest**: ACME Corp's latest set of intern hires.

___

**Goal** The goal of this lab is to teach you how to implement a simple RESTful service using Maven, build it, and create a runnable Jar file. This exercise will help you understand the intricacies of managing dependencies, compiling code, running tests, and packaging your application, reflecting the complexities of large-scale programming projects.

**Summary** In this lab, you are an ACME Corp developer tasked with creating a tutorial for new hires on setting up a Maven-based RESTful service. You will first review REST endpoints using a real-world example, then create a Maven project following a guided tutorial. Finally, you will run a test bench to ensure your project is correctly set up and functioning. This comprehensive exercise will provide hands-on experience with Maven and RESTful services.

**References**
To help you complete this lab, refer to the following resources:
1. [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)
2. [Spring Guide: Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
3. [Maven: The Complete Reference](https://books.sonatype.com/mvnref-book/reference/public-book.html)

**Performance Parameters**
Your performance in this lab will be evaluated based on:
1. **Correctness**: The RESTful service must compile and run correctly with all dependencies managed by Maven.
2. **Maven Configuration**: Proper setup and configuration of the `pom.xml` file to manage dependencies, plugins, and build lifecycle.
3. **Runnable Jar File**: Successful creation of a runnable Jar file using Maven.
4. **Endpoint Functionality**: The RESTful endpoint must be accessible and return the expected results.
5. **Documentation**: Clear and concise documentation of the steps taken and any challenges faced during the lab.

**Research Approach Needs and Tasks:**

**Task 1: Review REST Endpoints**
1. Open Chrome or Firefox.
2. Navigate to [Whitehouse.gov](https://www.whitehouse.gov).
3. Open Developer Tools (F12 in Chrome, equivalent in Firefox).
4. Click on the Network tab.
5. Observe the REST endpoints being used on the page, particularly the Google tracking endpoint.
6. Understand the different query parameters used in these endpoints.

**Task 2: Create a Maven REST Project**
1. Create a Maven REST project by following this [Spring guide](https://spring.io/guides/gs/rest-service/).
2. Ensure you issue all commands from the `/usercode` directory, as the automated test anticipates this.
3. Follow the tutorial to set up the project, implement the REST service, and configure Maven.

**Task 3: Run the Test Bench**
1. Navigate to the `demo` directory.
2. Build your project using Maven.
3. Run the project to ensure it starts correctly.
4. Use `curl` or a similar tool to test the RESTful endpoint and verify it works as expected.

By completing these tasks, you will gain practical experience with Maven and RESTful web services, essential skills for any Java developer.
