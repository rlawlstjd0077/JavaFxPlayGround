package table.pure.domain;

import java.time.ZonedDateTime;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class TableDataWithProperty {
  private StringProperty id;
  private ObjectProperty<ZonedDateTime> dateTime;
  private StringProperty content;
  private BooleanProperty isButtonVisible;

  public TableDataWithProperty(StringProperty id, ObjectProperty<ZonedDateTime> dateTime, StringProperty content, BooleanProperty isButtonVisible) {
    this.id = id;
    this.dateTime = dateTime;
    this.content = content;
    this.isButtonVisible = isButtonVisible;
  }

  public TableDataWithProperty(String id, ZonedDateTime dateTime, String content, boolean isButtonVisible) {
    this.id.set(id);
    this.dateTime.set(dateTime);
    this.content.set(content);
    this.isButtonVisible.set(isButtonVisible);
  }

  public StringProperty idProperty() {
    return id;
  }

  public ObjectProperty<ZonedDateTime> dateTimeProperty() {
    return dateTime;
  }


  public StringProperty contentProperty() {
    return content;
  }

  public BooleanProperty isButtonVisibleProperty() {
    return isButtonVisible;
  }
}
