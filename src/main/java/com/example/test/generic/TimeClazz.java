package com.example.test.generic;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeClazz {

    private LocalDateTime date = LocalDateTime.now();

}
