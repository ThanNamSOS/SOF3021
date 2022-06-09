package SOF3021.intorceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticateInterceptor  implements HandlerInterceptor {
	@Override
	public boolean preHandle (HttpServletRequest req, HttpServletResponse res, Object handler) throws IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("acc") == null) {
			session.setAttribute("messages", "Vui lòng đăng nhập");
			res.sendRedirect(req.getContextPath() + "/login");
			return false;
		}
		return true;
	}
}
