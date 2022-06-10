package com.example.javapractice.designpattern.proxy.domain;

import com.example.javapractice.designpattern.proxy.Reply;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private int id;
    private String title;
    private String content;
    private List<Reply> replies = new ArrayList<>();

}
