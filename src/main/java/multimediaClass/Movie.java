package multimediaClass;

public class Movie extends AbstractMultimedia {
    private String director;

    public Movie(String titolo, String id, String director) {
        super(titolo, id);
        this.director = director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return this.director;
    }

}
