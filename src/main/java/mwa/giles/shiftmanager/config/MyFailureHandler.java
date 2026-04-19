package mwa.giles.shiftmanager.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException{
        String errorCode;

        if (exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException){
            errorCode = "bad_credentials";
        }else {
            errorCode = "unknown_error";
        }

        getRedirectStrategy().sendRedirect(request, response, "login?error=" + errorCode);
    }
}
