package com.himanshu.webapp.server;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;

import com.himanshu.webapp.context.DemoWebApp1;
import com.himanshu.webapp.context.DemoWebApp2;

public class WebAppServer {
	private Server jettyServer;
	private int httpPort = 8080;
	private DemoWebApp1 webApp1;
	private DemoWebApp2 webApp2;
	
	public void init() {
		jettyServer = new Server();
		initConnector();
		initWebAppContexts();
	}

	private void initWebAppContexts() {
		webApp1 = new DemoWebApp1();
		webApp2 = new DemoWebApp2();
		webApp1.init(jettyServer);
		webApp2.init(jettyServer);
	}

	private void initConnector() {
		Connector connector = new SelectChannelConnector();
		connector.setPort(httpPort);
		jettyServer.addConnector(connector);
	}
	
	public void start() {
		try {
			jettyServer.start();
			webApp1.startContext();
			webApp2.startContext();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop() {
		try {
			jettyServer.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
