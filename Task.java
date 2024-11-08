import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private static int lastId = 0;
    private  String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TO_DO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void markInProgress(){
        status = Status.IN_PROGRESS;
        updatedAt = LocalDateTime.now();
    }

    public void markDone(){
        status = Status.DONE;
        updatedAt = LocalDateTime.now();
    }

    public String toJson(){
        return ("{\"id\":\"" + id + "\"}");
    }

}
