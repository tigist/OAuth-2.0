<h2> OAuth2.0 for google API</h2>

https://github.com/tigist/OAuth-2.0/wiki
 
<h3>Client side application</h3>
You can get the brief summary of the client side OAuth 2 on <a href ="https://github.com/tigist/OAuth-2.0/wiki/Client-side-Authentication"> wiki</a>

Download the <a href ="https://github.com/tigist/OAuth-2.0">JavaScript </a>file for implemented <a href="http://netsolet.heliohost.org/">sample</a>

Run it in your local server approach and run the html files using Firefox browser.

<h4>Library used</h4>
* AngualrJS
* Jquery

<h3> Server Side application</h3>

You can get the brief summary of the server side OAuth 2 on <a href ="https://github.com/tigist/OAuth-2.0/wiki/Server-side-authentication"> wiki </a>

Download the Java file for implemented <a href = "http://my-test-auth2.appspot.com/">sample demo</a> which retrieve the access token and user profile. 

Server side demo implementation is made based on simple HTTP request as described on <a href = "https://github.com/wjosdejong/httputil">HttpUtil</a>.
Authentication and authorization flow to grant access for Google API is as shown on <a href ="https://github.com/tigist/OAuth-2.0/blob/master/JavaCode/src/test/Auth.java"> code</a>

<h4> To use the sample java code requirements </h4>

-- Create App engine account <a href = "https://accounts.google.com/ServiceLogin?service=ah&passive=true&continue=https://appengine.google.com/_ah/conflogin%3Fcontinue%3Dhttps://appengine.google.com/&ltmpl=ae"> create account</a>

-- Deploy your application on google app engine

-- Use the URL as a redirect-Uri in your code.

-- Register the redirect-Uri of your application on the Google API console

-- Configure web.XML to uniform URL-pattern




