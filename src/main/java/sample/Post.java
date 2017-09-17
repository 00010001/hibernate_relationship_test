package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sample.Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    private List<PostComment> comments = new ArrayList<>();

    public Post() {
    }

    //Constructors, getters and setters removed for brevity
}