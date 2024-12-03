import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Цей клас реалізує інтерфейс {@link HandleStrategy}.
 * Видаляє всю інформацію про користувача.
 */
public class DeleteRequestHandler implements HandleStrategy{
	
	/**
	 * Обробляє DELETE-запит, повертаючи HTML-відповідь із підтвердженням видалення.
	 *
	 * @param request HTTP-запит
	 * @param response HTTP-відповідь із HTML-вмістом.
	 * @throws IOException у разі виникнення помилки вводу/виводу.
	 */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write("<p>All user information has been deleted.</p>");
        response.getWriter().write("<button onclick=\"location.href='index.html'\">Back to Home</button>");
    }
}
