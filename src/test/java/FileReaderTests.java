import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.remitly.FileReader;
import com.remitly.exceptions.IncorrectPathException;
import com.remitly.exceptions.InvalidJsonFileException;

public class FileReaderTests {
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @Test
    public void givenIncorrectPath_expectIncorrectPathException() {
        assertThrows(IncorrectPathException.class, () -> FileReader.readJSONFromFile("\\abc"));
    }

    @Test
    public void givenInvalidJsonFile_expectInvalidFileException() {
        String fileName = "invalidFile.txt";

        assertThrows(InvalidJsonFileException.class,
                () -> FileReader.readJSONFromFile(RESOURCES_PATH + fileName));
    }

    @Test
    public void givenCorrectPath_expectJsonObject() {
        String fileName = "example.json";

        JSONObject jsonObject = FileReader.readJSONFromFile(RESOURCES_PATH + fileName);

        assertNotNull(jsonObject);
    }

    @Test
    public void givenValidJsonFile_expectCorrectJsonObject() {
        String fileName = "validJsonFile.json";

        JSONObject jsonObject = FileReader.readJSONFromFile(RESOURCES_PATH + fileName);

        assertNotNull(jsonObject);
    }

    @Test
    public void givenValidTxtFile_expectCorrectJsonObject() {
        String fileName = "validTxtFile.txt";

        JSONObject jsonObject = FileReader.readJSONFromFile(RESOURCES_PATH + fileName);

        assertNotNull(jsonObject);
    }
}
