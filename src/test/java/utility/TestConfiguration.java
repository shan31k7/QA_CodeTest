package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConfiguration {
	public static Logger logger = Logger.getLogger(TestConfiguration.class.getName());
	public static Properties environmentProperties, contentRepo;
	static final String ENVIRONMENT_PROPERTIES_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/EnvironmentVariables.properties";
	static final String CONTENT_REPO_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/ContentRepository.properties";

	public TestConfiguration() {
	}

	public static void setConfiguration() {

		try {
			// Load the Environment variables
			environmentProperties = new Properties();
			environmentProperties.load(new FileReader(new File(ENVIRONMENT_PROPERTIES_PATH)));

			// Load content Repository
			contentRepo = new Properties();
			contentRepo.load(new FileReader(new File(CONTENT_REPO_PATH)));
		} catch (FileNotFoundException f) {
			logger.log(Level.SEVERE, "Problem occured while reading the properties files");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "\"Something went wrong\"");
		}

	}

}
