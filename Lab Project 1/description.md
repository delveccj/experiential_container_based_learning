This lab project will put all the pieces of the prior labs together into a single prototype.  It will create a chat agent that will:

1. Have multiple custom knowledge stores to choose from.

2. Allow the use to interactively ask questions using a specific knowledge store.

You will need this secret key: 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

It is tethered to Dr. Del Vecchio's OpenAI account - the max he can lose is $16!  Be kind to it.

The lab project will use Visual Studio Code.  You will be responsible for creating and implementing the requested classes.

The name of the game of this lab project is - develop incrementally.  A key problem of new programmers is breaking a larger problem into smaller, manageable chunks.  This project will teach you how to break a project into chunks.  It will have tests along the way.

_____________________________________________________________________________________________

Project: Creating a Custom Chat Agent

Created By: Justin Del Vecchio

Date Created: February 24, 2024

Version: 1.0

Target Community of Interest: ACME Corp's end user's beta test team.

________________________

Research Goal:

Create a custom chat agent.  The chat agent will use transcripts from financial discussions and allow user's to ask questions of the transcripts to find information.

Summary:

We have two transcripts from a web site dedicated to investment discussions.  The site is focused on creating an archive of investment advice for the average investor.  It has weekly episodes.  We transcribed two episodes using the Whisper API.  We now seek to use those transcriptions as a knowledge store for a custom chat agent.  The agent should be able to switch between the different documents.  Here is an example of a discussion:

Enter a query to search the transcript: How does the speaker believe AI will supplant tech jobs?

Querying transcript:

Streaming chat completion...

The speaker believes that artificial intelligence (AI) will supplant tech jobs by improving productivity and profit margins for companies. As companies invest in AI technology to enhance their operations, they may rely less on human labor for certain tasks, leading to the displacement of some tech jobs. Companies that accumulate a lot of data on their consumers and leverage AI technology to analyze and utilize that data may have an easier time improving their profit margins, potentially reducing the need for certain tech-related roles.null

We will use the openai-java 3rd party library. This library provides us a way to connect to OpenAI via Java.

References:

Here is a link to the web site that hosts the financial discussions.

https://wealthtrack.com/

The host brings in weekly guess from across the financial spectrum.  There are many differing options - some positive about the state of the financial world, some negative.  The discussions offer advice to investors along the way.

Two of the interviews were transcribed using the WhisperAPI.  You will not have to do the transcription - it costs roughly 20 cents to perform.

Performance Parameters:

The lab project should be built incrementally.  That is, build it a step at a time.  Make sure the step's tests pass along the way!

________________________

Research Approach Needs and Tasks:  Here is a task plan to complete the prototype project.  You have been provided a blank Visual Studio Code project with the exception of Main.java and ChatAgentUnitTests.java.   Do not edit or alter these files in any way!  They are used to answer some of the submission test question.  You will need to implement the following tasks.

Task One: Getting the ClassPath to Work

Using the openai java API requires many 3rd party libraries.  In past labs these have been in the folder named libs. For this task you will need to:

1. Download a zip file that contains the 3rd party libraries.  They are jar files.  You may download from here:

https://drive.google.com/file/d/1AjKeT6d8NdGVRH_bQw368F8IH11A1_Rf/view?usp=share_link

2. Create a folder named libs in the userdata folder.  It must be named exactly this.  You must place the individual jar files into this folder - not simply the whole zip file.  It should look just like the other projects.

3. You will be responsible for adding the libs folder to your launch.json as a classpath argument.

4. You will be responsible for ensuring that you have configured the project correctly and can use the 3rd party libraries.

Test Incremental:

Test 1 and 2 will pass if you have done the steps above.  Note, Test 1 will not pass if you create an empty libs folder.  It needs some files in it to pass.

Test 3 will pass once you have added the classpath to the launch.json.

Test 4 will pass if you have done everything correctly - it will actually call OpenAI.  This test is what Main.java is used for.

Task Two: Getting the Transcripts

There are two transcripts you will use.  They are located here:

Transcript Name	Access URL	Date Recorded	Summary
wealth_track1_episode.txt	Here	1/20/24
LEADING STRATEGIST JASON TRENNERT IDENTIFIES MAJOR INVESTABLE THEMES FOR 2024   
wealth_track2_episode.txt	Here	10/21/23
VETERAN INTERNATIONAL ECONOMIST NICK SARGEN EXPLAINS WHY CHINA’S ECONOMY IS UNRAVELING

This task will have you add the two transcripts to the project.  You will then need to turn them into String objects.  These will be used as the context for the application.  Here are the specific sub-tasks for this task.

1. You will need to create a Java class called ChatAgentPrototype.java.  It must be a public class so that it may be called.

2. You must have two public, static, final int constants.  They should be named EPISODE_1 and EPISODE_2.  Their values should 0 and 1 respective.  For example:

public static final int EPISODE_1 = 0;


3. ChatAgentPrototype must have a static function that returns a String array with exactly two elements (or a size of two).  The zero index should hold the text of wealth_track1_episode.txt. The one index should hold the text of wealth_track2_episode.txt.  The signature should be (note, it should have public accessibility):

public static String[] getTranscripts()


You see where this is headed.  We need the text of both files as strings.  The array is the holder.  The static constants are the lookups into the array to find the respective texts.

*Note* - you are not allowed to copy and paste the file contents as strings into the code.  The method getTranscripts() must read both files in and return an array populated with them.  Manually download the two text files from the link above.  Save them into your usercode directory in  folder named resources.  For clarity, your usercode directory in VisualStudioCode should look like the following with respect to the resources directory - there should be two files in it with a .txt extension:



