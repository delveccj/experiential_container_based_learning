#More With OpenAI API#

This lab builds upon what we have done in Lab 2.  The ACME corp knows that it is feasible to call the OpenAI ChatGPT API over the Internet.  Success!

ACME corp develops tutorials and training for people new to investing.  Their product has a Java backend that works with a Web interface.  They have many YouTube videos and audio recordings about investing that reside in their knowledge store.

Their ultimate goal is turn this audio holding into a question answering system.  They envision a chat agent where users can ask questions and get answers across all of the holdings.  This will require: 1. Text extraction from audio, and 2. Development of chat agent that uses the texts as the knowledge base.

The next research step is to determine how well the OpenAI Whisper API works.  This API performs text extraction.

Join ACME as they perform the following research task.

_____________________________________________________________________________________________

**Project**: Examination of OpenAI's Whisper API

**Created By**: Justin Del Vecchio

**Date Created**: February 4, 2024

**Version**: 1.0

**Target Community of Interest**: ACME Corp's project planning management.

________________________

**Research Goal**: Determine the feasibility of calling and using the OpenAI's Whisper API .  Evaluate the quality of the generated voice transcription.

**Summary**: We will use the Whisper API.  It will be called with Java using HTTP connections.  We will supply a sample audio file.  We will generate the transcription.  We will perform a basic examination to determine if the transcription has good precision.

Our target systems only support up through Java 17.  Our target system is the ZyBook advanced lab environment.

**References**:

The OpenAI Whisper API implementation is found here:

https://platform.openai.com/docs/guides/speech-to-text

The examples are in Python.  We are interested in the arguments it accepts. Review it to understand limitations and issues we will need to consider.

We will use this site to get audio MP3s as our target.  It is the Presidential Library for Franklin Delano Roosevelt. The audio is completely in the public domain:

http://www.fdrlibrary.marist.edu/archives/collections/utterancesfdr.html

We will use this specific speech.  It is a speech:

https://www.fdrlibrary.org/documents/356632/405112/afdr003.mp3/

We need to download and store the MP3 file above.  Here, we will use this example.  There are many ways to do this. This one is one line of code!  But it will require us to use a third party library (that is, not one standard to the Java JDK).  It is org.apache.commons.io

https://mkyong.com/java/java-how-to-download-a-file-from-the-internet/

https://commons.apache.org/proper/commons-io/

Using a third party library will require us to set what is called the class path.  Here are some directions one of our engineers put together for Java class path to help whoever does this research task:

https://chat.openai.com/share/cf284baf-09ae-4aad-977b-76b6b545ee7b

And here is the link to where we can find the Jar file that holds the third party library.  It has been included in the lab's /usercode directory.  It is simply called commons-io.jar This URL is document where it was downloaded from:

https://repo.maven.apache.org/maven2/commons-io/commons-io/2.15.1/commons-io-2.15.1.jar

Next, we need to call the Whisper API.  This is explained further in the tasks section.

**Performance Parameters**:

Our measurable at the end of this examination is getting the two test cases to pass.  Our goal is to verify that both approaches work.

________________________

**Research Approach Needs and Tasks**:  Here is a plan to complete this research project.

**Task One**: Look at the file MP3Downloader.java.  You can just go ahead and compile and run this file.  It will just work and download the file for you!  There is one issue, though.  You will need to figure out how to add the jar file:

commons-io.jar

to your Java class path.  Without it, you will get an error that looks like this.  That is to be expected!
```
MP3Downloader.java:14: error: package org.apache.commons.io does not exist
import org.apache.commons.io.FileUtils;
^
MP3Downloader.java:29: error: cannot find symbol
FileUtils.copyURLToFile(new URL(FDR_SPEECH_URL), speech, 10000, 10000);
This will be a task of trial and error!  You will know you are successful when you see the file speech.mp3 in the file viewer to left.
```
**Task Two**: No skipping, you must have done Task One before moving to this task! In the file directory at left you will find a script file.  It is named:

curl_example.sh
This file, when run from the command line, will connect to OpenAI and send the audio file to be processed.  Look at the Java file WhisperExample.java.  It shows how you can call a script (in this case the Linux bash script that calls WhisperAPI) from within Java.  It's really handy and will work just fine.

You will notice something about this file though.  First, it won't run if you do not perform Task 1.  Second, there is a comment in it.  What you need to do is to capture the output of the curl command.  What the curl script is doing is saying "ChatGPT - here is an audio file.  Transcribe it for me.  And then return me the text."  Were you to run this from the command line - it is exactly what you would see!

But you are running it from Java.  So, you need to figure out how to capture the output from a ProcessBuilder.  This will be a bit of trial and error on your part.

**Task Three**: Run the test cases and make sure that they pass.

