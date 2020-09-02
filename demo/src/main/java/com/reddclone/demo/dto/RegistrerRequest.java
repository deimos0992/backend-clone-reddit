package com.reddclone.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrerRequest {

    private String email;
    private String username;
    private String password;

}
