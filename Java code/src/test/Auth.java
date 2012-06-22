/**
 * Test OAuth 2.0 with Google API
 *  Used libraries:
 *     jackson-annotations-2.0.0.jar
 *     jackson-core-2.0.0.jar
 *     jackson-databind-2.0.0.jar
 * 
 * Documentation:
 *     https://developers.google.com/accounts/docs/OAuth2WebServer
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.almende.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("serial")
public class Auth extends HttpServlet {
	// Specify the correct client id and secret for web applications
	// Create them at the Google API console: https://code.google.com/apis/console/
	 String CLIENT_ID = "850250253136.apps.googleusercontent.com";
	 String CLIENT_SECRET = "mv4ckQIrlVJJNE1x3Uq0w6G4";
	 String access_token="";
	 String redirect_uri = "http://localhost:8888/test1";
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		 	PrintWriter out = resp.getWriter();
		 	resp.setContentType("text/html");
		 	out.print(
			"<html><head>" +
			"<title>Authorization demo</title>" +
			"</head><body>"
			
		);
		 	
		if (req.getParameter("code")!=null){
		//Second step, exchange code with access token	
			String code = req.getParameter("code");
			String url = "https://accounts.google.com/o/oauth2/token";
			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("code", code);
			params1.put("client_id", CLIENT_ID);
			params1.put("client_secret", CLIENT_SECRET);
			params1.put("redirect_uri", redirect_uri);
			params1.put("grant_type", "authorization_code");
			String res = HttpUtil.postForm(url, params1); // post url and params
			out.println("<pre>");out.println(); out.println();
			out.println("Authorization code exchanged for access token:");
			out.println(); out.println();out.println("</pre>");
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode json = mapper.readValue(res, ObjectNode.class);
			if (json.has("access_token")) {
			//storing the access token for latter use
				access_token = json.get("access_token").asText().toString();
			}
			out.println();
			out.println("<pre>");
			out.println("Authorization code exchanged for access token:");
			out.println(res); 
			out.println();	out.println();
			
		// Third step: use the access token to call a Google API
			Cookie tokenCookie = new Cookie("access_token", access_token);
			resp.addCookie(tokenCookie);
			String url2  = "https://www.googleapis.com/oauth2/v1/userinfo";
			Map<String, String> headers2 = new HashMap<String, String>();
			headers2.put("Authorization", "Bearer " + access_token);
			String info = HttpUtil.get(url2, headers2);//info is a url returned
			out.println("<pre>");
			out.println();
			out.println("Retrieved user information is:");
			out.println(info);
			out.println("</pre>");
	
			} 
					
			else 	{
				
		  // First step: user must grant access
			String space = " ";
			String scope = "https://www.googleapis.com/auth/calendar" + space +
			"https://www.googleapis.com/auth/userinfo.profile" + space +
			"https://www.googleapis.com/auth/calendar";
			String url = "https://accounts.google.com/o/oauth2/auth";
			Map<String, String> params = new HashMap<String, String>();
			params.put("scope", scope);
			params.put("state", "profile");
			params.put("redirect_uri", redirect_uri);
			params.put("response_type", "code");
			params.put("access_type", "online");
			params.put("client_id", CLIENT_ID);
			params.put("approval_prompt", "force");
			String fullUrl = HttpUtil.appendQueryParams(url, params); //information captured
			out.println("<pre>");
			out.println();
			out.print("Click here to <a href=\" " + fullUrl + "\">Authorize</a> access to your google acount");
			out.println("</pre>");
			out.print( 
			"</body>" +
			"</html>");
		}
	 } 
}

