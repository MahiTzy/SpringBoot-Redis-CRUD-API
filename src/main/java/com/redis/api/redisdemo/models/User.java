package com.redis.api.redisdemo.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable{
    private String id;
    private String name;
    private String phone;
    private String email;
}
