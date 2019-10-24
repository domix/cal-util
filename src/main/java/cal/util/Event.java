package cal.util;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Event {
  private EventDate start;
  private EventDate end;
  private String name;
  private String description;
  private String timezone;
}
