package com.himanshu.core.api.test;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.himanshu.app.core.AppCore;

public class AppCoreTest {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Test
	public void test() {
		try {
			File initConfigFile = new File(AppCoreTest.class.getResource("/server-init.file").toURI());
			String parentLocation = initConfigFile.getParentFile().getParentFile().getParentFile().getParent();
			System.setProperty("com.himanshu.webapp1.path", parentLocation+"/webapp-1"+"/src/main/webapp");
			System.setProperty("com.himanshu.webapp2.path", parentLocation+"/webapp-2"+"/src/main/webapp");
			AppCore core = new AppCore();
			core.init();
			core.start();
			try {
				Thread.sleep(60*60*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			core.stop();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
