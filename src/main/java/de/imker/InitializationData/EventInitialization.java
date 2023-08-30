package de.imker.InitializationData;

import de.imker.dto.NewEventDto;
import de.imker.models.Event;
import de.imker.repositories.EventsRepository;

import de.imker.repositories.UsersOnEventsRepository;
import de.imker.services.impl.EventsServiceImpl;
import liquibase.license.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventInitialization {
    private final EventsServiceImpl eventsService;
    private final EventsRepository eventsRepository;


    @Autowired
    public EventInitialization(EventsRepository eventsRepository) {
        this.eventsService = new EventsServiceImpl(eventsRepository, null,null);
        this.eventsRepository = eventsRepository;
    }

    public void eventInit() {
        List<Event> events = eventsRepository.findAll();
        if (events.isEmpty()) {
            NewEventDto newEvent = NewEventDto.builder()
                    .title("Imkertreffen 2023: Erfahrungsaustausch und Fortbildungen")
                    .description("Wir laden alle Imker herzlich zu unserem Imkertreffen ein, bei dem wir uns über unsere Erfahrungen austauschen und Fortbildungen zu modernen Bienenhaltungstechniken anbieten werden.")
                    .shortDescription("Imkertreffen mit Erfahrungsaustausch und Fortbildungen")
                    .address("Imkerhof Musterstraße 123, Beispielstadt")
                    .author("Imkerverein Beispielstadt")
                    .quantityOfMembers(10)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("91")
                    .startTime("09:00")
                    .endTime("17:00")
                    .dateStart("2023-10-02")
                    .dateEnd("2023-10-03")
                    .build();
            eventsService.addEvent(newEvent);


            newEvent = NewEventDto.builder()

                    .title("Honigfest 2023: Feiern, Lernen und Honig verkosten")
                    .description("Herzlich willkommen auf unserem Honigfest! Genießen Sie ein Tag voller Feierlichkeiten, Lernmöglichkeiten rund um die Imkerei und kosten Sie verschiedene Honigsorten.")
                    .shortDescription("Honigfest: Feiern, Lernen und Verkostung")
                    .address("Bienenhof Sonnenschein, Musterstadt")
                    .author("Imkergemeinschaft Musterstadt")
                    .quantityOfMembers(20)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("92")
                    .startTime("10:00")
                    .endTime("18:00")
                    .dateStart("2023-11-15")
                    .dateEnd("2023-11-16")
                    .build();
            eventsService.addEvent(newEvent);


            newEvent = NewEventDto.builder()
                    .title("Fortgeschrittenes Bienenmanagement: Praktische Tipps und Tricks")
                    .description("Unser Workshop bietet fortgeschrittenen Imkern praktische Einblicke in effizientes Bienenmanagement. Erfahren Sie Tipps und Tricks aus erster Hand von erfahrenen Imkern.")
                    .shortDescription("Workshop: Fortgeschrittenes Bienenmanagement")
                    .address("Schulungsraum Bienenwissen, Beispielstadt")
                    .author("Bienenwissen Akademie")
                    .quantityOfMembers(30)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("93")
                    .startTime("13:00")
                    .endTime("18:00")
                    .dateStart("2023-10-10")
                    .dateEnd("2023-10-11")
                    .build();
            eventsService.addEvent(newEvent);

            newEvent = NewEventDto.builder()
                    .title("Jahrestreffen der Imkerzunft: Erfahrungen teilen und Netzwerken")
                    .description("Unser Jahrestreffen bietet Imkern eine großartige Gelegenheit, Erfahrungen auszutauschen, neue Kontakte zu knüpfen und voneinander zu lernen.")
                    .shortDescription("Jahrestreffen: Erfahrungen teilen und Netzwerken")
                    .address("Gasthaus Bienenfreude, Musterstadt")
                    .author("Imkerzunft Musterstadt")
                    .quantityOfMembers(40)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("94")
                    .startTime("14:00")
                    .endTime("20:00")
                    .dateStart("2023-11-20")
                    .dateEnd("2023-11-22")
                    .build();
            eventsService.addEvent(newEvent);

            newEvent = NewEventDto.builder()
                    .title("Bienenschutz-Seminar: Bedeutung und Maßnahmen")
                    .description("Erfahren Sie in unserem Seminar mehr über den Schutz der Bienen und die Maßnahmen, die wir ergreifen können, um ihre Lebensräume zu bewahren.")
                    .shortDescription("Seminar: Bienenschutz und Maßnahmen")
                    .address("Umweltzentrum Nachhaltigkeit, Beispielstadt")
                    .author("Umweltschutzverein Beispielstadt")
                    .quantityOfMembers(50)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("95")
                    .startTime("16:30")
                    .endTime("19:00")
                    .dateStart("2023-12-28")
                    .dateEnd("2023-12-31")
                    .build();
            eventsService.addEvent(newEvent);

        }
    }
}
