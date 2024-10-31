package com.task_tracker_cli.app.misc;

import com.task_tracker_cli.app.models.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.task_tracker_cli.app.models.Task.formatter;
import static com.task_tracker_cli.app.models.Task.lastId;

public class JsonConverter {

    private static Task task;

    public JsonConverter(Task task) {
        JsonConverter.task = task;
    }



    public String toJson(){
        return "\"id\":\"" + task.getId()
                + "\", \"description\":\"" + task.getDescription().strip()
                + "\", \"status\":\"" + task.getStatus().toString() +
                "\", \"created at\":\"" + task.getCreatedAt().format(formatter) +
                "\", \"updated at\":\"" + task.getUpdatedAt().format(formatter)
                + "\"}";
    }

    public static Task fromJson(String json){
        json = json.replace("{", "")
                .replace("}","")
                .replace("\"", "");
        String[] parts = json.split(",");

        String id = parts[0].split(":")[1].strip();
        String description = parts[1].split(":")[1].strip();
        String statusString = parts[2].split(":")[1].strip();
        String createdAtStr = parts[3].split(":")[1].strip();
        String updatedAtStr = parts[4].split(":")[1].strip();

        Status status = Status.valueOf(statusString.replace(" ", "_"));

        task.setId(Integer.parseInt(id));
        task.setDescription(description);
        task.setStatus(status);
        task.setCreatedAt(LocalDateTime.parse(createdAtStr, formatter));
        task.setUpdatedAt(LocalDateTime.parse(updatedAtStr, formatter));

        if(Integer.parseInt(id) > lastId)
            lastId = Integer.parseInt(id);

        return task;
    }
}
