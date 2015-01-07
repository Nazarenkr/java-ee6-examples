/*
 *  Zemian Deng 2014
 */

package zemian.servlet3example.service;

import java.io.File;

/**
 * A singleton application context space to store global variables and states.
 * 
 * @author zedeng
 */
public class Application {
    public static final String SERVLET_CONTEXT_KEY = "zemian.servlet3example.web.Application";
    
    private static Application INSTANCE = new Application();
    
    private UserService userService = new UserService();
    
    private Application() {
    }
    
    public static Application getInstance() {
        return INSTANCE;
    }
    
    public void init() {
        String userHome = System.getProperty("user.home");
        File userFile = new File(userHome + "/java-ee-example/servlet3example-users.properties");
        if (userFile.exists()) {
            userService.loadFromFile(userFile);
        } else {
            userService.loadFromResource("/zemian/servlet3example/service/users.properties");
        }
    }
    
    public void destroy() {        
    }

    public UserService getUserService() {
        return userService;
    }   
}