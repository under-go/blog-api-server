package link.wafflebox.api.article;

import link.wafflebox.api.author.Author;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {
    @GetMapping("articles")
    @ResponseBody
    public List<Article> articles(Model model) {
        // dummy
        List<Article> result = Arrays.asList(
                new Article(
                        1L,
                        "our first article",
                        "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin malesuada tellus ipsum, non maximus nibh hendrerit condimentum. Fusce porta, urna nec accumsan elementum, erat nisi elementum mi, et pharetra massa nisi id leo. Nulla facilisi. Nullam ultricies mollis magna, non auctor nulla pretium vitae. Cras vitae velit nulla. Vivamus nec diam eget neque faucibus pharetra. Nullam dictum enim et eros condimentum, vel venenatis sapien aliquam. Morbi sit amet metus porttitor, viverra est facilisis, euismod libero. Curabitur mollis urna ante, at facilisis augue consectetur et. Etiam hendrerit nisi vel ex accumsan, sit amet eleifend urna aliquam. Aenean vestibulum condimentum dignissim. Mauris nisl lorem, lacinia ac risus ut, iaculis fermentum erat. Aliquam erat volutpat. Donec eget velit nisi. Donec commodo libero lectus, quis viverra ex consequat et. Vivamus a tincidunt massa, et feugiat turpis. Ut nulla turpis, rhoncus eu pretium vitae, facilisis eget neque. In ut mollis nunc. Praesent fermentum ipsum et diam vestibulum faucibus. Maecenas scelerisque lectus vitae augue volutpat malesuada. Vestibulum vestibulum ligula egestas sollicitudin tempor. Maecenas sit amet enim in odio egestas tincidunt ac et lectus. Cras fringilla felis sed nulla fringilla, nec tempor tellus tempor. Proin ante leo, faucibus vel leo a, dictum ultrices dolor. Nam eget mollis leo. Fusce sed fermentum purus, eget pellentesque massa. Ut congue lacus orci, vitae convallis erat consectetur et. Pellentesque libero tellus, ornare quis finibus non, pellentesque et metus. Nullam cursus quis justo sed mattis. Aliquam erat volutpat. Maecenas lacinia felis ipsum, eu suscipit nibh fermentum et. Suspendisse ac orci sem. Mauris non libero enim. Nunc aliquam diam et metus scelerisque, eget vestibulum metus semper. Sed non porta metus. Nam ex neque, ultrices quis urna vel, sollicitudin egestas diam. Aliquam at semper tellus, in tincidunt felis. Nulla a fermentum nisl. Nam sit amet velit in mi finibus aliquet. Pellentesque faucibus placerat tempor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque imperdiet purus id dolor pellentesque, quis ultrices sapien interdum. Praesent tempus pretium velit eu pretium. Etiam ac quam ut leo luctus luctus. Fusce congue odio ac ornare sagittis. Phasellus ut augue eget tellus ultricies dapibus. Aenean sit amet enim vitae neque cursus dapibus. Nulla sed elementum justo. Vivamus ultrices tellus et enim finibus rutrum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc augue tellus, ornare non mollis non, tincidunt id sem. Ut semper dui vel convallis ultrices. Suspendisse sagittis tincidunt magna, nec suscipit eros fringilla eu. Nunc sed sem facilisis, viverra turpis sed, pharetra mi. Donec consectetur, enim non porta pulvinar, nulla augue blandit odio, non vehicula libero ipsum sit amet magna. Curabitur eleifend enim odio, vitae cursus sem fermentum eu.",
                        new Author(10001L, "Team Undergo")),
                new Article(
                        2L,
                        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet",
                        "Proin tincidunt luctus neque, a efficitur purus dapibus vel. Morbi non tortor magna. In scelerisque urna sed risus suscipit fringilla. Duis non accumsan diam, a aliquet augue. Nulla dignissim risus vel dapibus pulvinar. Aliquam justo nisl, sagittis ac tellus ornare, efficitur mollis metus. Fusce tellus ligula, sodales sit amet metus a",
                        "Sed vulputate diam lacus, nec vestibulum dolor rutrum vitae. Proin ut tortor ut odio hendrerit interdum at sed sem. Quisque aliquet nec est eu volutpat. Morbi sit amet dolor neque. Aliquam erat volutpat. Sed ligula lectus, consectetur non erat ac, efficitur faucibus massa. Donec sodales ornare varius. Donec et porttitor mi, vulputate tristique ex. Aenean nulla magna, pellentesque cursus sodales id, ullamcorper ut ante. Ut vehicula ut purus at pulvinar. Integer congue commodo facilisis. n sed ipsum eu nisi maximus lobortis. Praesent feugiat massa ac neque imperdiet vulputate non nec nibh. Morbi quis diam egestas lectus ornare sollicitudin non vitae nisl. Fusce mauris felis, elementum eget viverra sit amet, ullamcorper nec mauris. Donec laoreet vel dui ac vulputate. Nullam fringilla sollicitudin orci ac dapibus. Aliquam id felis suscipit nisl aliquet aliquam ut ut metus. Quisque nec hendrerit eros. Vestibulum vehicula leo vitae mi tincidunt, eu imperdiet libero pharetra. Cras pulvinar, est sed elementum placerat, arcu augue volutpat diam, vitae pellentesque dolor velit sagittis felis. Vestibulum aliquam tellus quam, in posuere eros pellentesque fringilla. Donec mi nisi, suscipit vel gravida non, lacinia vel lectus. Cras venenatis, lorem eu feugiat sodales, lacus nisi maximus nulla, nec ultrices ligula lorem non odio. Suspendisse ut mollis nibh. Pellentesque eget ornare augue.",
                        new Author(10002L, "Hwanny")),
                new Article(
                        3L,
                        "Nulla scelerisque ac massa ac pretium. Maecenas vel consequat sem, consectetur, adipisci velit ",
                        " Integer at magna turpis. Cras varius eu orci a placerat. Cras iaculis nisl tincidunt, suscipit libero non, facilisis tortor. Phasellus et orci sit amet elit accumsan auctor. Quisque tempus arcu ut lectus tincidunt consequat. Mauris nisl arcu, mattis ut venenatis at, ornare pharetra eros. Mauris vulputate dui quis mauris tincidunt, id tempus risus lacinia. Morbi ex quam, tempus non tortor sit amet, pulvinar egestas ligula. Aliquam eget justo vestibulum, mollis risus quis, tincidunt odio. In porta est augue. In ornare interdum maximus. In vitae luctus tortor.",
                        "Proin pharetra lectus ut arcu mattis bibendum. Curabitur aliquet, augue eget vulputate efficitur, justo leo vulputate nulla, a dapibus risus lacus laoreet odio. Phasellus egestas, sem id scelerisque vulputate, elit massa vestibulum arcu, ut tincidunt quam risus nec orci. Nulla metus nisi, pretium id velit dignissim, euismod ultrices elit. Pellentesque blandit egestas nibh vel accumsan. Ut et tempor mauris. Sed varius tristique hendrerit. Quisque quis elit auctor, volutpat nulla facilisis, ornare turpis. Pellentesque commodo rutrum urna sollicitudin posuere. Mauris sit amet mauris sem. Aliquam non leo tellus. Quisque vulputate efficitur justo a pulvinar. Vestibulum vel risus nec quam lacinia ornare. Ut at congue nulla. In cursus tincidunt augue sit amet dignissim. Aliquam ultricies ac enim non lobortis. Nunc facilisis bibendum tempus. Quisque nec mattis mauris. Aliquam accumsan odio vel justo interdum, at sodales tellus interdum. In nec dignissim nibh.",
                        new Author(10003L, "Hyunjun Choi"))
        );

        return result;
    }
}
