package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Louis on 25/02/2017.
 */
public abstract class Controleur extends HttpServlet {
    protected static final long serialVersionUID = 1L;
    protected static final String ACTION_TYPE = "action";
    protected static final String ERROR_KEY = "messageErreur";
    protected static final String ERROR_PAGE = "/erreur.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        requestHandler(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        requestHandler(request, response);
    }

    protected abstract String dispatcher(HttpServletRequest request);

    protected String error(HttpServletRequest request){
        String actionName = request.getParameter(ACTION_TYPE);
        String errorMessage = "[" + actionName + "] n'est pas une action valide.";
        request.setAttribute(ERROR_KEY, errorMessage);
        return ERROR_PAGE;
    }

    protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destinationPage;
        // Dispatch
        destinationPage = dispatcher(request);
        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);

    }

}
