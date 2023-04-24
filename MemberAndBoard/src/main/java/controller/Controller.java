package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import handler.DefaultHandler;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    private Map<String, handler.CommandHandler> handlerMap = new HashMap<String, CommandHandler>();
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String configFile = config.getInitParameter("configFile");
    	String path = config.getServletContext().getRealPath("/");
    	path = path + "/" + configFile;
    	FileInputStream fis = null;
    	Properties prop = new Properties();
    	
    	try {
			fis = new FileInputStream(path);
			prop.load(fis);
			Iterator<Object> keys = prop.keySet().iterator();
			while(keys.hasNext()) {
				String key = (String)keys.next();
				String handleName = prop.getProperty(key);
				Class<?> handlerClass = Class.forName(handleName);
				CommandHandler handler = (CommandHandler) handlerClass.getDeclaredConstructor().newInstance();
				handlerMap.put(key, handler);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String command = request.getRequestURI();
    	if(command.indexOf(request.getContextPath()) == 0) {
    		command = command.substring(request.getContextPath().length());
    	}
    	CommandHandler handler = handlerMap.get(command);
    	if(handler == null) {
    		handler = new DefaultHandler();
    	}
    	String viewPage = null;
    	try {
			viewPage = handler.process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    	dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
