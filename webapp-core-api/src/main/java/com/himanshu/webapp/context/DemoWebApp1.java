package com.himanshu.webapp.context;

import java.io.File;

import org.mortbay.jetty.Server;

public class DemoWebApp1 extends WebApplicationContext {
	
	private String contextPath = "/app1";
	public static String WEB_APP_1_PATH = "com.himanshu.webapp1.path";
	
	public void init(Server server) {
		super.init(server);
		setResourceBasePath(new File(System.getProperty(WEB_APP_1_PATH)).getAbsolutePath());
		setContextPath(contextPath);
		registerContext();
	}

}
