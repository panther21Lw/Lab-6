import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/** 
 * Цей клас представляє Сервлет для обробки запитів авторизації.
 * Підтримує методи GET, POST, PATCH, DELETE.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * Це поле представляє обробника запитів {@link RequestHandler} 
	 * із встановленою стратегією null.
	 */
    private final RequestHandler requestHandler = new RequestHandler(null);

	/**
	 * Обробляє GET-запит, повертаючи HTML-відповідь із привітанням.
	 * 
	 * @param req HTTP-запит
	 * @param resp HTTP-відповідь
	 * @throws ServletException у разі виникнення помилок сервлета
	 * @throws IOException у разі виникнення помилок вводу/виводу
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestHandler.setStrategy(new GetRequestHandler());
        requestHandler.handleRequest(req, resp);
    }

	/** 
	 * Обробляє POST-запит передаючи обробку до {@link PostRequestHandler}.
	 *
	 * @param request HTTP-запит
	 * @param response HTTP-відповідь
	 * @throws ServletException у разі виникнення помилок сервлета
	 * @throws IOException у разі виникнення помилок вводу/виводу
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        requestHandler.setStrategy(new PostRequestHandler());
        requestHandler.handleRequest(request, response);
    }
	
	/** 
	 * Обробляє PATCH-запит передаючи обробку до {@link PatchRequestHandler}.
	 *
	 * @param request HTTP-запит
	 * @param response HTTP-відповідь
	 * @throws ServletException у разі виникнення помилок сервлета
	 * @throws IOException у разі виникнення помилок вводу/виводу
	 */
    protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        requestHandler.setStrategy(new UpdateRequestHandler());
        requestHandler.handleRequest(request, response);
    }

	/** 
	 * Обробляє DELETE-запит передаючи обробку до {@link DeleteRequestHandler}.
	 *
	 * @param request HTTP-запит
	 * @param response HTTP-відповідь
	 * @throws ServletException у разі виникнення помилок сервлета
	 * @throws IOException у разі виникнення помилок вводу/виводу
	 */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestHandler.setStrategy(new DeleteRequestHandler());
        requestHandler.handleRequest(request, response);
    }
}
