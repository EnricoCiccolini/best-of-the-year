package multimediaClass;

public abstract class AbstractMultimedia {
    private String id;
    private String titolo;

    public AbstractMultimedia(String titolo, String id) {
        this.id = id;
        this.titolo = titolo;

    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public String getid() {
        return this.id;
    }

}
