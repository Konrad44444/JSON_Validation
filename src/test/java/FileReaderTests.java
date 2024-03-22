import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.remitly.FileReader;
import com.remitly.exceptions.IncorrectPathException;
import com.remitly.exceptions.InvalidJsonFileException;

public class FileReaderTests {
    @Test
    public void givenIncorrectPath_expectIncorrectPathException() {
        assertThrows(IncorrectPathException.class, () -> FileReader.readJSONFromFile("\\abc"));
    }

    @Test
    public void givenInvalidJsonFile_expectInvalidFileException() {
        assertThrows(InvalidJsonFileException.class,
                () -> FileReader.readJSONFromFile("src\\test\\resources\\invalidFile.txt"));
    }

    @Test
    public void givenCorrectPath_expectJsonObject() {
        JSONObject jsonObject = FileReader.readJSONFromFile("src\\test\\resources\\example.json");

        assertNotNull(jsonObject);
    }

    @Test
    public void givenValidJsonFile_expectCorrectJsonObject() {
        JSONObject jsonObject = FileReader.readJSONFromFile("src\\test\\resources\\validJsonFile.json");

        assertNotNull(jsonObject);
    }

    @Test
    public void givenValidTxtFile_expectCorrectJsonObject() {
        JSONObject jsonObject = FileReader.readJSONFromFile("src\\test\\resources\\validTxtFile.txt");

        assertNotNull(jsonObject);
    }
}
