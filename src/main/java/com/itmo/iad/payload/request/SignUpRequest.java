package com.itmo.iad.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    public String login;
    public String password;
    public String firstName;
    public String lastName;
}
