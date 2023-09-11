package de.imker.InitializationData;

import de.imker.models.AboutUs;
import de.imker.repositories.AboutUsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AboutUsInitialisation {

  @Autowired
  private final AboutUsRepository aboutUsRepository;

  public void aboutUsInit() {
    List<AboutUs> aboutUsList = aboutUsRepository.findAll();

    if (aboutUsList.size() == 0) {
      AboutUs newAboutUs = AboutUs.builder()
          .titleTop("Imkerverein: Mission, Ziele und Aufgaben")
          .descriptionTop("<p>Ein Imkerverein ist eine bedeutende Vereinigung, die Imker unterschiedlichen Erfahrungsniveaus vereint und sich f&uuml;r die F&ouml;rderung der Imkerei sowie den Schutz und die Erhaltung von Bienen einsetzt. In dieser Artikel werden wir einen n&auml;heren Blick auf die Mission, die Ziele und die Aufgaben eines Imkervereins werfen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h4>Die Mission eines Imkervereins:</h4>\n" +
              "<p>Die Mission eines Imkervereins besteht darin, eine Gemeinschaft von Imkern zu schaffen, die sich gegenseitig unterst&uuml;tzt, Wissen teilt und zur F&ouml;rderung und Erhaltung der Imkerei beitr&auml;gt. Der Verein verfolgt das Ziel, das Bewusstsein f&uuml;r die Bedeutung der Bienenhaltung und des Bienenschutzes zu sch&auml;rfen und die Interessen der Imker in der Gesellschaft zu vertreten.</p>\n")
          .titleBottom("Ziele eines Imkervereins: ")
          .descriptionBottom("<p> - Bildung und Schulung: Ein Hauptziel des Imkervereins ist die Bereitstellung von Bildung und Schulung f&uuml;r Imker auf allen Ebenen. Dies umfasst Workshops, Seminare, Kurse und Informationsveranstaltungen, bei denen Mitglieder ihre Kenntnisse &uuml;ber Bienenhaltung, Bienenverhalten, Krankheitspr&auml;vention und Honiggewinnung vertiefen k&ouml;nnen.<br> -  Bienengesundheit und -schutz: Der Verein setzt sich f&uuml;r den Schutz der Bienen und die F&ouml;rderung ihrer Gesundheit ein. Dies beinhaltet die Vermittlung bew&auml;hrter Praktiken zur Bienenpflege, die Sensibilisierung f&uuml;r die Bedrohungen der Bienenpopulationen und die Unterst&uuml;tzung von Forschungsprojekten zur Bienenkrankheit.<br> - F&ouml;rderung nachhaltiger Praktiken: Im Imkerverein steht die F&ouml;rderung nachhaltiger Imkereipraktiken im Vordergrund. Dies umfasst die Anwendung umweltfreundlicher Methoden, die Erhaltung nat&uuml;rlicher Lebensr&auml;ume f&uuml;r Bienen und die F&ouml;rderung der Best&auml;ubung von Pflanzen.<br> -  Gemeinschaft und Austausch: Ein weiteres Ziel des Vereins ist es, eine starke Gemeinschaft von Imkern aufzubauen, die Erfahrungen und Ratschl&auml;ge austauschen k&ouml;nnen. Durch regelm&auml;&szlig;ige Treffen, Veranstaltungen und Diskussionsforen wird der Austausch von Informationen gef&ouml;rdert. </p>\n" +
              "\n" +
              "<br/><br/>\n" +
              "<p><h4>Aufgaben eines Imkervereins:</h4></p>\n" +
              "<p><br/>- Organisation von Veranstaltungen: Der Verein organisiert Workshops, Schulungen, Vortr&auml;ge und Veranstaltungen, um Mitgliedern eine Plattform zum Lernen, Austauschen und Vernetzen zu bieten.<br>- Forschungsf&ouml;rderung: Ein Imkerverein kann Forschungsprojekte zur Bienenkrankheit, zur Bienen&ouml;kologie und zur Verbesserung der Bienenhaltung unterst&uuml;tzen und f&ouml;rdern.<br>- &Ouml;ffentlichkeitsarbeit: Der Verein f&ouml;rdert die &ouml;ffentliche Wahrnehmung der Bedeutung von Bienen und Imkerei durch Bildungsprogramme, Bienenfestivals und Informationsveranstaltungen.<br>- Unterst&uuml;tzung von Anf&auml;ngern: Der Verein bietet Unterst&uuml;tzung und Ressourcen f&uuml;r Anf&auml;nger im Bereich der Imkerei, um ihnen den Einstieg zu erleichtern. </p>\n")
          .image1("154")
          .image2("155")
          .build();
      aboutUsRepository.save(newAboutUs);
    }
  }
}


