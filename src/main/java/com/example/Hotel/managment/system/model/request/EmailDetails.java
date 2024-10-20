package com.example.Hotel.managment.system.model.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String emailBody;
    private String emailSubject;
}
