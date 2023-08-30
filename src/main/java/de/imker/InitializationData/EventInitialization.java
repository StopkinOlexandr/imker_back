package de.imker.InitializationData;

import de.imker.dto.NewEventDto;
import de.imker.models.Event;
import de.imker.repositories.EventsRepository;
import de.imker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EventInitialization {

  private final EventsService eventsService;
  private final EventsRepository eventsRepository;


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


            newEvent = NewEventDto.builder()
                    .title("Imkerei-Kongress: Innovationen und Nachhaltigkeit in der Bienenhaltung")
                    .description("Wir freuen uns, Sie herzlich zum Imkerei-Kongress einzuladen, einer einzigartigen Veranstaltung für Imker und Bienenliebhaber. Der Kongress steht im Zeichen der nachhaltigen Bienenhaltung und des Schutzes der Biodiversität. In einer Zeit, in der Bienen und andere Bestäuber unter Druck stehen, ist es wichtiger denn je, innovative Techniken zu erlernen, um unsere Bienenvölker zu pflegen und unsere Ökosysteme zu schützen.\\n\\nUnsere hochqualifizierten Redner teilen ihre Erkenntnisse über bienenfreundliche Praktiken, integrierte Schädlingskontrolle und den Anbau von bienenfreundlichen Pflanzen. Wir werden auch über die Bedeutung von Pestizidreduzierung und Lebensraumerhaltung für Bienen diskutieren.\\n\\nDer Kongress bietet eine Plattform für Wissensaustausch, Networking und praktische Workshops. Wir werden Bienenstöcke öffnen, um Ihnen praktische Einblicke in die Bienenpflege zu geben. Zudem haben Sie die Möglichkeit, neue Imkerausrüstung, Bienenprodukte und ökologische Lösungen zu erkunden.\\n\\nVerpassen Sie nicht diese Gelegenheit, sich mit anderen Imkern auszutauschen, von Experten zu lernen und sich für den Schutz unserer geschätzten Bestäuber einzusetzen. Melden Sie sich jetzt an und seien Sie Teil dieses inspirierenden Events!")
                    .shortDescription("Seminar: Bienenschutz und Maßnahmen")
                    .address("Umweltzentrum Nachhaltigkeit, Beispielstadt")
                    .author("Umweltschutzverein ")
                    .quantityOfMembers(60)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("96")
                    .startTime("16:30")
                    .endTime("19:00")
                    .dateStart("2023-07-28")
                    .dateEnd("2023-07-31")
                    .build();
            eventsService.addEvent(newEvent);

            newEvent = NewEventDto.builder()
                    .title("Imkerei-Kongress: Innovationen und Nachhaltigkeit in der Bienenhaltung")
                    .description("Entdecken Sie die Kunst der Honigernte und -verarbeitung in unserem interaktiven Workshop. Lernen Sie, wie Sie Ihre Bienenstöcke für die Ernte vorbereiten, Honigrähmchen entnehmen und den Honig schonend schleudern. Anschließend erfahren Sie, wie Sie den gewonnenen Honig richtig lagern und abfüllen können. Bringen Sie Ihre Fragen mit und tauschen Sie sich mit anderen Imkern über bewährte Methoden aus!")
                    .shortDescription("Workshop: Honigernte und -verarbeitung")
                    .address("Imkereizentrum Bienenfreude, Musterstadt")
                    .author("Imkermeister Markus Müller")
                    .quantityOfMembers(70)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("97")
                    .startTime("12:30")
                    .endTime("15:30")
                    .dateStart("2023-09-12")
                    .dateEnd("2023-09-12")
                    .build();
            eventsService.addEvent(newEvent);


     newEvent = NewEventDto.builder()
                    .title("Bienenfreundliche Gartenplanung: Pflanzen für eine blühende Bienenoase")
             .description("Erfahren Sie, wie Sie Ihren Garten in ein Paradies für Bienen und andere Bestäuber verwandeln können. Unsere Experten zeigen Ihnen, welche Pflanzen Sie anbauen sollten, um Nahrung und Lebensraum für Bienen zu schaffen. Lernen Sie bewährte Methoden zur Auswahl, Pflege und Platzierung von bienenfreundlichen Pflanzen kennen. Gemeinsam gestalten wir blühende Oasen für die Natur!")
             .shortDescription("Gartenworkshop: Bienenfreundliche Pflanzen")
             .address("Naturgarten Institut, Beispielstadt")
             .author("Gartenexpertin Lisa Schneider")
             .quantityOfMembers(30)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
             .photo("98")
             .startTime("14:00")
             .endTime("17:00")
             .dateStart("2023-05-05")
             .dateEnd("2023-05-05")
                    .build();

            eventsService.addEvent(newEvent);



            newEvent = NewEventDto.builder()
                    .title("Bienenwachskerzen selbst gemacht: Kreativer Workshop für Jung und Alt")
                    .description("Tauchen Sie ein in die Welt des Bienenwachses und erschaffen Sie Ihre eigenen Bienenwachskerzen. In unserem Workshop lernen Sie verschiedene Techniken zur Kerzenherstellung mit natürlichen Materialien kennen. Bienenwachskerzen sind nicht nur schön anzusehen, sondern verbreiten auch einen angenehmen Duft. Nehmen Sie Ihre selbstgemachten Kerzen mit nach Hause und erleben Sie das besondere Gefühl der eigenen Kreation!")
                    .shortDescription("Kerzenworkshop: Bienenwachskerzen selbst gemacht")
                    .address("Kreativzentrum Sonnenblume, Musterdorf")
                    .author("Künstlerin Maria Müller")
                    .quantityOfMembers(20)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("99")
                    .startTime("13:30")
                    .endTime("16:00")
                    .dateStart("2023-01-05")
                    .dateEnd("2023-01-06")
                    .build();
            eventsService.addEvent(newEvent);




            newEvent = NewEventDto.builder()
                    .title("Bienenkrankheiten und Gesundheitsmanagement: Prävention und Diagnose")
                    .description("Die Gesundheit unserer Bienen ist von größter Bedeutung. In diesem Seminar erfahren Sie alles über die häufigsten Bienenkrankheiten, ihre Symptome und Prävention. Unsere Fachexperten werden Ihnen zeigen, wie Sie Ihre Bienenkolonien regelmäßig auf Gesundheit überprüfen können und welche Maßnahmen im Krankheitsfall zu ergreifen sind. Lernen Sie, die Bienenwelt gesund zu halten und die Auswirkungen von Krankheiten zu minimieren!")
                    .shortDescription("Seminar: Bienenkrankheiten und Gesundheitsmanagement")
                    .address("Bieneninstitut Gesundheit, Beispielstadt")
                    .author("Tierarzt Dr. Hans Weber")
                    .quantityOfMembers(120)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("100")
                    .startTime("09:30")
                    .endTime("16:30")
                    .dateStart("2023-06-25")
                    .dateEnd("2023-06-26")
                    .build();

            eventsService.addEvent(newEvent);




            newEvent = NewEventDto.builder()
                    .title("Bienenforschung und Wissenschaft: Aktuelle Erkenntnisse zur Bienenhaltung")
                    .description("Tauchen Sie ein in die faszinierende Welt der Bienenforschung! In diesem Seminar werden neueste wissenschaftliche Erkenntnisse zur Bienenhaltung und -gesundheit vorgestellt. Erfahren Sie mehr über Verhaltensweisen, Kommunikation und soziale Strukturen von Bienenkolonien. Unsere renommierten Forscher werden auch die Auswirkungen von Umweltfaktoren auf Bienenpopulationen beleuchten. Dieses Seminar ist eine einzigartige Gelegenheit, tiefer in die Biologie unserer summenden Freunde einzutauchen.")
                    .shortDescription("Seminar: Bienenforschung und Wissenschaft")
                    .address("Bienenforschungsinstitut, Musterstadt")
                    .author("Bienenforscherin Dr. Anna Schneider")
                    .quantityOfMembers(30)
                    .location("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2430.1166171018426!2d13.2207348!3d52.4770242!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a859bdeafe589f%3A0xa79c987b6c7854a3!2z0KTQvtGA0YHRgiDQk9GA0YPQvdC10LLQsNC70YzQtA!5e0!3m2!1sru!2sde!4v1692992412612!5m2!1sru!2sde\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>")
                    .photo("101")
                    .startTime("10:00")
                    .endTime("16:00")
                    .dateStart("2023-03-10")
                    .dateEnd("2023-03-10")
                    .build();
            eventsService.addEvent(newEvent);

       }
    }
  }
}
