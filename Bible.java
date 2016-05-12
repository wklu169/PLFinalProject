public class Bible {
    private String id;
    private String name;
    private String author;
    private String chapters;
    private String verses;


    public Bible (String id, String name, String author, String chapters, String verses) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.chapters = chapters;
        this.verses = verses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getChapters() {
        return chapters;
    }

    public String getVerses() {
        return verses;
    }
}