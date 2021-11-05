package dev.smith.controllers;

import com.google.gson.Gson;
import dev.smith.logger.MyLogger;
import dev.smith.models.Event;
import dev.smith.repositories.EventRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class EventController {

    EventRepo er;
    Gson gson = new Gson();

    public EventController(EventRepo er) { this.er = er; }

    public Handler getEventById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Event e = er.getEvents(id);

        populateResult(context, e);

    };

    public Handler getAllEvents = (context) -> {

        List<Event> eventList = er.getAllEvents();

        if(eventList != null) {
            context.result(gson.toJson(eventList));
        } else {
            context.result("[]");
        };
    };

    //Helper method
    private void populateResult(Context context, Event e) {

        if(e != null) {
            context. result(gson.toJson(e));
            MyLogger.logger.error(" success");
            context.status(200);
        } else {
            context. result("{}");
            context.status(400);
            MyLogger.logger.error(" failed");

        }

    };
}
