package Entity;

import java.util.Arrays;

public class ArticleManagement {

    private static int totalPost;

    public static int getTotalPost() {
        return totalPost;
    }

    public static void setTotalPost(int totalPost) {
        ArticleManagement.totalPost = totalPost;
    }

    Jounalist jounalist;
    PostDetail[] postDetails;

    public ArticleManagement(Jounalist jounalist, PostDetail[] postDetails) {
        this.jounalist = jounalist;
        this.postDetails = postDetails;
    }

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
