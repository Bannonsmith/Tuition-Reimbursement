package dev.smith.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "event_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "event_percentage", nullable = false)
    private String eventPercentage;

    @Column(name = "event_grade_approvals", nullable = false)
    private String eventGradeApprovals;

    @Column(name = "event_start_date", nullable = false, columnDefinition = "numeric(12,2)")
    private int eventStartDate;

    public Event() {
    }

    public Event(int eventId) {
        this.eventId = eventId;
    }

    public Event(String eventType, String eventPercentage, String eventGradeApprovals, int eventStartDate) {
        this.eventType = eventType;
        this.eventPercentage = eventPercentage;
        this.eventGradeApprovals = eventGradeApprovals;
        this.eventStartDate = eventStartDate;
    }

    public Event(int eventId, String eventType, String eventPercentage, String eventGradeApprovals, int eventStartDate) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventPercentage = eventPercentage;
        this.eventGradeApprovals = eventGradeApprovals;
        this.eventStartDate = eventStartDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventPercentage() {
        return eventPercentage;
    }

    public void setEventPercentage(String eventPercentage) {
        this.eventPercentage = eventPercentage;
    }

    public String getEventGradeApprovals() {
        return eventGradeApprovals;
    }

    public void setEventGradeApprovals(String eventGradeApprovals) {
        this.eventGradeApprovals = eventGradeApprovals;
    }

    public int getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(int eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId && eventStartDate == event.eventStartDate && Objects.equals(eventType, event.eventType) && Objects.equals(eventPercentage, event.eventPercentage) && Objects.equals(eventGradeApprovals, event.eventGradeApprovals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventType, eventPercentage, eventGradeApprovals, eventStartDate);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventType='" + eventType + '\'' +
                ", eventPercentage='" + eventPercentage + '\'' +
                ", eventGradeApprovals='" + eventGradeApprovals + '\'' +
                ", eventStartDate=" + eventStartDate +
                '}';
    }
}
