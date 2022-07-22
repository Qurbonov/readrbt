package uz.atm.config.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.atm.dto.auth.JwtDTO;
import uz.atm.utils.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Author: Khonimov Ulugbek
 * Date: 06/07/22
 * Time: 10:47
 */
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader("Authorization");
        if (Optional.ofNullable(header).isPresent() && header.startsWith("Bearer ")) {
            try {
                final String token = header.split(" ")[1].trim();
                JwtDTO jwtDTO = JwtUtil.decode(token);
                String username = jwtDTO.username;
                String role = jwtDTO.role;
                List<SimpleGrantedAuthority> roleList = Collections.singletonList(new SimpleGrantedAuthority(role));

                UsernamePasswordAuthenticationToken
                        authentication = new UsernamePasswordAuthenticationToken(username,
                        null, roleList);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (RuntimeException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else filterChain.doFilter(request, response);
    }
}
