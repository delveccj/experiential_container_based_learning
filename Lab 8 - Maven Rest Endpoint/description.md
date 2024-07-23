This lab will have many moving parts!  Large scale programming has many moving parts - it is not just about coding.  I will step you through it.  Let's do the following:

Step 1: Review Rest Endpoints

Lets look at an endpoint in action:

Open up Chrome or Firefox
Lets head to Whitehouse.gov
Let's open Developer Tools (if using Chrome! There is some analogy in Firefox)
Click on the Network tab
And let's look at the services on this page.
It is using Google tracking:
Rest Endpoint Base: /g/collect
Query Parameters:
v=2: Indicates the version of the tracking protocol.
tid=G-CSLL4ZEK4L: Represents the tracking ID.
gtm=45je44m0v9131934939za200: Likely related to Google Tag Manager.
_p=1713970287277: Possibly a timestamp or session identifier.
gcd=13l3l3l3l1: Unknown parameter.
npa=0: Indicates whether non-personalized ads are allowed (0 for false).
dma=0: Unknown parameter.
cid=684367544.1713970255: Client ID.
ul=en-us: User language (English, United States).
sr=1920x1080: Screen resolution.
uaa=arm: User agent architecture (ARM).
uab=64: User agent bitness (64-bit).
uafvl=Chromium%3B124.0.6367.62%7CGoogle%2520Chrome%3B124.0.6367.62%7CNot-A.Brand%3B99.0.0.0: User agent field values (Chromium, Google Chrome, Not-A.Brand).
uamb=0: Unknown parameter.
uam=: Empty user agent modifier.
uap=macOS: User agent platform (macOS).
uapv=14.1.0: User agent platform version (macOS 14.1.0).
uaw=0: Unknown parameter.
are=1: Indicates an event (page view).
pscdl=noapi: Unknown parameter.
_s=1: Unknown parameter.
dl=https%3A%2F%2Fwww.whitehouse.gov%2F: Destination URL (The White House website).
dt=The%20White%20House: Document title (The White House).
sid=1713970254: Session ID.
sct=1: Unknown parameter.
seg=1: Unknown parameter.
en=page_view: Event name (page view).
_ee=1: Unknown parameter.
ep.agency=EOP: Event property (agency: Executive Office of the President).
ep.subagency=WHITEHOUSE.GOV: Event property (subagency: whitehouse.gov).
ep.site_topic=unspecified%3Awhitehouse.gov: Event property (site topic: unspecified).
ep.site_platform=unspecified%3Awhitehouse.gov: Event property (site platform: unspecified).
ep.script_source=https%3A%2F%2Fdap.digitalgov.gov%2Funiversal-federated-analytics-min.js: Event property (script source: dap.digitalgov.gov/universal-federated-analytics-min.js).
ep.version=20240416%20v7.01%20-%20dual%20tracking: Event property (version: 20240416 v7.01 - dual tracking).
ep.protocol=https%3A: Event property (protocol: HTTPS).
tfd=5151: Unknown parameter.
This URL is related to tracking and analytics for the White House website. The parameters provide information about the user’s environment, session, and the specific page view. 


Step 2: Create a Maven Rest Project

Let's create a Maven rest project.  Its easy!  Follow this tutorial.  Make sure you issue all the commands from /usercode directory - the automated test anticipates that:

https://spring.io/guides/gs/rest-service

Let's run the project and see what we have got here!

Step 3: Run the test bench

It will:

1. cd into the demo directory

2. build your project

3. run it, and

4. make sure the curl endpoint works!