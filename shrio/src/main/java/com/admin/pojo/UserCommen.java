package com.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhl on 2021/8/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommen implements Serializable {
    private long id;
    private String name;
    private String pass;
    private String role;
}
