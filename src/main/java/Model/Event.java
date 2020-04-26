package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Event class floor access events with the properties
 */
@JsonPropertyOrder({"person_id", "datetime", "floor_level", "building"})

public class Event {

  @JsonProperty("person_id")
  String person_id;
  @JsonProperty("datetime")
  String datetime;
  @JsonProperty("floor_level")
  Integer floor_level;
  @JsonProperty("building")
  String building;

  @JsonProperty("person_id")
  public void setPerson_id(String person_id) {
    this.person_id = person_id;
  }

  @JsonProperty("datetime")
  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  @JsonProperty("floor_level")
  public void setFloor_level(Integer floor_level) {
    this.floor_level = floor_level;
  }

  @JsonProperty("building")
  public void setBuilding(String building) {
    this.building = building;
  }

  @Override
  public String toString() {
    String sb;
    sb = "Event{" + "person_id='" + person_id + '\''
        + ", datetime='" + datetime + '\''
        + ", floor_level=" + floor_level
        + ", building='" + building + '\''
        + '}';
    return sb;
  }
}
