import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Інтерфейс стратегії обробки запитів.
 * Визначає метод для обробки HTTP-запитів.
*/
 
public interface HandleStrategy {
	/**
	 * Метод для обробки HTTP-запиту.
	 *
	 * @param request HTTP-запит
	 * @param response HTTP-відповідь
	 * @throws IOException у разі виникнення помилок вводу/виводу
	 */
    void handle(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
