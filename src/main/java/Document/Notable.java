package Document;

public class Notable {
    String name,
           note;

    public Notable(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public Notable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}
