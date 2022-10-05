
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

/**
 *
 * @author mhamed
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String)request.getAttribute("username");
        String password = (String)request.getAttribute("password");
        String validity = "invalid";
        
        
        if (username == null || username.equals("") || password == null || password.equals("")){
            String message = "Must Enter a Username and Password";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else{
            AccountService user = new AccountService();
            validity = user.login(username, password);
        }
        
        if (validity.equals("valid")){
            session.setAttribute("username", username);
            response.sendRedirect("home");
        }
        
        
        
    }
}
