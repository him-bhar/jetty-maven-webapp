package com.himanshu.webapp.context;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class WebApplicationContext {
	private Server jettyServer;
	public void init(Server server) {
		setJettyServer(server);
	}
	
	public void registerContext() {
		context = new WebAppContext(resourceBasePath, contextPath);
		context.setClassLoader(Thread.currentThread().getContextClassLoader());
		jettyServer.addHandler(context);
	}
	
	public void startContext() {
		try {
			context.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopContext() {
		try {
			context.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Server getJettyServer() {
		return jettyServer;
	}
	public void setJettyServer(Server jettyServer) {
		this.jettyServer = jettyServer;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getResourceBasePath() {
		return resourceBasePath;
	}
	public void setResourceBasePath(String resourceBasePath) {
		this.resourceBasePath = resourceBasePath;
	}
	/*public WebAppContext getContext() {
		return context;
	}
	public void setContext(WebAppContext context) {
		this.context = context;
	}*/
	private String contextPath;
	private String resourceBasePath;
	private WebAppContext context;
}
