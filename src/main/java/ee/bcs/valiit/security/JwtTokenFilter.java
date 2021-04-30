package ee.bcs.valiit.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtTokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest) servletRequest);
        if (token != null) {
            Authentication authentication = validateToken(token); //vali õige import peale alumist osa
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String resolveToken(HttpServletRequest request) {
        String headerAttribute = request.getHeader("Authorization");
        if (headerAttribute == null) {
            return null;
        }
        if (headerAttribute.startsWith("Bearer")) {
            return headerAttribute.substring(7);
        }
        return headerAttribute;
    }

    private Authentication validateToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("c2vjcmV0").parseClaimsJws(token).getBody(); //tee parool tokeniks base64 encode'ga; peab olema sama, mis controlleris
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE USER"));
        UserDetails userDetails = new User((String) claims.get("username"), "", grantedAuthorityList); //see peab olema ka controlleris claimitud
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


}
