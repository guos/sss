package another;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public final class ResponseFilter extends OncePerRequestFilter {



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);

		chain.doFilter(request, responseWrapper);

		String responseContent = new String(responseWrapper.getDataStream());

		System.out.println(responseContent);
		// convert json to baseobject
		response.getOutputStream().write(responseWrapper.getDataStream());

	}
}
