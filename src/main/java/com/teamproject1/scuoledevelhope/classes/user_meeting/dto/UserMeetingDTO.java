package com.teamproject1.scuoledevelhope.classes.user_meeting.dto;

import java.util.ArrayList;
import java.util.List;

public class UserMeetingDTO {

    private Long idMeeting;
    private List<Long> participantsId = new ArrayList<>();

    public UserMeetingDTO() {
    }

    @Override
    public String toString() {
        return "UserMeetingDTO{" +
                "idMeeting=" + idMeeting +
                ", participantsId=" + participantsId +
                '}';
    }

    public Long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(Long idMeeting) {
        this.idMeeting = idMeeting;
    }

    public List<Long> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(List<Long> participantsId) {
        this.participantsId = participantsId;
    }
}
