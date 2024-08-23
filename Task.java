public class Task {
    private int id;
    private String title;
    private boolean status;

    // Constructeur
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.status = false;

    }

    // Getters et Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