Test 5 - This tests that ChatAgentPrototype.java can be compiled.

Test 6 - This tests that the resources directory exists and is populated with the txt files.

Test 7 - Makes sure you have created the pubic static variable and that the array of transcripts is returned.  This runs the JUnit tests.

Task Three: Switching Contexts and Exiting

You must now make a command line agent.  It will allow the user to:

1. Select a transcript to use as context.

2. Send a question to ChatGPT based on the selected transcript.

3. View ChatGPT's reply.

4. Exit the agent.

5. Handle invalid input.

This task will focus on items 1, 4, and 5 above.  Items 2 and 3 are handled in the next task.  Remember, we will do things incrementally.  Here is an example of how the command line client should work for items 1,4, and 5 above.  It prints out a little preamble, and then it has:

Enter command:
This where you need to collect the command the user enters.  Based on the command entered you might also see:

Enter a query to search the transcript:
This is also where you need to collect input from the user, this time the query to be sent to ChatGPT.

Welcome to the financial chat agent!
There are two transcripts currently available.
Transcript 1 is about the potential of AI. Transcript 2 is about the economic perils confronting China. The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command: Query1
Enter a query to search the transcript: What did the speak say?
Querying transcript:
Would have asked ChatGPT: What did the speak say?
______________________________________________________
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command: Query2
Enter a query to search the transcript: What did the speaker here say?
Querying transcript:
Would have asked ChatGPT: What did the speaker here say?
______________________________________________________
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command: INvalawd
Invalid command.
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command: asdlkfj
Invalid command.
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command: Query1
Enter a query to search the transcript: What did that speaker say again?
Querying transcript:
Would have asked ChatGPT: What did that speaker say again?
______________________________________________________
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command: Exit
Exiting the application.
Again, there is a lot here!  Look it over.  In actuality, it is not that difficult.  You need to implement logic to do the following:

1.  A message that prints to the screen when the application starts.  This bit.  Your welcome message may be whatever you want.  However, the commands your client accepts -  Query1, Query2, and Exit - must be exactly spelled like that!  If they are not, you will not be able to pass one of the tests for this step:

Welcome to the financial chat agent!
There are two transcripts currently available.
Transcript 1 is about the potential of AI. Transcript 2 is about the economic perils confronting China. The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
2. Next, inside a while loop you need to listen for the user input.  Lets handle the easy cases - Exit and some type of invalid input.    When the user Types Exit, the application exits.

Enter command: Exit
Exiting the application.
When invalid input is entered, the user is warned and the commands are repeated:

Enter command: asdlkfj
Invalid command.
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
2. The fun part is when Query1 or Query2 are entered.  At that point, the following sequence happens:

Enter command: Query2
Enter a query to search the transcript: What did the speaker say?
Querying transcript:
Would have asked ChatGPT: What did the speaker say?
______________________________________________________
The commands are:
Query1 - Enter to query Transcript 1
Query2 - Enter to query Transcript 2
Exit - Exit the application
Enter command:
Here, the command to query ChatGPT is recognized.  You code needs to collect what the user's desired query is.  After that, it should query the transcript using the openai-api.

The output above simply demonstrates what query would have been sent to OpenAI.  It then cycles back to wait for the next user command.

Remember, do not connect the querying to ChatGPT yet!  Do things incrementally.  If you get to this point and have a  client that behaves like the above  - you are making great progress.

Test 8 should pass if you do this part correctly.  It will call your ChatAgent and simulate the user input - testing only the Exit and invalid input cases.

Task Four: Completing Your ChatGPT Agent

You are in the home stretch.  You have all the pieces to the puzzle.  Lab 5 had you create a chat agent that returned natural language answers.  You should:

1. Reuse that code from Lab 5 that sends the user questions to OpenAI.

2. Be sure to send the selected transcript as context!

3. Increase the max token size to be 200.  This will double the size of what you returned in Lab 5.

4. Print natural language answers.

5. Always keep the temperature set to 0.0

When you run the client, you should get output as follows.  Note, the part after Enter a query to search the transcript: is entered by the user.  In your manual testing, you should review the transcripts and think of some questions to ask.  See if it works:

Welcome to the financial chat agent!

There are two transcripts currently available.

Transcript 1 is about the potential of AI. Transcript 2 is about the economic perils confronting China. The commands are:

Query1 - Enter to query Transcript 1

Query2 - Enter to query Transcript 2

Exit - Exit the application

Enter command: Query2

Enter a query to search the transcript: What are the main problems confronting China's economy?

Querying transcript:

Streaming chat completion...

The main problems confronting China's economy include:

1. A weakening property sector: The property sector in China is facing significant challenges, with some of the premier developers, such as Evergrande, filing for bankruptcy. This sector accounts for as much as 30% of the economy and is a major source of savings for Chinese citizens.

2. State-owned enterprises vs. private enterprises: There has been a shift towards favoring state-owned enterprises over private enterprises in China, which has led to inefficiencies in the economy.

3. Diminishing returns on investment: China has experienced diminishing returns on investment, with each additional investment in the economy resulting in less output. This is a structural issue that is limiting the country's growth potential.

4. Population stagnation: China's population growth has stagnated due to the one-child policy, leading to a slowdown in the labor force and overall economic growth potential.

5. High levels of debt: China's total debt has doubled in the past 15 yearsnull

______________________________________________________

One test will be run to test your ChatAgent works as specified -

Test 9 - This tests switching to transcripts and submitting questions.  The exact script sent is as follows.  The test will literally launch your agent and then submit these questions to it as thought it were a human user:

Query1

"What was the speakers main point?"

Query2

"What was the speakers main point?"

Exit