/**   
 * 
 * @author Feng.Guo
 * @date Aug 26, 2014 5:38:22 PM 
 * @version V1.0   
 */

package com.tjcloud.platform.utils;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * From http://www.baeldung.com/2012/04/16/how-to-use-resttemplate-with-basic-authentication-in-spring-3-1/
 * 
 * <p>
 * And with that, everything is in place – the {@link RestTemplate} will now be able to support the Basic Authentication scheme; a simple usage pattern would be:
 * 
 * <pre>
 * final AuthHttpComponentsClientHttpRequestFactory requestFactory = new AuthHttpComponentsClientHttpRequestFactory(httpClient, host, userName, password);
 * final RestTemplate restTemplate = new RestTemplate(requestFactory);
 * </pre>
 * 
 * And the request:
 *
 * <pre>
 * restTemplate.get(&quot;http://localhost:8080/spring-security-rest-template/api/foos/1&quot;, Foo.class);
 * </pre>
 * 
 * @author anton
 */
public class AuthHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

	protected HttpHost host;

	protected String userName;

	protected String password;

	public AuthHttpComponentsClientHttpRequestFactory(HttpHost host) {
		this(host, null, null);
	}

	public AuthHttpComponentsClientHttpRequestFactory(HttpHost host, String userName, String password) {
		super();
		this.host = host;
		this.userName = userName;
		this.password = password;
	}

	public AuthHttpComponentsClientHttpRequestFactory(HttpClient httpClient, HttpHost host) {
		this(httpClient, host, null, null);
	}

	public AuthHttpComponentsClientHttpRequestFactory(HttpClient httpClient, HttpHost host, String userName, String password) {
		super(httpClient);
		this.host = host;
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
		// Create AuthCache instance
		AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(host, basicAuth);

		// Add AuthCache to the execution context
		HttpClientContext localcontext = HttpClientContext.create();
		localcontext.setAuthCache(authCache);

		if (userName != null) {
			BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(userName, password));
			localcontext.setCredentialsProvider(credsProvider);
		}
		return localcontext;
	}

}
