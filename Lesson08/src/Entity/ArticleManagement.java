package Entity;

import java.util.Arrays;

public class ArticleManagement {

    Jounalist jounalist;
    PostDetail[] postDetails;

    public Jounalist getJounalist() {
        return jounalist;
    }

    public void setJounalist(Jounalist jounalist) {
        this.jounalist = jounalist;
    }

    public PostDetail[] getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetail[] postDetails) {
        this.postDetails = postDetails;
    }

    @Override
    public String toString() {
        return "ArticleManagement{" +
                "jounalist=" + jounalist +
                ", postDetails=" + Arrays.toString(postDetails) +
                '}';
    }
}
