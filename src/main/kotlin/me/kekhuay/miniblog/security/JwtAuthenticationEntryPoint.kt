package me.kekhuay.miniblog.security

import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        LOGGER.error("Responding with unauthorized error. Message - {}", authException.message)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.message)
    }
}
