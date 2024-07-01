An element of large scale programming is defining what a software development project is.  That is, what the project is in terms of how it is defined, what it its goals are, what background work has been performed, and what tasks need to be completed.  The description of this lab is provided in the vocabulary you would expect to find in Industry.

Here is the setup.  Let's assume you work at a company that develops software.  They have a series of internal projects or research projects they wish to perform.  Companies will typically have a portfolio of such projects to choose from.  They key is, such an idea needs to bounded.  It needs to be scoped. Why?  So that project management can plan the future and make rational decisions about, literally, what to do next.  What project do they work on next.

Imagine, if you will, the following project description is one of those in the portfolio.  It is for a fictitious company named ACME Corp who develops software for state governments.

_____________________________________________________________________________________________

**Project**: Examination of OpenAI's API Via Java

**Created By**: Joe Smith

**Date Created**: January 27, 2024

**Version**: 1.0

**Target Community of Interest**: ACME Corp's project planning management.

________________________

**Research Goal**: Determine the feasibility of calling and using the OpenAI API directly from Java code.  It is a native Python API with few Java bridges.

Summary: We have an existing Java code base.  We wish to integrate OpenAI's ChatGPT capabilities into the that code base. There are few Java libraries to do this natively.  We need to learn how easy and realistic it is to connect to OpenAI over HTTP.  We also need to use the Java libraries eventually.  At this time we cannot as the best library requires Java 18.  Our target systems only support up through Java 17.  Our target system is the ZyBook advanced lab environment.

**References**:

The soup to nuts OpenAI API implementation is found here:

https://platform.openai.com/docs/overview

For the project we will use this tutorial.  It contains a simple implementation of how to connect with the OpenAI API via HTTP in Java:

https://rollbar.com/blog/how-to-use-chatgpt-api-with-java/

For the part where we want to set the temperature of the requests we will use this.  Temperature is how 'creative' the reply is.  That URL is found here:

https://community.openai.com/t/cheat-sheet-mastering-temperature-and-top-p-in-chatgpt-api/172683

To add temperature to the commands sent to OpenAI over HTTP - use the chat agent found here:

https://chat.langchain.com/

You should ask the agent this question "I am making an HTTP connection to OpenAI directly. How do I send as a parameter the "temperature" attribute?"

**Performance Parameters**:

Our measurable at the end of this examination is getting the two test cases to pass.  Our goal is to verify that both approaches work.

________________________

**Research Approach Needs and Tasks**:  Here is a plan to complete this research project.

Task One: The test bench has two test cases.  They will take command line arguments that are: 1.) the question (note, the question is surrounded by double quotes "" ) and 2. the temperature, set to 0.0

Task Two: Implement the method runOpenAPIHttpOnlyConnection(...). The message printed tells you where to find the code you need to implement.  Some notes on this task:

Look at the arguments it accepts.  It accepts the question followed and the temperature followed by the temperature.
When you first implement the code, it will need an OpenAPI key.  This is the key that you will need:
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

You need to keep the key secret!  Do not post it on the Internet or share with anyone outside this class!  
Run the code from the command line and see the output.  Do it incrementally.  Get it to work with accepting the temperature from the command line but not using it in the request made to OpenAI.  It will output an answer.  Think like an engineer.  Get the connection to work first and establish that it works!

Task Three:  You will need to ask that question of chat.langcahin.com described in the References section.  It might take some trial and error - but you have to take the temperature argument from the command line and pass as an argument to ChatGPT. The test cases will automatically use a temperature of 0.0 when calling your code from the command line.

Task Four: Run the test cases and make sure that they pass.