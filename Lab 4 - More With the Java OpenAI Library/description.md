# More With the Java OpenAI Library #

This lab will extend our use of the opneai-java library.  Chat clients are great.  However, people like to use custom chat clients.  That is, chat clients where the documents searched for answers are their own.  Companies all over the world are doing exactly this; indexing their internal documents to answer questions about previous contracts, to understand what is discussed by employees in internal emails, generatively creating new contracts based off of old ones.

We will start with a more basic approach.  How do we add documents, our documents, as context used to answer questions.

You will need this secret key: PROVIDED_KEY

It is tethered to the instructor's OpenAI account - the max he can lose is $8!  Be kind to it.

This lab will again use Visual Studio Code.  The class path variable has been setup for.  The libraries you need have been added.

---

**Project**: Use Internal Documents as Question/Answering Context

**Created By**: Joe Smith

**Date Created**: February 19, 2024

**Version**: 1.0

**Target Community of Interest**: ACME Corp's project planning management.

___

**Research Goal**: Use OpenAI's Question Answer Capability With a Custom Document Set

**Summary**: We will use the openai-java 3rd party library. This library provides us a way to connect to OpenAI via Java. We will extend our use case to include a custom document set to send to OpenAI to use for question and answering.

This is a basic implementation.  One limitation is that we will only be able to use documents that are 4096 tokens in size.  More about that in the references section.

**References**:

The OpenAI API allows documents to be sent to use as context.  However, we are limited to 4096 tokens.  Here is what this means:

https://help.openai.com/en/articles/4936856-what-are-tokens-and-how-to-count-them

We will therefore be limited on the document size we send in as follows:

- 1-2 sentence ~= 30 tokens
- 1 paragraph ~= 100 tokens
- 1,500 words ~= 2048 tokens

- We will also read in a file from disk and translate it into a string.  This will serve as our context with which we answer questions.   Here is a ChatGPT discussion that explains how to do this.

https://chat.openai.com/share/c7b81c77-1b84-4848-bf7a-04820c2d75ac

There are many ways to send the context and question to OpenAI.  Here is probably the simplest (consult line 32 of the file LabFour.java to see what this means!):
```
{context goes here}

/n/n

{question goes here}
```
**Performance Parameters**:

Our measurable at the end of this examination is getting the content for the three manual test cases.  Our goal is to understand if we can create a custom knowledge store.

___

**Research Approach Needs and Tasks**:  Here is a plan to complete this research project.

**Task One**: There is a file in the project named speech.txt.  It is a speech given by Barbara Jordan at the1976 Democratic Nation Convention (the keynote speech in fact):

https://www.americanrhetoric.com/speeches/barbarajordan1976dnc.html

You need to read the file in as a string.  This will be done in the function getSpeechText(). Note - this function is blank right now - you will need to fill it in!

Task Two: You will look at the function createChatAgentWithContext.  You will find a comment in there labeled Task 2.  In last weeks lab, you printed the replies from ChatGPT with all the information for the different ChatCompletionChunks returned.  For this week - you should narrow down what is returned and just print the content element.  That is - when the function is called like so:

``` Java
    createChatAgentWithContext(speechText, "Whom did the speaker address?");
```

The function should print out the following - a nice natural language answer:

The speaker, Barbara Jordan, addressed the audience at the Democratic National Convention.null

**Task Three**: Last task.

Create a file in the root of your workspace in Visual Studio named question_output.txt
Copy all of the output of all three questions. Paste these answers in the file question_output.txt. 
