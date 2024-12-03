import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Цей клас реалізує {@link HandleStrategy} для оновлення даних користувача через параметри запиту.
 * Оновлєю ім'я користувача.
 */
public class UpdateRequestHandler implements HandleStrategy{
	/**
	 * Це поле містить ім'я коритсувача за замовчуванням.
	 */
    private static String userName = "Default User";

	/**
	 * Обробляє запит на оновлення імені користувача.
	 * 
	 * @param request HTTP-запит із параметром newName
	 * @param response HTTP-відповідь із підтвердженням оновлення.
	 * @throws IOException у разі виникнення помилок вводу/виводу.
	 */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newName = request.getParameter("newName");
        userName = newName;
        response.getWriter().write("Updated name to: " + userName);
    }
}
