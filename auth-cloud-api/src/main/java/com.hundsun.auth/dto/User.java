package com.hundsun.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String username;
    private String password;
}
