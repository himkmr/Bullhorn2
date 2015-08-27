

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.My_Twitter;



/**
 * Servlet implementation class AddMyComments
 */
@WebServlet("/AddMyComments")
public class AddMyComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String message="";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		message="";
		EntityManager em = model.DBUtil.getEmFactory().createEntityManager();
		try {
			String comments =request.getParameter("comments");
			String username =request.getParameter("username");
			
	
			model.My_Twitter user = new model.My_Twitter();
			
			user.setComments(comments);
			user.setName(username);
			model.DBUtil.insert(user);
			

			String q="select t from My_Twitter t order by t.id desc";

			TypedQuery<My_Twitter>bq =em.createQuery(q,My_Twitter.class);

			List<My_Twitter> list=bq.getResultList();

			for(My_Twitter temp:list)

			message+=temp.getComments()+" By "+temp.getName()+"<br>";

			request.setAttribute("message", message);

		 getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
