package com.bookmyshow.BookMyShow.payloads;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter@Setter
@Component
@Data
@NoArgsConstructor@AllArgsConstructor
public class UserDto {
    private String userName;
    private String email;
}
