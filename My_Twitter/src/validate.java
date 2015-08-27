

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.TwitterUser;

/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		 EntityTransaction trans = em.getTransaction();
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		if(password!=null && username!=null)
		{
			String q="SELECT c FROM TwitterUser c WHERE c.name = '"+username+"'";
			TypedQuery<TwitterUser>bq =em.createQuery(q,TwitterUser.class);
			List<TwitterUser> list=bq.getResultList();
			String pass=null;
			for(TwitterUser temp:list)
			pass=temp.getPassword();
		
			if(pass==null)
			{
				getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
			else
				getServletContext().getRequestDispatcher("/addcomment.html").forward(request, response);
		}
		else
		{
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		 em.close();
	}
		 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
