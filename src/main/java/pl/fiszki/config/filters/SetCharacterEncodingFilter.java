package pl.fiszki.config.filters;

import org.apache.log4j.Logger;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Bartek on 05.06.2017.
 */
public class SetCharacterEncodingFilter implements Filter {
    private static final Logger log = Logger.getLogger( CharacterEncodingFilter.class.getName() );

    private boolean isConnectorConfigured = false;

    public void init( FilterConfig filterConfig ) throws ServletException {}

    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
        request.setCharacterEncoding( "utf-8" );
        response.setCharacterEncoding( "utf-8" );
        if( ! isConnectorConfigured ) {
            isConnectorConfigured = true;
            try { //I need to do all of this with reflection, because I get NoClassDefErrors otherwise. --jsb
                Field f = request.getClass().getDeclaredField( "request" ); //Tomcat wraps the real request in a facade, need to get it
                f.setAccessible( true );
                Object req = f.get( request );
                Object connector = req.getClass().getMethod( "getConnector", new Class[0] ).invoke( req ); //Now get the connector
                connector.getClass().getMethod( "setUseBodyEncodingForURI", new Class[] {boolean.class} ).invoke( connector, Boolean.TRUE );
            } catch( NoSuchFieldException e ) {
                log.warn("Servlet container does not seem to be Tomcat, cannot programatically alter character encoding. Do this in the Server.xml <Connector> attribute instead." );
            } catch( Exception e ) {
                log.warn("Could not setUseBodyEncodingForURI to true on connector" );
            }
        }
        chain.doFilter( request, response );
    }

    public void destroy() {}

}
