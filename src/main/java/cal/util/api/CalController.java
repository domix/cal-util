package cal.util.api;

import cal.util.model.Event;
import cal.util.model.EventDate;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.Map;

import static java.util.Calendar.*;
import static net.fortuna.ical4j.model.Property.TZID;

@Controller("/v1/calendars")
public class CalController {
  private Map<String, String> calendars;

  public CalController() {
    calendars = Map.of("devops_2019", devops2019(), "cursos2020", cursos2020());
  }

  @Get("/{id}")
  public HttpResponse<String> foo(String id) {

    if (calendars.containsKey(id)) {
      return HttpResponse.ok(calendars.get(id))
          .contentType("text/calendar;charset=UTF-8");
    }

    return HttpResponse.notFound("");
  }

  public String cursos2020() {
    Calendar calendar = createCalendar("Cursos 2020");
    Integer year = 2020;
    Integer startHour = 9;
    Integer endHour = 18;

    String eventName;
    Integer i;

    eventName = "Jenkins (HSBC)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 18, FEBRUARY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 19, FEBRUARY, year, startHour, endHour)));


    eventName = "Arquitectura Moderna (Grupo Modelo)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 24, FEBRUARY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 25, FEBRUARY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 26, FEBRUARY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 27, FEBRUARY, year, startHour, endHour)));

    eventName = "Curso Microservicios (Buró de Crédito - Grupo 1)";
    i = 1;

    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 13, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 14, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 15, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 16, APRIL, year, startHour, endHour)));

    eventName = "Curso Contenedores (Buró de Crédito - Grupo 1)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 20, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 21, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 22, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 23, APRIL, year, startHour, endHour)));


    eventName = "Curso Microservicios (Buró de Crédito - Grupo 2)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 11, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 12, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 13, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 14, MAY, year, startHour, endHour)));

    eventName = "Curso Contenedores (Buró de Crédito - Grupo 2)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 18, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 19, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 20, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 21, MAY, year, startHour, endHour)));


    eventName = "Desarrollo de Microservicios Cloud Native (Abierto)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 25, APRIL, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 2, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 9, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 16, MAY, year, startHour, endHour)));

    eventName = "Docker containers y Orquestación con Kubernetes (Abierto)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 30, MAY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 6, JUNE, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 13, JUNE, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 20, JUNE, year, startHour, endHour)));

    eventName = "Mastering DevOps (Abierto)";
    i = 1;
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 11, JULY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 18, JULY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 25, JULY, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "Clase " + i++, 1, AUGUST, year, startHour, endHour)));

    return calendar.toString();
  }

  public String devops2019() {
    Calendar calendar = createCalendar("Mastering DevOps");

    Integer year = 2019;
    Integer startHour = 20;
    Integer endHour = 22;
    String eventName = "Curso Mastering DevOps";
    int i = 1;

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 29, OCTOBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 31, OCTOBER, year, startHour, endHour)));

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 5, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 7, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 11, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 14, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 19, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 21, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 26, NOVEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 28, NOVEMBER, year, startHour, endHour)));

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 3, DECEMBER, year, startHour, endHour)));
    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 5, DECEMBER, year, startHour, endHour)));

    calendar.getComponents().add(vEvent(clase(eventName, "La clase " + i++, 7, DECEMBER, year, 9, 18)));

    return calendar.toString();
  }

  private Calendar createCalendar(String nombreCurso) {
    Calendar calendar = new Calendar();
    calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
    calendar.getProperties().add(Version.VERSION_2_0);
    calendar.getProperties().add(CalScale.GREGORIAN);
    calendar.getProperties().add(new Name(nombreCurso));
    return calendar;
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

    final var startDate = createCalendar(timezone, event.getStart());
    final var endDate = createCalendar(timezone, event.getEnd());

    // Create the event
    String eventName = event.getName();

    final var start = convertToLocalDateTimeViaInstant(startDate.getTime());
    final var end = convertToLocalDateTimeViaInstant(endDate.getTime());
    final var property = tz.getProperty(TZID).orElse(null);

    VEvent meeting = new VEvent(start, end, eventName);
    meeting.getProperties().add(new Description(event.getDescription()));
    meeting.getProperties().add(property);
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

  public LocalDateTime convertToLocalDateTimeViaInstant(java.util.Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
  }
}
