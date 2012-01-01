package com.himanshu.app.core;

import com.himanshu.webapp.server.WebAppServer;

public class AppCore {
	WebAppServer server;
	public void init() {
		server = new WebAppServer();
		server.init();
	}
	
	public void start() {
		server.start();
	}
	
	public void stop() {
		server.stop();
	}
}
