package data;
import traitement.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.*;
import java.io.*;

/**
 * Servlet implementation class DataServlet
 */
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSON json = new JSON();
		String jsonData = "";
		try {
			jsonData = json.getAllProducts();
		}
		catch(JSONException e) {
			e.printStackTrace();
		}

	    // Set content type and encoding
		response.setHeader("Access-Control-Allow-Origin", "*"); // Allow requests from this origin
        response.setHeader("Access-Control-Allow-Methods", "GET");  // Allow GET method
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");  // Allow specific headers (optional)
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    // Write the String JSON to the response
	    PrintWriter writer = response.getWriter();
	    writer.write(jsonData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
