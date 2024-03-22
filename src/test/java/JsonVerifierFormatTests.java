import static org.junit.jupiter.api.Assertions.assertFalse;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.remitly.FileReader;
import com.remitly.JsonVerifier;

public class JsonVerifierFormatTests {
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @Test
    public void givenJsonWithNoPolicyNameField_expectFalse() {
        String fileName = "noPolicyName.json";
        JSONObject jsonObject = FileReader.readJSONFromFile(RESOURCES_PATH + fileName);

        assertFalse(JsonVerifier.verifyFormat(jsonObject));
    }

    @Test
    public void givenJsonWithNoPolicyDocumentField_expectFalse() {
        String fileName = "noPolicyDocument.json";
        JSONObject jsonObject = FileReader.readJSONFromFile(RESOURCES_PATH + fileName);

        assertFalse(JsonVerifier.verifyFormat(jsonObject));
    }
}
