import Model.Event;
import Service.JSONWriter;
import Service.Parsers;
import java.util.List;

/**
 * CSV Parser is a main class which reads CSV file and writes into a JSON file
 */
public class CSVParsers {

  public static void main(String[] args) {
    Parsers parser = new Parsers();
    JSONWriter jsonWriter = new JSONWriter();
    try {
      List<Event> eventList = null;
      eventList = parser.parseFile(args[0]);
      if (eventList == null || eventList.isEmpty()) {
        System.out.println("CSV Parser failed, please pass the file path argument");
        return;
      }
      jsonWriter.writeJSONFile(eventList);
      System.out.println("CSV Parser completed it execution successfully");
    } catch (Exception ioException) {
      System.out.println("CSV Parser failed while executing, find the exception below");
      System.out.println(ioException.getMessage());
    }
  }
}
