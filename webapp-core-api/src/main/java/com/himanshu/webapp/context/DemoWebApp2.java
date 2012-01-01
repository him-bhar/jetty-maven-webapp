package com.himanshu.webapp.context;

import java.io.File;

import org.mortbay.jetty.Server;

public class DemoWebApp2 extends WebApplicationContext {
	
	private String contextPath = "/app2";
	public static String WEB_APP_2_PATH = "com.himanshu.webapp2.path";

	@Override
	public void init(Server server) {
		super.init(server);
		setResourceBasePath(new File(System.getProperty(WEB_APP_2_PATH)).getAbsolutePath());
		setContextPath(contextPath);
		registerContext();
	}

}
