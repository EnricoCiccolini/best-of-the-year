package multimediaClass;

public class Song extends AbstractMultimedia {

    private String author;

    public Song(String titolo, String id, String author) {
        super(titolo, id);
        this.author = author;

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

}
