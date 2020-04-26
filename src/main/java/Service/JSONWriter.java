package Service;

import Model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * JSONWriter class Used to write to a JSON file and file name is hardcoded to test.json
 */
public class JSONWriter {

  /**
   * @param eventList - list of event objects
   * @throws IOException - in case if there are any IO exception, caller will handle it
   */
  public void writeJSONFile(List<Event> eventList) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    String OUT_FILE_PATH = "./test.json";
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUT_FILE_PATH));
    mapper.writeValue(bufferedWriter, eventList);
  }
}
