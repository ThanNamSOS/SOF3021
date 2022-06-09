package SOF3021.intorceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import SOF3021.entities.Account;

@Component
public class AdminInerceptor implements HandlerInterceptor  {
	@Override
	public boolean preHandle (HttpServletRequest req, HttpServletResponse res, Object handler) throws IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("acc");
		if (acc.getAdmin() != 1) {
			session.setAttribute("error", "* Tài khoản phải là Admin");
			res.sendRedirect(req.getContextPath() + "/home");
			return false;
		}
		return true;
	}
}
