package de.imker.InitializationData;

import de.imker.dto.*;
import de.imker.models.Post;
import de.imker.repositories.PostsRepository;
import de.imker.services.FilesService;
import de.imker.services.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostsInitialization {
  private final PostServiceImpl postService;
  private final PostsRepository postsRepository;
  private final FilesService filesService;


  @Autowired
  public PostsInitialization(PostsRepository postsRepository, FilesService filesService) {
    this.postService = new PostServiceImpl(postsRepository, filesService);
    this.postsRepository = postsRepository;
    this.filesService = filesService;
  }

  public void postInit() {
    List<Post> posts = postsRepository.findAll();
    if (posts.size() == 0) {
      NewPostDto newPost = NewPostDto.builder()
          .titlePost("Zauber der Bienen: Einblick in die faszinierende Welt des Imkerns")
          .linkToImg("1")
          .shortPostDescription("Tauche ein in die lebhafte Welt der Bienen, erfahre, wie Imker ihr Handwerk pflegen und die Bedeutung der Bienen für unsere Umwelt.")
          .textOfPost("<h3 style=\"text-align: center;\"><strong>Die faszinierende Welt der Imkerei</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Die Imkerei ist weit mehr als nur Honigproduktion. Sie ist ein Zusammenspiel von Natur, Kunst und Engagement. Imker &ouml;ffnen uns das Tor zu einem faszinierenden Mikrokosmos, in dem Bienen emsig arbeiten.</p>\n" +
              "<p><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://img.welt.de/img/wirtschaft/mobile189946675/9782503547-ci102l-w1024/Extreme-close-up-of-honey-bee-apis-mellifera.jpg\" width=\"396\" height=\"387\"></p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Warum Imkerei so wichtig ist</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Bienen sind wahre &Ouml;kosystem-Architekten. Sie best&auml;uben zahlreiche Pflanzen, die einen Gro&szlig;teil unserer Nahrung ausmachen. Erfahre, wie Imker dazu beitragen, die Artenvielfalt zu erhalten und die Umwelt zu sch&uuml;tzen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Das Leben im Bienenstock</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Ein Blick in den Bienenstock ist wie eine Reise in eine hochorganisierte Gesellschaft. Entdecke die Aufgaben der Bienenk&ouml;nigin, Arbeiterinnen und Drohnen und wie sie zusammenarbeiten, um den Stock am Laufen zu halten.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Vom Anf&auml;nger zum Meisterimker</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Erfahre, wie Imker ihre Leidenschaft entdecken und ihr Wissen von Generation zu Generation weitergeben. Mit moderner Technologie und traditionellen Techniken bewahren sie das Erbe der Imkerei.</p>\n" +
              "<p style=\"text-align: center;\">&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Herausforderungen und Belohnungen</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Die Imkerei steht vor Herausforderungen wie Bienensterben und Umweltver&auml;nderungen. Trotzdem bringt sie unz&auml;hlige Belohnungen mit sich, von k&ouml;stlichem Honig bis hin zu einem tieferen Verst&auml;ndnis der Natur.</p>\n" +
              "<p style=\"text-align: center;\">&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Imkervereine: Gemeinschaft und Wissen</strong></h3>\n" +
              "<p style=\"text-align: center;\"><strong><img src=\"https://taz.de/picture/6316233/948/19-MEK-BuzzingSlovenia-Ljubljana-1.jpeg\"></strong></p>\n" +
              "<p>&nbsp; &nbsp;In Imkervereinen teilen Enthusiasten ihre Erfahrungen, lernen voneinander und tragen zur Forschung bei. Hier treffen Anf&auml;nger auf erfahrene Imker, und jeder kann seinen Beitrag leisten.</p>\n" +
              "<p style=\"text-align: center;\">&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Fazit: Die s&uuml;&szlig;e Welt der Imkerei entdecken</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Die Imkerei &ouml;ffnet eine T&uuml;r zu einem erstaunlichen &Ouml;kosystem. Sie lehrt uns, die Natur zu sch&auml;tzen und zu sch&uuml;tzen. Wenn du den Zauber der Bienen erleben m&ouml;chtest, ist die Imkerei genau das Richtige f&uuml;r dich.</p>")
          .authorName("Jack Daniel")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Bienen: Die kleinen Helden unserer Natur")
          .linkToImg("2")
          .shortPostDescription("Eine Reise in die bemerkenswerte Welt der Bienen - ihre Rolle in der Natur, die Kunst des Imkerns und wie wir sie unterstützen können.")
          .textOfPost("<h3 style=\"text-align: center;\">&nbsp;</h3>\n" +
              "<h3 style=\"text-align: center;\"><strong>Die flei&szlig;igen Best&auml;uber unserer Welt</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Bienen sind weit mehr als nur Honigproduzenten. Sie sind unerm&uuml;dliche Best&auml;uber, die unsere Lebensmittelvielfalt erm&ouml;glichen. Erfahre, wie ihre Arbeit unser t&auml;gliches Leben beeinflusst.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Die Kunst des Imkerns: mehr als nur Honigernte</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Hinter den Bienenst&ouml;cken steckt eine alte Kunst, die Generationen &uuml;berdauert hat. Lerne die Grundlagen des Imkerns, von der Bienenpflege bis zur Honigentnahme, und wie du selbst Teil dieser Tradition werden kannst.</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Bienen und die Umwelt: eine symbiotische Beziehung</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Entdecke die enge Verbindung zwischen Bienen und der Umwelt. Erfahre, wie sie zur Gesundheit von &Ouml;kosystemen beitragen und warum ihr Wohlbefinden auch unser eigenes beeinflusst.</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Bedrohungen f&uuml;r Bienen: Was k&ouml;nnen wir tun?</strong></h3>\n" +
              "<p style=\"text-align: center;\"><strong><img src=\"https://utopia.de/app/uploads/2023/04/bienen-helfen-waben-insektenhotel-pb-sven-christian-schulz-230412-1920x1209-1.jpg\" width=\"578\" height=\"364\"></strong></p>\n" +
              "<p>&nbsp; &nbsp;Bienen stehen vor zahlreichen Herausforderungen, von Pestiziden bis hin zu Verlusten von Lebensr&auml;umen. Finde heraus, wie du helfen kannst, Bienen zu sch&uuml;tzen, sei es durch bienenfreundliche G&auml;rten oder Unterst&uuml;tzung von Umweltorganisationen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Vom Bl&uuml;tennektar zum Honigglas: Die Honigproduktion erkl&auml;rt</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Erfahre, wie Bienen Nektar sammeln und in k&ouml;stlichen Honig verwandeln. Tauche ein in den Prozess der Honiggewinnung und wie verschiedene Bl&uuml;ten den Geschmack und die Farbe des Honigs beeinflussen.</p>\n" +
              "<p><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://www.swd-ag.de/medien/magazin/artikel/heimatliebe/hl-wilde-bienen/bienen-facebook.jpg\" width=\"453\" height=\"237\"></p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Bienen in der Stadt: Stadtimkerei und Bienenhotels</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Auch in urbanen Umgebungen spielen Bienen eine wichtige Rolle. Erfahre, wie Stadtimker Bienen halten und welche innovativen Ans&auml;tze es gibt, wie Bienenhotels und vertikale Bienenst&ouml;cke.</p>\n" +
              "<h3 style=\"text-align: center;\"><strong>Fazit: Die unscheinbaren Helden unserer Natur</strong></h3>\n" +
              "<p>&nbsp; &nbsp;Bienen sind winzige Helden, die eine gro&szlig;e Rolle in unserer Welt spielen. Ihre Bedeutung f&uuml;r die Umwelt und unsere Nahrungsmittelproduktion kann nicht &uuml;berbetont werden. Lasst uns gemeinsam daf&uuml;r sorgen, dass ihre Summger&auml;usche auch in Zukunft in unseren G&auml;rten zu h&ouml;ren sind.</p>")
          .authorName("Johnnie Walker")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Bienenzucht: Ein Blick in die faszinierende Welt der Imkerei")
          .linkToImg("3")
          .shortPostDescription("Erfahre mehr über die faszinierende Kunst des Imkerns, die Bedeutung von Bienen für die Natur und Tipps für angehende Imker.")
          .textOfPost("<p>&nbsp; &nbsp;Bienen - kleine Wunder der Natur, die weit mehr tun als nur Honig zu produzieren. Imkern ist eine Kunst, die Generationen &uuml;berdauert hat und sich weiterentwickelt. Immer mehr Menschen entdecken die Freude und die Bedeutung, Bienen zu z&uuml;chten.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Die Arbeit eines Imkers ist voller &Uuml;berraschungen und Herausforderungen. Vom Aufbau und der Pflege der Bienenst&ouml;cke bis hin zur Honigernte erfordert es Hingabe und Wissen. Imkervereine bieten eine wertvolle Plattform f&uuml;r den Wissensaustausch und die Unterst&uuml;tzung unter Gleichgesinnten.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Bienen sind jedoch nicht nur Honiglieferanten. Ihre Best&auml;ubungsarbeit ist entscheidend f&uuml;r die Pflanzenwelt und unsere Nahrungsmittelproduktion. Ihr R&uuml;ckgang hat erhebliche Auswirkungen. Imkern kann helfen, diese wichtigen Insekten zu sch&uuml;tzen und zu unterst&uuml;tzen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Wenn du in die Welt der Imkerei eintauchen m&ouml;chtest, gibt es viele Ressourcen und Schulungen, die dir den Einstieg erleichtern. Vom st&auml;dtischen Balkon bis zum l&auml;ndlichen Garten - Bienen finden &uuml;berall Platz. Die Bienenzucht ist nicht nur eine bereichernde Erfahrung, sondern auch ein Beitrag zum Umweltschutz.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Bienen sind die stillen Helden, die unsere Welt am Laufen halten. Ihre Pflege und Unterst&uuml;tzung sind von unsch&auml;tzbarem Wert. Also, worauf wartest du? Tauche ein in die faszinierende Welt der Imkerei und werde Teil dieser bienenflei&szlig;igen Gemeinschaft.</p>")
          .authorName("Jim Beam")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Imkerei: Einblicke in das faszinierende Leben der Bienen")
          .linkToImg("4")
          .shortPostDescription("Erfahre mehr über die bemerkenswerte Welt der Bienen, ihre Rolle in der Natur und wie du selbst ein Imker werden kannst.")
          .textOfPost("<p>&nbsp; &nbsp;Summende Bienen sind mehr als nur Honigproduzenten. Sie sind unverzichtbare Best&auml;uber, die unsere &Ouml;kosysteme und unsere Ern&auml;hrung sichern. Imkern bietet einen tieferen Einblick in das Leben dieser faszinierenden Insekten.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Ein Bienenvolk ist eine lebendige Gemeinschaft mit klaren Aufgabenverteilungen. Die K&ouml;nigin regiert, die Arbeiterinnen sammeln Nektar und Pollen, w&auml;hrend die Drohnen sich um die Fortpflanzung k&uuml;mmern. Die Zusammenarbeit dieser Winzlinge ist bewundernswert.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Der Weg zum Imker beginnt mit Neugierde und Lernen. Imkervereine bieten Anleitung und Unterst&uuml;tzung f&uuml;r Anf&auml;nger. Von der Wahl des richtigen Bienenstandorts bis zur Pflege der V&ouml;lker lernst du die Grundlagen des Imkerns.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Imkern kann auch in st&auml;dtischen Gebieten praktiziert werden. Balkone und Gemeinschaftsg&auml;rten bieten Platz f&uuml;r Bienenst&ouml;cke. Du tr&auml;gst nicht nur zur Honigproduktion bei, sondern hilfst auch, die bedrohten Best&auml;uber zu sch&uuml;tzen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Die Bienenzucht ist eine Gelegenheit, die Natur aus n&auml;chster N&auml;he zu erleben und einen wertvollen Beitrag zur Umwelt zu leisten. Werde Teil der Imkergemeinschaft und entdecke die Faszination, die hinter den summenden Helden steckt.</p>")
          .authorName("Dom Pérignon")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Die Goldene Köstlichkeit der Natur: Das fabelhafte Universum des Honigs")
          .linkToImg("5")
          .shortPostDescription("Erfahre mehr über die vielfältigen Facetten des Honigs - von den verschiedenen Sorten bis zu den gesundheitlichen Vorzügen und kulinarischen Anwendungen.")
          .textOfPost("<p>&nbsp; &nbsp;Honig ist nicht nur ein s&uuml;&szlig;es Vergn&uuml;gen f&uuml;r den Gaumen, sondern auch ein faszinierendes Produkt der Natur. Die Artenvielfalt von Honig variiert je nach Bienenstandort und Bl&uuml;tenquellen. Von aromatischem Lavendelhonig bis hin zu kr&auml;ftigem Waldhonig - jeder Tropfen erz&auml;hlt eine einzigartige Geschichte.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Abgesehen von seinem delikaten Geschmack bietet Honig auch zahlreiche gesundheitliche Vorteile. Er enth&auml;lt Antioxidantien und hat antimikrobielle Eigenschaften. Viele schw&ouml;ren auf Honig als nat&uuml;rliches Heilmittel bei Halsschmerzen und zur F&ouml;rderung des Wohlbefindens.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;In der kulinarischen Welt ist Honig ein vielseitiger Begleiter. Er verleiht nicht nur S&uuml;&szlig;e, sondern auch Tiefe und Aroma. Von der Verfeinerung von Desserts bis zur Zugabe in herzhaften Gerichten - die Verwendungsm&ouml;glichkeiten sind grenzenlos.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Wenn du dich f&uuml;r Honig interessierst, kannst du sogar dein eigenes kleines Bienenparadies schaffen. Bienenfreundliche Pflanzen und ein bl&uuml;hender Garten sind der Anfang. Die Imkerei kann nicht nur den wunderbaren Honig hervorbringen, den wir kennen, sondern auch eine tiefere Verbindung zur Natur schaffen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Honig ist zweifellos eine der bezauberndsten Gaben der Natur. Er bereichert unsere Sinne, f&ouml;rdert unsere Gesundheit und er&ouml;ffnet eine Welt der kulinarischen Kreativit&auml;t. Ein L&ouml;ffel Honig ist nicht nur ein Genuss, sondern eine Hommage an die Wunder der Natur.</p>")
          .authorName("Henri Abelé")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Honigvielfalt: Entdecke die Reichhaltigkeit der Naturschätze")
          .linkToImg("6")
          .shortPostDescription("Erfahre mehr über die faszinierende Vielfalt der Honigsorten - von blumigem Akazienhonig bis zum dunkelrobusten Kastanienhonig.")
          .textOfPost("<p>&nbsp; &nbsp;Die Welt des Honigs ist reich an Farben, Aromen und Texturen. Jede Honigsorte erz&auml;hlt eine einzigartige Geschichte, gepr&auml;gt von den Bl&uuml;ten und Pflanzen, von denen die Bienen ihre Nahrung sammeln.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Beginnen wir mit dem zartgoldenen Akazienhonig. Seine helle Farbe und subtile S&uuml;&szlig;e machen ihn zu einer beliebten Wahl. Bl&uuml;ten des Akazienbaums verleihen diesem Honig einen delikaten Geschmack, der sich perfekt f&uuml;r Tee und Joghurt eignet.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;F&uuml;r diejenigen, die es kr&auml;ftiger m&ouml;gen, ist Kastanienhonig die Antwort. Seine dunkle Farbe und reichhaltige Konsistenz stammen von den Bl&uuml;ten der Kastanienb&auml;ume. Dieser intensive Honig verleiht Backwaren und herzhaften Gerichten eine markante Note.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Die Lavendelfelder tragen zum aromatischen Lavendelhonig bei, der mit seinem blumigen Aroma und leicht w&uuml;rzigen Geschmack begeistert. Er passt wunderbar zu frischem Brot und mildem K&auml;se.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Waldhonig, mit seinem tiefen Geschmack und einer Mischung aus Bl&uuml;tennektar und Honigtau, ist ein wahrhaft rustikaler Genuss. Er eignet sich hervorragend zum S&uuml;&szlig;en von herzhaften Gerichten und zur Zubereitung von Marinaden.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Die Welt des Honigs ist ein endloser Schatz, der darauf wartet, entdeckt zu werden. Jede Honigsorte hat ihre eigene Pers&ouml;nlichkeit, die durch die Vielfalt der Pflanzenwelt gepr&auml;gt wird. Tauche ein in diese Geschmacksreise und genie&szlig;e die nat&uuml;rliche Pracht, die der Honig zu bieten hat.</p>")
          .authorName("Dominic Andrews")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Honig in der Deutschen Kultur: Süße Traditionen und Geschmacksfreuden")
          .linkToImg("7")
          .shortPostDescription("Erfahre mehr über die vielfältigen kulturellen Bedeutungen des Honigs in Deutschland - von traditionellen Bräuchen bis hin zu modernen kulinarischen Kreationen.")
          .textOfPost("<p>&nbsp; &nbsp;In der deutschen Kultur spielt Honig eine bedeutende Rolle, die bis in alte Zeiten zur&uuml;ckreicht. Der goldene Sirup der Bienen ist nicht nur ein s&uuml;&szlig;er Genuss, sondern auch ein Symbol f&uuml;r Wohlstand und Gemeinschaft.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Traditionell wird Honig in Deutschland als Geschenk der Natur verehrt. Er findet sich in festlichen Gerichten wie dem \"Stollen\" - einem reichhaltigen Fr&uuml;chtebrot, das oft zur Weihnachtszeit genossen wird. Honig verleiht diesem traditionellen Geb&auml;ck eine nat&uuml;rliche S&uuml;&szlig;e und symbolisiert zugleich das s&uuml;&szlig;e Leben.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Aber Honig ist nicht nur in alten Br&auml;uchen pr&auml;sent. Moderne K&ouml;che und B&auml;cker verwenden Honig, um zeitgen&ouml;ssische kulinarische Meisterwerke zu schaffen. Von Honigglasuren auf herzhaften Gerichten bis zu Honig-K&auml;sekuchen - die kulinarische Kreativit&auml;t kennt keine Grenzen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Honigbasierte Produkte wie \"Met\", ein Honigwein, haben auch in der deutschen Getr&auml;nkekultur ihren Platz. Met wird oft mit geselligen Zusammenk&uuml;nften und besonderen Anl&auml;ssen in Verbindung gebracht.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Die Deutsche Kultur sch&auml;tzt Honig als Quelle von Genuss und Gemeinschaft. Seine S&uuml;&szlig;e bereichert nicht nur den Gaumen, sondern auch die kulturellen Traditionen. Ehren wir diese vielseitige Zutat, die Generationen &uuml;berdauert und sich weiterentwickelt hat.</p>")
          .authorName("Anna Müller")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("Die Bienenflüsterer Deutschlands: Leidenschaftliche Pioniere der Imkerei")
          .linkToImg("8")
          .shortPostDescription("Imkerei ist die alte Kunst der Bienenzucht und -pflege. Bienen sind nicht nur Honigproduzenten, sondern auch entscheidende Bestäuber für viele Pflanzenarten. Ihr Beitrag zur Erhaltung der Artenvielfalt und Fruchtbarkeit unseres Planeten ist von unschätzbarem Wert. Imkerei ist mehr als nur ein Beruf; es ist eine Lebensweise. Imker setzen sich leiden")
          .textOfPost("<p>&nbsp; &nbsp;Deutschland ist die Heimat leidenschaftlicher Imker, die das Handwerk der Bienenzucht mit Begeisterung aus&uuml;ben. Diese Bienenfl&uuml;sterer sind nicht nur Honigproduzenten, sondern auch wichtige Akteure im Schutz der Umwelt.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Deutsche Imker sind bekannt f&uuml;r ihre Fachkenntnisse und ihre Bereitschaft, ihr Wissen zu teilen. Imkervereine und Schulungen bieten Plattformen f&uuml;r den Austausch von bew&auml;hrten Praktiken und neuesten Erkenntnissen. Ihre Expertise erstreckt sich &uuml;ber die Pflege von Bienenst&ouml;cken hinaus und umfasst die F&ouml;rderung der Artenvielfalt und den nachhaltigen Umgang mit Bienenpopulationen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Einige deutsche Imker haben innovative Ans&auml;tze entwickelt, um die Gesundheit der Bienen zu f&ouml;rdern. Von bienenfreundlichen G&auml;rten bis hin zu modernen Technologien, die die Bienen&uuml;berwachung erleichtern - diese Bienenfl&uuml;sterer setzen sich aktiv f&uuml;r den Erhalt der Bienen ein.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<p>&nbsp; &nbsp;Die Leidenschaft der deutschen Imker geht &uuml;ber die Honigproduktion hinaus. Sie erkennen die Bedeutung der Bienen f&uuml;r unsere Umwelt und arbeiten daran, diese winzigen Best&auml;uber zu sch&uuml;tzen und zu unterst&uuml;tzen. Ihre Arbeit hinter den Kulissen tr&auml;gt dazu bei, das Gleichgewicht in der Natur aufrechtzuerhalten und die Grundlagen unserer Nahrungsmittelproduktion zu sichern.</p>")
          .authorName("Maximilian Schneider")
          .build();
      postService.addPost(newPost);

      newPost = NewPostDto.builder()
          .titlePost("HONIGSORTEN")
          .linkToImg("9")
          .shortPostDescription("Entdecken Sie die Vielfalt des Honigs: Von Bitterem bis Waldhonig, jede Sorte hat einzigartige Geschmacksrichtungen und heilende Eigenschaften. Eine süße Reise durch die Welt des natürlichen Genusses und der Gesundheit.")
          .textOfPost("<p style=\"text-align: center;\"><img src=\"http://beetools.ru/media/k2/items/cache/1ba6f013b03d3119f460bad3db0fbe5d_XL.jpg\" alt=\"\" width=\"681\" height=\"508\"></p>\n" +
              "<p style=\"text-align: center;\">Dieses Produkt hat eine gro&szlig;e Anzahl von Arten. Fast jede von ihnen wird in der Volksmedizin verwendet.</p>\n" +
              "<p style=\"text-align: center;\">&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">BITTERER HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Eine der wertvollsten Arten mit einem sehr s&uuml;&szlig;en, bis herben Geschmack und entsprechendem Geruch. Er ist sehr reich an Eisen und daher sehr n&uuml;tzlich f&uuml;r die Blutregeneration.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">BLATT-HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Er hat eine eher helle Farbe mit einem gr&uuml;nlichen Schimmer und geh&ouml;rt zur Sorte des wei&szlig;en Honigs. Er hat einen ausgesprochen angenehmen und milden Geruch und gilt als der s&uuml;&szlig;este von allen. Er ist sehr nahrhaft, so dass er organische Verarmung schnell wieder ausgleicht. Wegen seines hohen Vitamingehalts wird er in der Volksmedizin h&auml;ufig verwendet.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">WEISSER HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Eine eher seltene Sorte, die am h&auml;ufigsten gef&auml;lscht wird. Seine Quellen sind die wei&szlig;e Akazie und der Wei&szlig;klee, manchmal auch die Linde und einige andere. Einige Arten erhalten die wei&szlig;e Farbe jedoch erst nach der Kristallisation. Daher kann er mehrere Namen haben. \"Rein\" kann er nicht sein, da es fast unm&ouml;glich ist, ihn frei von Verunreinigungen zu machen. Infolgedessen hat es oft eine gewisse T&ouml;nung.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">KASTNUSSHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Mit einem bitteren Geschmack und einem k&ouml;stlichen Geruch nach Kastanienbl&uuml;ten. Sie ist eine der wenigen Sorten, die ihren fl&uuml;ssigen Zustand viel l&auml;nger als andere beibehalten kann - bis zu zwei Jahre. Diese dunkle Sorte enth&auml;lt eine Vielzahl von Vitaminen und Spurenelementen, einschlie&szlig;lich Metallen, und wird daher h&auml;ufig f&uuml;r medizinische Zwecke verwendet.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">KIPRAY-HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Reich an Vitamin C, was ihn zu einem wichtigen Mittel im Kampf gegen Erk&auml;ltungen macht.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">FALLHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Der Gattungsname \"gefallen\" bezieht sich auf das Sammeln der Bienen von Paddy und nicht von Pollen. Solche Sorten haben verschiedene Farben, aber unbedingt dunkel, bis hin zu schwarz. Und obwohl sie f&uuml;r Bienen nicht zur st&auml;ndigen Verwendung geeignet sind, sind sie f&uuml;r den Menschen nicht nur harmlos, sondern auch besonders n&uuml;tzlich.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">JUGGY-HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Er hat einen exquisiten Geschmack, ein bet&auml;ubendes Aroma und hervorragende medizinische Eigenschaften. Seine Farbe ist meist dunkel, kann aber auch rot sein. In der Medizin wird er haupts&auml;chlich als krampfl&ouml;sendes Mittel bei Magenproblemen verwendet.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">GELEE ROYALE HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Diese Mischung hat die F&auml;higkeit, den Menschen von vielen Krankheiten zu befreien. Er wird in einem Verh&auml;ltnis von 1 zu 150 gemischt.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">BL&Uuml;TENHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Fast immer hat einen angenehmen Geschmack und w&uuml;rzigen Geruch. Er wird sowohl in der Volksmedizin als auch in der modernen Medizin aktiv eingesetzt.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">DONNAKE-HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Kann aus gelben Heilbl&uuml;ten und wei&szlig;en gew&ouml;hnlichen Bl&uuml;ten hergestellt werden. Hat in beiden F&auml;llen qualitative antimikrobielle Eigenschaften, beschleunigt die Heilung von Wunden, verhindert deren Vereiterung.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">AKAZIENHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Er kann wei&szlig;, fast farblos oder gelb sein. V&ouml;llig ohne Bitterkeit, der Geschmack ist nicht stechend, ebenso wie der Geruch. Eine seltene Eigenschaft dieses Produkts ist seine lang anhaltende Best&auml;ndigkeit gegen Kristallisation. Er ist einfach ein hervorragendes Nahrungsmittel f&uuml;r Diabetiker und Kinder, da er vom menschlichen K&ouml;rper sehr schnell aufgenommen wird.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">SONNENBLUMENHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Er kristallisiert sehr schnell aus und wird dann hell, gelegentlich mit gr&uuml;nem Beigeschmack. Die Vorteile einer solchen Substanz liegen vor allem in der Behandlung des Herz-Kreislauf-Systems und der Atemwege. Dar&uuml;ber hinaus entfernt er perfekt Giftstoffe aus dem menschlichen K&ouml;rper und dient als gutes Diuretikum.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">BERGHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Der aus Bergkr&auml;utern gewonnene Bienenhonig gilt zu Recht als der reinste. Er enth&auml;lt Nektar von sehr seltenen Bl&uuml;ten, was dem Produkt eine besondere Heilkraft verleiht. Das Ergebnis dieser Mischung ist eine andere Farbe, ein anderes Aroma und ein anderer Geschmack. Er ist gut zur Behandlung von Erk&auml;ltungen geeignet.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">WILDER HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Es handelt sich um den Honig von Wildbienen - das urspr&uuml;ngliche Heilmittel f&uuml;r die Ern&auml;hrung. Er enth&auml;lt eine F&uuml;lle von verschiedenen Vitaminen. Die Besonderheit dieser Sorte liegt in der besonderen Art und Weise, wie sie gesammelt wird. Die Waben werden sechs Monate lang nicht ausgepackt, um eine gr&ouml;&szlig;ere Dichte und einen besseren Geschmack des Produkts, d.h. eine h&ouml;here Konzentration, zu erreichen.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">KR&Auml;UTERHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Meistens ist er von goldener Farbe. Die allgemein tonisierende Wirkung einer Substanz, die mit Vitaminen und einer Vielzahl von Spurenelementen angereichert ist, s&auml;ttigt den K&ouml;rper buchst&auml;blich mit Energie.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">SCHWARZER HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Schwarz kann nur in zwei F&auml;llen sein. Entweder handelt es sich um ein brachliegendes Produkt, oder es wird aus den Bl&uuml;ten des Schwarzk&uuml;mmels gewonnen. Im letzteren Fall kann er nur in &Auml;gypten gesammelt werden, weshalb die Kosten f&uuml;r einen solchen Honig mit den Kosten f&uuml;r eine Reise in dieses Land gleichgesetzt werden k&ouml;nnen. Aber er hat einzigartige und besonders heilende Eigenschaften.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">GR&Uuml;NER HONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Er wird zur St&auml;rkung des Immunsystems verwendet, da er Spirulina enth&auml;lt.</p>\n" +
              "<p>&nbsp;</p>\n" +
              "<h3 style=\"text-align: center;\">WALDHONIG</h3>\n" +
              "<p>&nbsp; &nbsp;Er gilt als eine der Elitesorten. Aufgrund seiner einzigartigen Eigenschaften wird er bei der Behandlung zahlreicher Krankheiten eingesetzt. Er hat einen spezifischen s&auml;uerlichen Geschmack und eine Farbpalette von hellgelb bis hellbraun.</p>")
          .authorName("Alexander Friedrich Schmidt")
          .build();
      postService.addPost(newPost);
    }
  }
}


