# Using a Java OpenAI Library #

This lab will focus on using a third party library to provide critical functionality.  It will also demonstrate the value of 'poking around' and trying different solutions.

In an earlier lab I indicated that there was no Java API that would work as well as the Python OpenAI API.  That seemed to be the case after an initial view of what was available.  But, after 'poking around', I found one that would work and gives probably 99% of the APIs functionality.  All callable from Java. What a find!

The library is called openai-java.  it is found on github.  It required buidling the library from scratch using a Java build tool called gradle.  You may find more inforamtion about gradle here:  https://gradle.org/. Build tools are a critical part of large scale programming. However, it is too early in the course to cover this topic. We will before the course is over!

You will need this secret key: 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

It is tethered to Dr. Del Vecchio's OpenAI account - the max he can lose is $8!  Be kind to it.

This will also be the first lab where you may use VisualStudio Code.  You are encouraged to use it and stick with it!

---

**Project**: Examination of openai-java 3rd Party Library

**Created By**: Justin Del Vecchio

**Date Created**: February 11, 2024

**Version**: 1.0

**Target Community of Interest**: ACME Corp's project planning management.

---

**Research Goal**: Call ChatGPT OpenAI via the openai-java 3rd party library.

**Summary**: We will use the openai-java 3rd party libary.  This proivdes a high quality Java wrapper for calling the OpenAI.  The 3rd party library should allow ACME developers to call OpenAI with the same ease as using the Python library.  This lab project will prove if the library can do what we believe it can.

**References**:

The openai-java library is found here:

https://github.com/TheoKanning/openai-java

Take a peek around this library.  It seems fairly high quality.  Indicators are abundant.  Its is activley maintained, we see additions within the last two months.  The README is fantastic with mutliple examples.  There are 35 contributors.  It uses a sophisticated build tool called gradle.  There are 23 Tags (think versions) of the API.  There is a lot of code - hundreds of Java classes.  Lastly, the author seems like a coding enthusist who creates code for fun.

The issue with using this library is that it is a 3rd party library.  The library itself relies on many other third party libraries.  How many?  Open the libs folder within Visual Studio Code.  There are 21 3rd party libraries we need to add in order to run openai-java!

**Performance Parameters**:

Our measurable at the end of this examination is getting the two test cases to pass.  Our goal is to verify that both approaches work.

---

**Research Approach Needs and Tasks**:  Here is a plan to complete this research project.

**Task One**: Look at the class Lab3.java.  It has a main method.  There are two functions defined for it.  Get this class to compile first.  If you click the run button, it will return with multiple compile errors.  You need to add a block of code to launch.json that will add the libs folder (the one to the left with all the 3rd party libraries) to the build process.  You will find the JSON file in the folder named .vscode You will need to consult the internet and experiment with trial and error.  Hint - you will not need to specify each jar file individually, there is a simple way to just include the entire directory.

Once you have the code compiling, you may run it.  It run the method getCompletionRequest().  It asks ChatGPT what temperature water freezes it.  However, it uses a model (babbage-002) from 2021.  You will not the answers it gives are non-nonsensical.  It shows how much OpenAI has evolved in just three years!

**Task Two**: You will note there is an empty method name getChatExample().  You will fill in this method.  Along the way, you will learn how to solve problems that come up in IDEs.  First, consult this github URL first from the openai-java project:

https://github.com/TheoKanning/openai-java/blob/e7de81c29319d605703a874c3f1fa56f61122e8b/example/src/main/java/example/OpenAiApiExample.java#L44

Look at lines 38 through and including 55.  You will need to do the following:

- Copy and paste this code into the method getChat()

- It needs an OpenAiService object.  Copy the OpenAiService line from the getCompletionRequest() method into the getChat() method.  It must be the first line of code!

- There are many import errors.  You will need to solve them!  There are couple ways to do this.  One easy way is the following.  Open a terminal within the IDE (you may already have one from the prior step.). Click on the Problems tab.  Right click on the individual problems.  If it is an import problem, it lists out imports you might want to consider having automatically imported into the Java file.  Hint - the first import suggested is typically the right one to use!

- Add the imports and get the code to compile.

- Run the code.  It will create what is called a Streaming response.  When you use ChatGPT all of this overhead is stripped out. All you see is the natural language response combined into one reply.  In actuality it is sent as multiple parts.  These parts are combined by ChatGPT client.

Give the replies a look.  Here is an example of one. Note the part that says content= wag. If you combine all of these sections across all the replies, you get the natural language reply.

> ChatCompletionChunk(id=chatcmpl-8rRdf4Xr1kGtzwe5V8vpqeiN49ODE, object=chat.completion.chunk, created=1707748319, model=gpt-3.5-turbo-0613, choices=[ChatCompletionChoice(index=0, message=ChatMessage(role=null, content= wag, name=null, functionCall=null), finishReason=null)])

**Task Three**: Here is what you need to do:

1. Create a file in the root of your workspace named question2_output.txt
2. Copy all of the output and paste in this questions box after you see:
Streaming chat completion...

It will have all the streaming parts. Paste all those sections in there and save your solution!

**Task Four**: Run the two tests.  One will pass.  One will be scored manually.  I will look at your question2_output.txt