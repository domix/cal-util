package cal.util.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UCalendar {
  private String name;
  private List<Event> events;
}
