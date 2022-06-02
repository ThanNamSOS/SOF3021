package SOF3021.utils;

import SOF3021.entities.Account;

public class Auth {
	private static Account user;

	private static final String SALT = "SUGAR";
	private static final String ALGORITHM = "SHA-512";

	public static void clear() {
		user = null;
	}

	public static boolean isLogin() {
		return user != null;
	}

	public static boolean isManager() {
		return isLogin() && user.getAdmin() == 1;
	}

	public static Account getUser() {
		return user;
	}

	public static void setUser(Account user) {
		Auth.user = user;
	}

}
