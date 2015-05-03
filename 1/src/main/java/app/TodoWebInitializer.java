package app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 

public class TodoWebInitializer implements WebApplicationInitializer {
    
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerDispatcherServlet(servletContext);
    }
 
    private void registerDispatcherServlet(ServletContext servletContext) {
        WebApplicationContext springContext = createContext(SpringContextConfiguration.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);
        ServletRegistration.Dynamic dispatcher = servletContext.
                                      addServlet("dispatcherServlet", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.s");
    }
 
    private WebApplicationContext createContext(Class<?>... contextClasses) {
        AnnotationConfigWebApplicationContext springContext = 
                                            new AnnotationConfigWebApplicationContext();
        springContext.register(contextClasses);
        return springContext;
    }
}