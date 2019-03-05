package util;

import java.io.File;

public class ConstantPath {

	public static final String CHROME_EXE_PATH = System.getProperty("user.dir") + File.separator + "Resources"
			+ File.separator + "chromedriver.exe";
	public static final String CHROME_MAC_PATH = System.getProperty("user.dir") + File.separator + "resources"
			+ File.separator + "chromedriver-mac";
	public static final String FIREFOX_EXE_PATH = System.getProperty("user.dir") + File.separator + "Resources"
			+ File.separator + "geckodriver.exe";
	public static final String IE_EXE_PATH = System.getProperty("user.dir") + File.separator + "Resources"
			+ File.separator + "IEDriverServer.exe";

}
