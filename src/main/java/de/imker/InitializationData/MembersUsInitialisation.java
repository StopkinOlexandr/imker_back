package de.imker.InitializationData;

import de.imker.models.AboutUs;
import de.imker.models.Member;
import de.imker.repositories.AboutUsRepository;
import de.imker.repositories.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MembersUsInitialisation {

  @Autowired
  private final MembersRepository membersRepository;

  public void MemberInit() {
    List<Member> memberList = membersRepository.findAll();

    if (memberList.size() == 0) {
      Member newMember = Member.builder()
          .state(Member.State.SHOW)
          .name("Maik Jäger")
          .position("1 Vorsitzender")
          .description("Er st ein herausragender Imker, der die höchste Position in einem Imkerverband oder einer Imkervereinigung innehat. Als 1 Vorsitzender leitet er die Organisation, koordiniert die Arbeit der Imker und fördert die Entwicklung der Bienenzucht in Deutschland.")
          .image("153")
          .phone("+49 5162901266")
          .facebook("https://www.facebook.com/")
          .instagram("https://www.instagram.com/")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      membersRepository.save(newMember);
    }
    if (memberList.size() == 0) {
      Member newMember = Member.builder()
          .state(Member.State.SHOW)
          .name("Peter Förster")
          .position("2 Vorsitzender")
          .description("Ein erfahrener Imker kümmert sich liebevoll um seine Bienen und trägt dazu bei, die Bestäubung von Pflanzen zu fördern. Seine Leidenschaft für die Bienenzucht ist unermüdlich und sein Wissen ist von unschätzbarem Wert für die Natur und die Landwirtschaft.")
          .image("152")
          .phone("+ 49 ")
          .facebook("https://www.facebook.com/")
          .instagram("https://www.instagram.com/")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      membersRepository.save(newMember);
    }
    if (memberList.size() == 0) {
      Member newMember = Member.builder()
          .state(Member.State.SHOW)
          .name("Vanessa Arndt")
          .position("Kassenwartin")
          .description("Die Kassenwartin ist eine engagierte Imkerin, die für die finanziellen Angelegenheiten eines Imkervereins verantwortlich ist. Sie sorgt für eine solide Haushaltsführung und gewährleistet die finanzielle Stabilität der Imkergemeinschaft.")
          .image("157")
          .phone("+ 49 ")
          .facebook("https://www.facebook.com/")
          .instagram("https://www.instagram.com/")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      membersRepository.save(newMember);
    }
    if (memberList.size() == 0) {
      Member newMember = Member.builder()
          .state(Member.State.SHOW)
          .name("Bärbel Grube")
          .position("Schriftführer")
          .description("Die Schriftführerin ist eine engagierte Imkerin, die für die Dokumentation und Aufzeichnung der Aktivitäten eines Imkervereins verantwortlich ist. Sie führt Protokolle, verwaltet die Korrespondenz und trägt zur organisatorischen Effizienz des Vereins bei.")
          .image("151")
          .phone("+ 49 ")
          .facebook("https://www.facebook.com/")
          .instagram("https://www.instagram.com/")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      membersRepository.save(newMember);
    }
    if (memberList.size() == 0) {
      Member newMember = Member.builder()
          .state(Member.State.SHOW)
          .name("Heinz Timrott")
          .position("Wanderwart")
          .description("Bereich Südkreis /außer Stadtgebiet und Gemeinden von Walsrode und Bomlitz/ Im Kleinen Felde 8,29693 Ahlden. Der Wanderwart ist ein erfahrener Imker, der für die Organisation von Bienenwanderungen und den Transport von Bienenvölkern verantwortlich ist. ")
          .image("156")
          .phone("+ 49 ")
          .facebook("https://www.facebook.com/")
          .instagram("https://www.instagram.com/")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      membersRepository.save(newMember);
    }
    if (memberList.size() == 0) {
      Member newMember = Member.builder()
          .state(Member.State.SHOW)
          .name("Web - Admin")
          .position("Administrator")
          .description("Unser Administrator sorgt dafür, dass die Website der Imker gepflegt und " +
              "aktualisiert wird, um sicherzustellen, dass die Imker stets Zugriff auf aktuelle Informationen und Ressourcen haben. Ihm liegt die Bequemlichkeit der Informationsvermittlung an unsere Leser am Herzen.")
          .image("158")
          .phone("+ 49 ")
          .facebook("https://www.facebook.com/")
          .instagram("https://www.instagram.com/")
          .email("Imkerverein-Ahlden@t-online.de")
          .build();
      membersRepository.save(newMember);
    }
  }
}


