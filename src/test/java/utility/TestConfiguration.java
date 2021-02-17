package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class TestConfiguration {
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
			System.out.println("Problem occured while reading the properties files");
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}

}
