package com.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhl on 2021/8/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    private long id;
    private long userId;
    private String role;
}
