<h2> OAuth2.0 for google API</h2>

Overview documentation  https://github.com/tigist/OAuth-2.0/wiki
 
<h3>Client side application</h3>

Brief summary of client side OAuth2.0 <a href ="https://github.com/tigist/OAuth-2.0/wiki/Client-side-Authentication"> wiki</a>

Download the JavaScript sources code of client side OAuth2.0 based application which allows you to create event
and retrieve calendar event from your google calendar.  <a href="http://netsolet.heliohost.org/">sample demo</a>

Copy it in the root directory and run the html files using Firefox browser. 

Library used
* AngualrJS
* Jquery

<h3> Server Side application</h3>

Brief summary of server side OAuth2.0 <a href ="https://github.com/tigist/OAuth-2.0/wiki/Server-side-authentication"> wiki </a>

Download the Java file for server side OAuth2.0 based application. The application retrieve the authorization information and your profile.
<a href = "http://my-test-auth2.appspot.com/">sample demo</a>  

Server side demo implementation is made based on simple HTTP request as described on <a href = "https://github.com/wjosdejong/httputil">HttpUtil</a>.
Authentication and authorization flow to grant access for Google API is as shown on <a href ="https://github.com/tigist/OAuth-2.0/blob/master/JavaCode/src/test/Auth.java"> code</a>

<h4> To use the sample java code requirements </h4>

-- Create App engine account <a href = "https://accounts.google.com/ServiceLogin?service=ah&passive=true&continue=https://appengine.google.com/_ah/conflogin%3Fcontinue%3Dhttps://appengine.google.com/&ltmpl=ae"> create account</a>

-- Create App Engine web application

-- Deploy your application on google app engine

-- Use the URL as a redirect-Uri

-- Register the redirect-Uri of your application on the Google <a href = "https://developers.google.com/google-apps/calendar/firstapp#register">API console</a>

-- Configure web.XML to uniform URL-pattern




