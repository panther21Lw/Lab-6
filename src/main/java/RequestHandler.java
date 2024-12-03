import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Цей клас представляє учасника Контекст шаблону стратегії.
 * Він має посилання на інтерфейс Стратегії {@link HandleStrategy} і використовує його для виконання конкретних алгоритмів.
 * Цей клас містить метод для встановлення конкретної стратегії обробки запиту {setStrategy(HandleStrategy)} 
 * та метод для виконання обробки запиту {handleRequest}.
 */ 
public class RequestHandler {
	/**
	 * Це поле містить поточну стратегію обробки запиту.
	 */
    private HandleStrategy handleStrategy;

	/**
	 * Конструктор класу.
	 * 
	 * @param handle Початкова стратегія обробки запитів.
	 */
    public RequestHandler(HandleStrategy handle){
        this.handleStrategy = handle;
    }

	/**
	 * Змінює поточну стратегію обробки запитів.
	 *
	 * @param handleStrategy Нова стратегія обробки запитів.
	 */
    public void setStrategy(HandleStrategy handleStrategy){
        this.handleStrategy = handleStrategy;
    }

	/**
	 * Виконує обробку запиту, використовуючи поточну стратегію.
	 *
	 * @param request HTTP-запит
	 * @param response HTTP-відповідь
	 * @throws IOException у разі виникнення помилки вводу/виводу
	 */
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (handleStrategy != null) {
            handleStrategy.handle(request, response);
        }
    }
}
