package cal.util.api;

import cal.util.model.Event;
import cal.util.model.EventDate;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

import java.util.GregorianCalendar;
import java.util.Map;

import static java.util.Calendar.*;

@Controller("/v1/calendars")
public class CalController {
  private Map<String, String> calendars;

  public CalController() {
    calendars = Map.of("devops_2019", devops2019());
  }

  @Get("/{id}")
  public HttpResponse<String> foo(String id) {

    if (calendars.containsKey(id)) {
      return HttpResponse.ok(calendars.get(id))
        .contentType("text/calendar;charset=UTF-8");
    }

    return HttpResponse.notFound("");
  }

  public String devops2019() {
    Calendar calendar = new Calendar();
    calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
    calendar.getProperties().add(Version.VERSION_2_0);
    calendar.getProperties().add(CalScale.GREGORIAN);
    calendar.getProperties().add(new Name("Mastering DevOps"));

    Integer year = 2019;
    Integer startHour = 20;
    Integer endHour = 22;
    Integer october = OCTOBER;
    Integer november = NOVEMBER;
    Integer december = DECEMBER;
    String eventName = "Curso Mastering DevOps";
    Integer i = 1;

    //calendar.getComponents().add(christmas);
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 29, october, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 31, october, year, startHour, endHour)));

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 5, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 7, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 11, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 14, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 19, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 21, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 26, november, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 28, november, year, startHour, endHour)));

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 3, december, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 5, december, year, startHour, endHour)));

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 7, december, year, 9, 18)));

    return calendar.toString();
  }


  private Event clase(String eventName, String description, Integer day, Integer month, Integer year, Integer startHour, Integer endHour) {
    EventDate start = EventDate.builder()
      .dayOfMonth(day)
      .month(month)
      .year(year)
      .hourOfDay(startHour)
      .minute(0)
      .second(0)
      .build();

    EventDate end = EventDate.builder()
      .dayOfMonth(day)
      .month(month)
      .year(year)
      .hourOfDay(endHour)
      .minute(0)
      .second(0)
      .build();

    Event event = Event.builder()
      .name(eventName)
      .description(description)
      .start(start)
      .end(end)
      .timezone("America/Mexico_City")
      .build();

    return event;
  }

  public VEvent vEvent(Event event) {
    // Create a TimeZone
    TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
    TimeZone timezone = registry.getTimeZone(event.getTimezone());
    VTimeZone tz = timezone.getVTimeZone();

    java.util.Calendar startDate = createCalendar(timezone, event.getStart());
    java.util.Calendar endDate = createCalendar(timezone, event.getEnd());

    // Create the event
    String eventName = event.getName();
    DateTime start = new DateTime(startDate.getTime());
    DateTime end = new DateTime(endDate.getTime());

    VEvent meeting = new VEvent(start, end, eventName);
    meeting.getProperties().add(new Description(event.getDescription()));
    meeting.getProperties().add(tz.getTimeZoneId());
    UidGenerator ug = new RandomUidGenerator();
    Uid uid = ug.generateUid();
    meeting.getProperties().add(uid);

    return meeting;
  }

  private java.util.Calendar createCalendar(TimeZone timezone, EventDate event) {
    java.util.Calendar calendar = new GregorianCalendar();
    calendar.setTimeZone(timezone);
    calendar.set(MONTH, event.getMonth());
    calendar.set(DAY_OF_MONTH, event.getDayOfMonth());
    calendar.set(YEAR, event.getYear());
    calendar.set(HOUR_OF_DAY, event.getHourOfDay());
    calendar.set(MINUTE, event.getMinute());
    calendar.set(SECOND, event.getSecond());

    return calendar;
  }
}
