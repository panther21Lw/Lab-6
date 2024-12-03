import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Цей клас представляє Сервлет для обробки PATCH-запитів.
 * Використовує {@link RequestHandler} з {@link UpdateRequestHandler} для оновлення користувацьких даних.
 */
@WebServlet("/patch")
public class PatchServlet extends HttpServlet {
	
	/**
	 * Це поле представляє обробника запитів {@link RequestHandler} 
	 * із встановленою стратегією для обробки UPDATE-запиту.
	 */
    private final RequestHandler requestHandler = new RequestHandler(new UpdateRequestHandler());

	/** 
	 * Обробляє PATCH-запит через делегування обробки до {@link RequestHandler}.
	 *
	 * @param req HTTP-запит
	 * @param resp HTTP-відповідь
	 * @throws ServletException у разі виникнення помилок сервлета
	 * @throws IOException у разі виникнення помилок вводу/виводу
	 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestHandler.handleRequest(req, resp);
    }
}
