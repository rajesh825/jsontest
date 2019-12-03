package com.test.json.datamodels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    public String userId;
    public String id;
    public String title;
    public String body;
}