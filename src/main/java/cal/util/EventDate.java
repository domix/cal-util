package cal.util;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EventDate {
  private Integer month;
  private Integer dayOfMonth;
  private Integer year;
  private Integer hourOfDay;
  private Integer minute;
  private Integer second;
}
