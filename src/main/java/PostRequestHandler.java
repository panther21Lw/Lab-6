import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Цей клас реалізує інтерфейс {@link HandleStrategy} та обробляє POST-запити.
 * Зберігає дані з форми (firstName, lastName) та перенаправляє їх на JSP-сторінку.
 */
public class PostRequestHandler implements HandleStrategy{
	
	/**
	 * Обробляє POST-запит, отримуючи дані з форми та перенаправляє їх на JSP-сторінку.
	 * 
	 * @param request HTTP-запит із параметрами firstName та lastName
	 * @param response HTTP-відповідь
	 * @throws IOException у разі виникнення помилок вводу/виводу.
	 */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);

        System.out.println(request.getParameter("firstName"));
        System.out.println(lastName);
        //response.sendRedirect("/display?firstName=" + firstName + "&lastName=" + lastName);
        try {
            request.getRequestDispatcher("response2post.jsp").forward(request, response);
        } catch (ServletException se){
            System.out.println("Something went wrong\n\n\n");
            se.printStackTrace();
            System.out.println("endoferror");
        }
    }
}
