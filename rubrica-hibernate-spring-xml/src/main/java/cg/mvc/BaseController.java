package cg.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseController {

	protected UserDetails getUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null)
			return null;
		Authentication authentication = context.getAuthentication();
		if (authentication == null)
			return null;
		Object principal = authentication.getPrincipal();
		if (principal == null)
			return null;

		if (principal instanceof UserDetails) {
			UserDetails ud = (UserDetails) principal;
			return ud;
		}
		return null;
	}

}
