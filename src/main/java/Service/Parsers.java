package Service;

import Model.Event;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * Parsers class This class will be used to parse the CSV file with default delimiter as comma(,)
 */
public class Parsers {

  /**
   * validateFilePath - to validate the path passed in the arg
   *
   * @param FILE_PATH - Input file path
   * @return - boolean true if valid / false if invalid
   */
  public boolean validateFilePath(String FILE_PATH) {
    try {
      Paths.get(FILE_PATH);
    } catch (Exception ex) {
      return false;
    }
    return true;
  }

  /**
   * @param FILE_PATH - Input file path
   * @return - list of all parsed POJO Objects
   * @throws IOException - InCase if there are any IO exception will be handled by the caller
   */
  public List<Event> parseFile(String FILE_PATH) throws IOException {
    Reader reader;
    if (!validateFilePath(FILE_PATH)) {
      System.out.println("Input file path passed in the argument is Invalid");
      return null;
    }
    List<Event> eventList = new ArrayList<>();
    reader = Files.newBufferedReader(Paths.get(FILE_PATH));
    CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT
        .withHeader("Person Id", "Floor Access DateTime", "Floor Level", "Building")
        .withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
    for (CSVRecord csvRecord : csvParser) {
      Event event = new Event();
      event.setPerson_id(csvRecord.get(0));
      event.setDatetime(csvRecord.get(1));
      event.setFloor_level(Integer.parseInt(csvRecord.get(2)));
      event.setBuilding(csvRecord.get(3));
      eventList.add(event);
    }
    return eventList;
  }

}
