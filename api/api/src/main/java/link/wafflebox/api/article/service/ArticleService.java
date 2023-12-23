package link.wafflebox.api.article.service;

import link.wafflebox.api.article.dto.Article;
import link.wafflebox.api.article.repository.ArticleRepository;
import link.wafflebox.api.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        // dummy
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(e -> articles.add(
                new Article(e.getId(), e.getTitle(), e.getSummary(), e.getContent(), new UserDto(e.getAuthorId(), "test-id", "test-nn"), e.getCreatedAt())
                )
        );

        return articles;
    }
}



//                new Article(
//                        1L,
//                        "our first article",
//                        "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain",
//                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin malesuada tellus ipsum, non maximus nibh hendrerit condimentum. Fusce porta, urna nec accumsan elementum, erat nisi elementum mi, et pharetra massa nisi id leo. Nulla facilisi. Nullam ultricies mollis magna, non auctor nulla pretium vitae. Cras vitae velit nulla. Vivamus nec diam eget neque faucibus pharetra. Nullam dictum enim et eros condimentum, vel venenatis sapien aliquam. Morbi sit amet metus porttitor, viverra est facilisis, euismod libero. Curabitur mollis urna ante, at facilisis augue consectetur et. Etiam hendrerit nisi vel ex accumsan, sit amet eleifend urna aliquam. Aenean vestibulum condimentum dignissim. Mauris nisl lorem, lacinia ac risus ut, iaculis fermentum erat. Aliquam erat volutpat. Donec eget velit nisi. Donec commodo libero lectus, quis viverra ex consequat et. Vivamus a tincidunt massa, et feugiat turpis. Ut nulla turpis, rhoncus eu pretium vitae, facilisis eget neque. In ut mollis nunc. Praesent fermentum ipsum et diam vestibulum faucibus. Maecenas scelerisque lectus vitae augue volutpat malesuada. Vestibulum vestibulum ligula egestas sollicitudin tempor. Maecenas sit amet enim in odio egestas tincidunt ac et lectus. Cras fringilla felis sed nulla fringilla, nec tempor tellus tempor. Proin ante leo, faucibus vel leo a, dictum ultrices dolor. Nam eget mollis leo. Fusce sed fermentum purus, eget pellentesque massa. Ut congue lacus orci, vitae convallis erat consectetur et. Pellentesque libero tellus, ornare quis finibus non, pellentesque et metus. Nullam cursus quis justo sed mattis. Aliquam erat volutpat. Maecenas lacinia felis ipsum, eu suscipit nibh fermentum et. Suspendisse ac orci sem. Mauris non libero enim. Nunc aliquam diam et metus scelerisque, eget vestibulum metus semper. Sed non porta metus. Nam ex neque, ultrices quis urna vel, sollicitudin egestas diam. Aliquam at semper tellus, in tincidunt felis. Nulla a fermentum nisl. Nam sit amet velit in mi finibus aliquet. Pellentesque faucibus placerat tempor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque imperdiet purus id dolor pellentesque, quis ultrices sapien interdum. Praesent tempus pretium velit eu pretium. Etiam ac quam ut leo luctus luctus. Fusce congue odio ac ornare sagittis. Phasellus ut augue eget tellus ultricies dapibus. Aenean sit amet enim vitae neque cursus dapibus. Nulla sed elementum justo. Vivamus ultrices tellus et enim finibus rutrum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc augue tellus, ornare non mollis non, tincidunt id sem. Ut semper dui vel convallis ultrices. Suspendisse sagittis tincidunt magna, nec suscipit eros fringilla eu. Nunc sed sem facilisis, viverra turpis sed, pharetra mi. Donec consectetur, enim non porta pulvinar, nulla augue blandit odio, non vehicula libero ipsum sit amet magna. Curabitur eleifend enim odio, vitae cursus sem fermentum eu.",
//                        new User("undergo", "Team Undergo"),
//                        OffsetDateTime.of(LocalDateTime.of(2023, Month.SEPTEMBER, 11, 21, 35), ZoneOffset.ofHours(9))),
//                        new Article(
//                        2L,
//                        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet",
//                        "Proin tincidunt luctus neque, a efficitur purus dapibus vel. Morbi non tortor magna. In scelerisque urna sed risus suscipit fringilla. Duis non accumsan diam, a aliquet augue. Nulla dignissim risus vel dapibus pulvinar. Aliquam justo nisl, sagittis ac tellus ornare, efficitur mollis metus. Fusce tellus ligula, sodales sit amet metus a",
//                        "Sed vulputate diam lacus, nec vestibulum dolor rutrum vitae. Proin ut tortor ut odio hendrerit interdum at sed sem. Quisque aliquet nec est eu volutpat. Morbi sit amet dolor neque. Aliquam erat volutpat. Sed ligula lectus, consectetur non erat ac, efficitur faucibus massa. Donec sodales ornare varius. Donec et porttitor mi, vulputate tristique ex. Aenean nulla magna, pellentesque cursus sodales id, ullamcorper ut ante. Ut vehicula ut purus at pulvinar. Integer congue commodo facilisis. n sed ipsum eu nisi maximus lobortis. Praesent feugiat massa ac neque imperdiet vulputate non nec nibh. Morbi quis diam egestas lectus ornare sollicitudin non vitae nisl. Fusce mauris felis, elementum eget viverra sit amet, ullamcorper nec mauris. Donec laoreet vel dui ac vulputate. Nullam fringilla sollicitudin orci ac dapibus. Aliquam id felis suscipit nisl aliquet aliquam ut ut metus. Quisque nec hendrerit eros. Vestibulum vehicula leo vitae mi tincidunt, eu imperdiet libero pharetra. Cras pulvinar, est sed elementum placerat, arcu augue volutpat diam, vitae pellentesque dolor velit sagittis felis. Vestibulum aliquam tellus quam, in posuere eros pellentesque fringilla. Donec mi nisi, suscipit vel gravida non, lacinia vel lectus. Cras venenatis, lorem eu feugiat sodales, lacus nisi maximus nulla, nec ultrices ligula lorem non odio. Suspendisse ut mollis nibh. Pellentesque eget ornare augue.",
//                        new User("cch123", "Hwanny"),
//                        OffsetDateTime.of(LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0), ZoneOffset.UTC)),
//                        new Article(
//                        3L,
//                        "Nulla scelerisque ac massa ac pretium. Maecenas vel consequat sem, consectetur, adipisci velit ",
//                        " Integer at magna turpis. Cras varius eu orci a placerat. Cras iaculis nisl tincidunt, suscipit libero non, facilisis tortor. Phasellus et orci sit amet elit accumsan auctor. Quisque tempus arcu ut lectus tincidunt consequat. Mauris nisl arcu, mattis ut venenatis at, ornare pharetra eros. Mauris vulputate dui quis mauris tincidunt, id tempus risus lacinia. Morbi ex quam, tempus non tortor sit amet, pulvinar egestas ligula. Aliquam eget justo vestibulum, mollis risus quis, tincidunt odio. In porta est augue. In ornare interdum maximus. In vitae luctus tortor.",
//                        """
//                                The standard Lorem Ipsum passage, used since the 1500s
//                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
//
//                                Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC
//                                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"
//
//                                1914 translation by H. Rackham
//                                "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"
//
//                                Section 1.10.33 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC
//                                "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
//
//                                1914 translation by H. Rackham
//                                "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."
//
//                                ```js
//                                import Document, { Html, Head, Main, NextScript } from "next/document" import Document, { Html, Head, Main, NextScript } from "next/document";
//
//                                // \uD83D\uDD25 Super granular and accurate highlighting
//                                export default class MyDocument extends Document {
//                                  static async getInitialProps(ctx) {
//                                    const initialProps = await Document.getInitialProps(ctx);
//                                    return { ...initialProps };
//                                  }
//
//                                  render() {
//                                    return (
//                                      <Html>
//                                        <Head />
//                                        <body className="bg-zinc-800 text-zinc-200">
//                                          <Main />
//                                          <NextScript />
//                                        </body>
//                                      </Html>
//                                    );
//                                  }
//                                }
//                                ```""",
//                        new User("chj7239", "Hyunjun Choi"),
//                        OffsetDateTime.of(LocalDateTime.of(2002, Month.MAY, 31, 8, 0), ZoneOffset.ofHours(9)))
//                        );