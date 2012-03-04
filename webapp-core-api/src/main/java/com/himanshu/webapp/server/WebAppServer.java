package com.himanshu.webapp.server;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.RequestLog;
import org.mortbay.jetty.Response;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.RequestLogHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.himanshu.webapp.context.DemoWebApp1;
import com.himanshu.webapp.context.DemoWebApp2;

public class WebAppServer {
	private Server jettyServer;
	private int httpPort = 8080;
	private DemoWebApp1 webApp1;
	private DemoWebApp2 webApp2;
	
	Logger LOG = LoggerFactory.getLogger(getClass());
	
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
		RequestLogHandler logHandler = new RequestLogHandler();
		logHandler.setServer(jettyServer);
		logHandler.setRequestLog(new RequestLog() {
			
			@Override
			public void stop() throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void start() throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeLifeCycleListener(Listener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isStopping() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isStopped() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isStarting() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isStarted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRunning() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isFailed() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void addLifeCycleListener(Listener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void log(Request request, Response response) {
				LOG.debug("This is the debug message from request log handler");
				
			}
		});
		jettyServer.addHandler(logHandler);
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
