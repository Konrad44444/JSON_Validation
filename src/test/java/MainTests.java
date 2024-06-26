import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import com.remitly.Main;

public class MainTests {
    public static final String SUCCESS_STRING = "True - there is no single asterisk in Resource field";
    public static final String FAIL_STRING = "False - there is single asterisk in Resource field";
    public static final String INCORRECT_PATH_EXCEPTION_MESSAGE = "Cannot find file - check path";
    public static final String INVALID_JSON_FILE_EXCEPTION_MESSAGE = "File is not a valid JSON file";
    public static final String INVALID_JSON_FORMAT_STRING = "Format of JSON file is not a AWS::IAM::Role Policy";
    public static final String PROMPT_STRING = "Type in path to the JSON file: (ex. C:\\Users\\konra\\Desktop\\json_validation\\src\\test\\resources\\example.json)";

    @Test
    public void givenCorrectPathToValidJson_expectSuccessString() throws IOException {
        String path = "src\\test\\resources\\validResourceField.json";

        ByteArrayInputStream testIn = new ByteArrayInputStream(path.getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setIn(testIn);
        System.setOut(out);

        Main.main(null);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());

        assertTrue(consoleOutput.contains(SUCCESS_STRING));

        out.close();
    }

    @Test
    public void givenCorrectPathToValidJson_expectFailString() throws IOException {
        String path = "src\\test\\resources\\jsonWithSingleAsteriskInResourceField.json";

        ByteArrayInputStream testIn = new ByteArrayInputStream(path.getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setIn(testIn);
        System.setOut(out);

        Main.main(null);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());

        assertTrue(consoleOutput.contains(FAIL_STRING));

        out.close();
    }

    @Test
    public void givenIncorrectPath_expectIcorrectPathExceptionMessage() {
        String path = "src\\test\\resources\\fileDoesNotExists.json";

        ByteArrayInputStream testIn = new ByteArrayInputStream(path.getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setIn(testIn);
        System.setOut(out);

        Main.main(null);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());

        assertTrue(consoleOutput.contains(INCORRECT_PATH_EXCEPTION_MESSAGE));

        out.close();
    }

    @Test
    public void givenInvalidJsonFilePath_expectInvalidJsonFileExceptionMessage() {
        String path = "src\\test\\resources\\invalidFile.txt";

        ByteArrayInputStream testIn = new ByteArrayInputStream(path.getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setIn(testIn);
        System.setOut(out);

        Main.main(null);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());

        assertTrue(consoleOutput.contains(INVALID_JSON_FILE_EXCEPTION_MESSAGE));

        out.close();
    }

    @Test
    public void givenInvalidJsonFormat_expectInvalidJsonFormatString() {
        String path = "src\\test\\resources\\emptyPolicyName.json";

        ByteArrayInputStream testIn = new ByteArrayInputStream(path.getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setIn(testIn);
        System.setOut(out);

        Main.main(null);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());

        assertTrue(consoleOutput.contains(INVALID_JSON_FORMAT_STRING));

        out.close();
    }

    @Test
    public void givenMainRun_expectPromptString() {
        String path = "foo";

        ByteArrayInputStream testIn = new ByteArrayInputStream(path.getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        System.setIn(testIn);
        System.setOut(out);

        Main.main(null);

        String consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset());

        assertTrue(consoleOutput.contains(PROMPT_STRING));

        out.close();
    }
}
