import static org.junit.jupiter.api.Assertions.assertThrows;

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
                () -> FileReader.readJSONFromFile("src\\main\\resources\\invalidFile.txt"));
    }
}
