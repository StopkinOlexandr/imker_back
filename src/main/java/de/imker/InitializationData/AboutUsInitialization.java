//package de.imker.InitializationData;
//
//import de.imker.dto.AboutUsDto;
//import de.imker.repositories.AboutUsRepository;
//import de.imker.services.impl.AboutUsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class AboutUsInitialization {
//  private final AboutUsServiceImpl aboutUsService;
//  private final AboutUsRepository aboutUsRepository;
//
//  @Autowired
//  public AboutUsInitialization(AboutUsRepository aboutUsRepository) {
//    this.aboutUsService = new AboutUsServiceImpl(aboutUsRepository);
//    this.aboutUsRepository = aboutUsRepository;
//  }
//
//  public void aboutUsInit() {
//
//      AboutUsDto newPost = NewAboutUsDto.builder()
//          .titleTop("Imkerverein: Mission, Ziele und Aufgaben")
//          .descriptionTop("<div className=\"mb-3\">\n" +
//              "          <p className={styles.about_text}><h4>Imkerverein: Mission, Ziele und Aufgaben</h4>\n" +
//              "            <br />\n" +
//              "            Ein Imkerverein ist eine bedeutende Vereinigung, die Imker unterschiedlichen Erfahrungsniveaus\n" +
//              "            vereint und sich für die Förderung der Imkerei sowie den Schutz und die Erhaltung von Bienen einsetzt.\n" +
//              "            In dieser Artikel werden wir einen näheren Blick auf die Mission,\n" +
//              "            die Ziele und die Aufgaben eines Imkervereins werfen.\n" +
//              "          </p>\n" +
//              "          <br />\n" +
//              "          <p className={styles.about_text}><h4>Die Mission eines Imkervereins:</h4><br />\n" +
//              "            Die Mission eines Imkervereins besteht darin, eine Gemeinschaft von Imkern zu schaffen,\n" +
//              "            die sich gegenseitig unterstützt, Wissen teilt und zur Förderung und Erhaltung der\n" +
//              "            Imkerei beiträgt. Der Verein verfolgt das Ziel, das Bewusstsein für die Bedeutung der\n" +
//              "            Bienenhaltung und des Bienenschutzes zu schärfen und die Interessen der Imker in der\n" +
//              "            Gesellschaft zu vertreten.\n" +
//              "          </p>\n" +
//              "        </div>")
//          .titleBottom("Ziele eines Imkervereins: ")
//          .descriptionBottom(" <div>\n" +
//              "          <p className={styles.about_text + \" mb-3\"}>\n" +
//              "            <br />1.\tBildung und Schulung: Ein Hauptziel des Imkervereins ist die Bereitstellung von Bildung und Schulung für Imker auf allen Ebenen. Dies umfasst Workshops, Seminare, Kurse und Informationsveranstaltungen, bei denen Mitglieder ihre Kenntnisse über Bienenhaltung, Bienenverhalten, Krankheitsprävention und Honiggewinnung vertiefen können.\n" +
//              "            <br />2.\tBienengesundheit und -schutz: Der Verein setzt sich für den Schutz der Bienen und die Förderung ihrer Gesundheit ein. Dies beinhaltet die Vermittlung bewährter Praktiken zur Bienenpflege, die Sensibilisierung für die Bedrohungen der Bienenpopulationen und die Unterstützung von Forschungsprojekten zur Bienenkrankheit.\n" +
//              "            <br />3.\tFörderung nachhaltiger Praktiken: Im Imkerverein steht die Förderung nachhaltiger Imkereipraktiken im Vordergrund. Dies umfasst die Anwendung umweltfreundlicher Methoden, die Erhaltung natürlicher Lebensräume für Bienen und die Förderung der Bestäubung von Pflanzen.\n" +
//              "            <br />4.\tGemeinschaft und Austausch: Ein weiteres Ziel des Vereins ist es, eine starke Gemeinschaft von Imkern aufzubauen, die Erfahrungen und Ratschläge austauschen können. Durch regelmäßige Treffen, Veranstaltungen und Diskussionsforen wird der Austausch von Informationen gefördert.\n" +
//              "          </p>\n" +
//              "          <p className={styles.about_text + \" mb-3\"}><h4>Aufgaben eines Imkervereins:</h4>\n" +
//              "            <br />1.\tOrganisation von Veranstaltungen: Der Verein organisiert Workshops, Schulungen, Vorträge und Veranstaltungen, um Mitgliedern eine Plattform zum Lernen, Austauschen und Vernetzen zu bieten.\n" +
//              "            <br />2.\tForschungsförderung: Ein Imkerverein kann Forschungsprojekte zur Bienenkrankheit, zur Bienenökologie und zur Verbesserung der Bienenhaltung unterstützen und fördern.\n" +
//              "            <br />3.\tÖffentlichkeitsarbeit: Der Verein fördert die öffentliche Wahrnehmung der Bedeutung von Bienen und Imkerei durch Bildungsprogramme, Bienenfestivals und Informationsveranstaltungen.\n" +
//              "            <br />4.\tUnterstützung von Anfängern: Der Verein bietet Unterstützung und Ressourcen für Anfänger im Bereich der Imkerei, um ihnen den Einstieg zu erleichtern.\n" +
//              "          </p>\n" +
//              "        </div>")
//          .image1("156")
//          .image2("157");
//      aboutUsService.addAboutUs(newAboutUs);
//}
//
//
