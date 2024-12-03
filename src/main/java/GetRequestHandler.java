import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Цей клас представляє конктретну реалізацію інтерфейсу {@link HandleStrategy}.
 * Цей клас обробляє GET запит, повертаючи сторінку з написом "Hello!" та кнопкою, щоб повернутися до index.html
 */
public class GetRequestHandler implements HandleStrategy{
	
	/**
	 * Цей метод обробляє GET HTTP-запит.
	 * Цей метод повертає сторінку з написом "Hello!" та кнопкою, що повертає до index.html
	 *
	 * @param request HTTP-запит {@link HttpServletRequest}
	 * @param response HTTP-відповідь {@link HttpServletResponse}
	 * @throws IOException у разі виникнення помилки вводу/виводу
	 */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.getWriter().write("<p>------------------Hello!-------------------</p>");
        response.getWriter().write("<button onclick=\"location.href='index.html'\">Back to Home</button>");
    }
}
