

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
 * Servlet implementation class ViewComments
 */
@WebServlet("/ViewComments")
public class ViewComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		EntityManager em = model.DBUtil.getEmFactory().createEntityManager();
		try {


			String q="select t from My_Twitter t order by t.id desc";

			TypedQuery<My_Twitter>bq =em.createQuery(q,My_Twitter.class);

			List<My_Twitter> list=bq.getResultList();
			message+="<table class=\"table table-hover\"><tr><td><b>User Name </td><td><b>Comments</td></tr>";
			for(My_Twitter temp:list)
			message+="<td>"+temp.getComments()+"</td><td>"+temp.getName()+"</td></tr>";
		
			message+="</table>";
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
		// TODO Auto-generated method stub
	}

}
