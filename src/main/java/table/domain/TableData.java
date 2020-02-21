package table.domain;

import java.time.ZonedDateTime;

public class TableData {
  private String id;
  private ZonedDateTime dateTime;
  private String content;
  private boolean isButtonVisible;

  public TableData(String id, ZonedDateTime dateTime, String content, boolean isButtonVisible) {
    this.id = id;
    this.dateTime = dateTime;
    this.content = content;
    this.isButtonVisible = isButtonVisible;
  }

  public String getId() {
    return id;
  }

  public ZonedDateTime getDateTime() {
    return dateTime;
  }

  public String getContent() {
    return content;
  }

  public boolean isButtonVisible() {
    return isButtonVisible;
  }
}
