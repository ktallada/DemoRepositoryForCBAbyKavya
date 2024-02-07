package localUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PAULocalPropertiesFileReader {
    public PAULocalPropertiesFileReader() {
    }

    public static Properties getRepaymentCalculatorProperties() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("resources/RepaymentCalculator.properties"));
        } catch (Exception var2) {
        }

        return properties;
    }

    public static Properties getPAUProperties() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("resources/PAU.properties"));
        } catch (Exception var2) {
        }

        return properties;
    }
}
