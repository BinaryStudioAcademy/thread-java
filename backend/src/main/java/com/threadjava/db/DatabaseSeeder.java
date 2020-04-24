package com.threadjava.db;

import com.threadjava.comment.CommentRepository;
import com.threadjava.comment.model.Comment;
import com.threadjava.image.ImageRepository;
import com.threadjava.image.model.Image;
import com.threadjava.post.PostsRepository;
import com.threadjava.post.model.Post;
import com.threadjava.postReactions.PostReactionsRepository;
import com.threadjava.postReactions.model.PostReaction;
import com.threadjava.users.UsersRepository;
import com.threadjava.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class DatabaseSeeder {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private PostReactionsRepository postReactionsRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        List<User> u = jdbcTemplate.query("SELECT * FROM users", (resultSet, rowNum) -> null);
        if(u == null || u.size() <= 0) {
            seedImagesTable();
            seedUsersTable();
            seedPostsTable();
            seedCommentsTable();
            seedPostReactionsTable();
        }
    }

    private void seedImagesTable() {
        var newImages = Stream.concat(getUserImages().stream(), getPostImages().stream()).collect(Collectors.toList());
        imageRepository.saveAll(newImages);
    }

    private void seedUsersTable(){
        List<Image> userImages = jdbcTemplate.query("SELECT * FROM images WHERE link IN ("+ imagesToString(getUserImages()) +")", DatabaseSeeder::mapRowImage);

        var user1 = new User();
        user1.setEmail("demo@demo.com");
        user1.setUsername("demo");
        user1.setPassword(bCryptPasswordEncoder.encode("demo"));
        user1.setAvatar(userImages.get(0));
        var user2 = new User();
        user2.setEmail("gbottoms1@arizona.edu");
        user2.setUsername("thartwright1");
        user2.setPassword(bCryptPasswordEncoder.encode("pxlxvUyyUjE"));
        user2.setAvatar(userImages.get(1));
        var user3 = new User();
        user3.setEmail("cclears2@state.gov");
        user3.setUsername("bkopps2");
        user3.setPassword(bCryptPasswordEncoder.encode("ioyLdS9Mdgj"));
        user3.setAvatar(userImages.get(2));
        var user4 = new User();
        user4.setEmail("htie3@chronoengine.com");
        user4.setUsername("kmitchinson3");
        user4.setPassword(bCryptPasswordEncoder.encode("twn50kl"));
        user4.setAvatar(userImages.get(3));
        var user5 = new User();
        user5.setEmail("bbirmingham4@guardian.co.uk");
        user5.setUsername("fbrabon4");
        user5.setPassword(bCryptPasswordEncoder.encode("0naQBpP9"));

        usersRepository.saveAll(List.of(user1, user2, user3, user4, user5));
    }

    private void seedPostsTable() {
        var randomize = new Random();
        List<Image> postImages = jdbcTemplate.query("SELECT * FROM images WHERE link IN ("+ imagesToString(getPostImages()) +")", DatabaseSeeder::mapRowImage);
        var users = usersRepository.findAll();

        String[] postBodies = { "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
                "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla",
                "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut",
                "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit",
                "repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque",
                "ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae",
                "dolore placeat quibusdam ea quo vitae\nmagni quis enim qui quis quo nemo aut saepe\nquidem repellat excepturi ut quia\nsunt ut sequi eos ea sed quas",
                "dignissimos aperiam dolorem qui eum\nfacilis quibusdam animi sint suscipit qui sint possimus cum\nquaerat magni maiores excepturi\nipsam ut commodi dolor voluptatum modi aut vitae",
                "consectetur animi nesciunt iure dolore\nenim quia ad\nveniam autem ut quam aut nobis\net est aut quod aut provident voluptas autem voluptas",
                "quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error" };

        var posts = IntStream.range(0, postBodies.length)
                .mapToObj(i -> {
                    var newPost = new Post();
                    newPost.setBody(postBodies[i]);
                    newPost.setImage(getByIndex(postImages, i));
                    newPost.setUser(users.get(randomize.nextInt(users.size())));
                    return newPost;
                })
                .collect(Collectors.toList());

        postsRepository.saveAll(posts);
    }

    private void seedCommentsTable() {
        var randomize = new Random();
        var users = StreamSupport
                .stream(usersRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        var posts = StreamSupport
                .stream(postsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        String[] commentsText = {
                "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et",
                "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione",
                "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati",
                "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et",
                "doloribus at sed quis culpa deserunt consectetur qui praesentium\naccusamus fugiat dicta\nvoluptatem rerum ut voluptate autem\nvoluptatem repellendus aspernatur dolorem in",
                "maiores sed dolores similique labore et inventore et\nquasi temporibus esse sunt id et\neos voluptatem aliquam\naliquid ratione corporis molestiae mollitia quia et magnam dolor",
                "ut voluptatem corrupti velit\nad voluptatem maiores\net nisi velit vero accusamus maiores\nvoluptates quia aliquid ullam eaque",
                "sapiente assumenda molestiae atque\nadipisci laborum distinctio aperiam et ab ut omnis\net occaecati aspernatur odit sit rem expedita\nquas enim ipsam minus",
                "voluptate iusto quis nobis reprehenderit ipsum amet nulla\nquia quas dolores velit et non\naut quia necessitatibus\nnostrum quaerat nulla et accusamus nisi facilis",
                "ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea",
                "expedita maiores dignissimos facilis\nipsum est rem est fugit velit sequi\neum odio dolores dolor totam\noccaecati ratione eius rem velit",
                "fuga eos qui dolor rerum\ninventore corporis exercitationem\ncorporis cupiditate et deserunt recusandae est sed quis culpa\neum maiores corporis et",
                "vel quae voluptas qui exercitationem\nvoluptatibus unde sed\nminima et qui ipsam aspernatur\nexpedita magnam laudantium et et quaerat ut qui dolorum",
                "nihil ut voluptates blanditiis autem odio dicta rerum\nquisquam saepe et est\nsunt quasi nemo laudantium deserunt\nmolestias tempora quo quia",
                "iste ut laborum aliquid velit facere itaque\nquo ut soluta dicta voluptate\nerror tempore aut et\nsequi reiciendis dignissimos expedita consequuntur libero sed fugiat facilis",
                "consequatur necessitatibus totam sed sit dolorum\nrecusandae quae odio excepturi voluptatum harum voluptas\nquisquam sit ad eveniet delectus\ndoloribus odio qui non labore",
                "veritatis voluptates necessitatibus maiores corrupti\nneque et exercitationem amet sit et\nullam velit sit magnam laborum\nmagni ut molestias",
                "doloribus est illo sed minima aperiam\nut dignissimos accusantium tempore atque et aut molestiae\nmagni ut accusamus voluptatem quos ut voluptates\nquisquam porro sed architecto ut",
                "qui harum consequatur fugiat\net eligendi perferendis at molestiae commodi ducimus\ndoloremque asperiores numquam qui\nut sit dignissimos reprehenderit tempore",
                "deleniti aut sed molestias explicabo\ncommodi odio ratione nesciunt\nvoluptate doloremque est\nnam autem error delectus",
                "qui ipsa animi nostrum praesentium voluptatibus odit\nqui non impedit cum qui nostrum aliquid fuga explicabo\nvoluptatem fugit earum voluptas exercitationem temporibus dignissimos distinctio\nesse inventore reprehenderit quidem ut incidunt nihil necessitatibus rerum",
                "voluptates provident repellendus iusto perspiciatis ex fugiat ut\nut dolor nam aliquid et expedita voluptate\nsunt vitae illo rerum in quos\nvel eligendi enim quae fugiat est",
                "repudiandae repellat quia\nsequi est dolore explicabo nihil et\net sit et\net praesentium iste atque asperiores tenetur",
                "sunt aut quae laboriosam sit ut impedit\nadipisci harum laborum totam deleniti voluptas odit rem ea\nnon iure distinctio ut velit doloribus\net non ex",
                "incidunt sapiente eaque dolor eos\nad est molestias\nquas sit et nihil exercitationem at cumque ullam\nnihil magnam et",
                "nisi vel quas ut laborum ratione\nrerum magni eum\nunde et voluptatem saepe\nvoluptas corporis modi amet ipsam eos saepe porro",
                "voluptatem repellendus quo alias at laudantium\nmollitia quidem esse\ntemporibus consequuntur vitae rerum illum\nid corporis sit id"
        };

        var comments = IntStream.range(0, commentsText.length)
                .mapToObj(i -> {
                    var newPost = new Comment();
                    newPost.setBody(commentsText[i]);
                    newPost.setUser(users.get(randomize.nextInt(users.size())));
                    newPost.setPost(posts.get(randomize.nextInt(posts.size())));
                    return newPost;
                })
                .collect(Collectors.toList());

        commentRepository.saveAll(comments);
    }

    private void seedPostReactionsTable() {
        var randomize = new Random();
        var users = usersRepository.findAll();
        var posts = postsRepository.findAll();

        var reactions = Stream.concat(
                IntStream.range(0, 25).mapToObj(x -> true),
                IntStream.range(0, 25).mapToObj(x -> false))
                .map(x -> {
                    var reaction = new PostReaction();
                    reaction.setIsLike(x);
                    reaction.setPost(posts.get(randomize.nextInt(posts.size())));
                    reaction.setUser(users.get(randomize.nextInt(users.size())));
                    return reaction;
                })
                .collect(Collectors.toList());
        postReactionsRepository.saveAll(reactions);
    }

    private List<Image> getUserImages(){
        var image1 = new Image();
        image1.setLink("https://i.imgur.com/hIjmHms.jpg");
        image1.setDeleteHash("lajdyJs0Tev0joE");
        var image2 = new Image();
        image2.setLink("https://i.imgur.com/Y8DGAuj.jpg");
        image2.setDeleteHash("1ifCzLIPTjCXurr");
        var image3 = new Image();
        image3.setLink("https://i.imgur.com/hG4Th4U.jpg");
        image3.setDeleteHash("Incmabo8F8nnDG7");
        var image4 = new Image();
        image4.setLink("https://i.imgur.com/dKDpaU5.jpg");
        image4.setDeleteHash("6ZZpdY8vVRarUx8");

        return  List.of(image1, image2, image3, image4 );
    }

    private List<Image> getPostImages(){
        var image1 = new Image();
        image1.setLink("https://i.imgur.com/OE6SAt3.jpg");
        image1.setDeleteHash("ImeeDLLWrl65Wpv");
        var image2 = new Image();
        image2.setLink("https://i.imgur.com/jJ8OG5D.jpg");
        image2.setDeleteHash("hKCqBdz2pqcLBk3");
        return  List.of(image1, image2);
    }

    private String imagesToString(List<Image>  images){
        return String.join(",", images.stream().map(x -> "'" + x.getLink() + "'").collect(Collectors.toList()));
    }


    private static Image mapRowImage(ResultSet resultSet, int rowNum) throws SQLException {
        Image image = new Image();
        image.setId(UUID.fromString(resultSet.getString("Id")));
        return image;
    }

    private  <T> T getByIndex(List<T> list, Integer index){
        if(list.size() - 1 < index){
            return  null;
        }
        return list.get(index);
    }
}
