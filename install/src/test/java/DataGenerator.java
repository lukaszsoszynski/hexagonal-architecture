import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

public class DataGenerator {

    private static final String[] FORUMS = {"java", "scala", "groovy", "kotlin", "javascript", "ruby"};
    private static final String[] USERS = {"uncle.bob@cleancode", "Martin.Fowler@gfi", "bruce.eckel@gfi"};
    private static final String[] CONTENT = {"clean code",
            "solid",
            "GRASP",
            "object-oriented design",
            "Law of Demeter",
            "keep it simple stupid",
            "tackling complexity in the heart of software",
            "dependency inversion", "hexagonal architecture",
            "think big start small",
            "functional programing",
            "test driven development",
            "specification as example",
            "infrastructure as a code",
            "thinking in java"};
    private static final int MAX_NUMBER_OF_THREADS = 3;
    private static final int MAX_NUMBER_OF_POSTS = 7;
    private int threadSequence = -1000;
    private int postSequence = -1000;
    private int userIndex = 0;
    private int contentIndex = 0;

    @Test
    public void generateScript() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String forum : FORUMS) {
            for (int i = 0; i < MAX_NUMBER_OF_THREADS; ++i) {
                stringBuilder.append(generateThread(forum, i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private String generateThread(String forum, int threadIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        int threadId = nextThreadId();
        stringBuilder.append("insert into thread(id, forum_name, thread_name, creator) ")
                .append("values(").append(threadId).append(",")
                .append("'").append(forum).append("',")
                .append("'thread-").append(forum).append("-").append(threadIndex).append("',")
                .append("'").append(nextUser()).append("');\n")
                .append(generatePost(threadId));
        return stringBuilder.toString();
    }

    private String generatePost(int threadId) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int postIndex = 0; postIndex < MAX_NUMBER_OF_POSTS; ++postIndex) {
            int postId = nextPostId();
            stringBuilder.append(createPost(threadId, postId));
        }
        return stringBuilder.toString();
    }

    @NotNull
    private String createPost(int threadId, int postId) {
        return new StringBuilder("\t")
                .append("insert into post(id, thread_id, content, title, author) values(")
                .append(postId).append(",")
                .append(threadId).append(",")
                .append("'").append(getNextContent()).append("',")
                .append("'Title-").append(Math.abs(postId)).append("',")
                .append("'").append(nextUser()).append("');\n")
                .toString();
    }

    private String getNextContent() {
        return CONTENT[(contentIndex++) % CONTENT.length];
    }

    private int nextPostId() {
        return postSequence = postSequence - 10;
    }

    private String nextUser() {
        return USERS[(userIndex++) % USERS.length];
    }

    private int nextThreadId() {
        return threadSequence = threadSequence - 10;
    }
}
