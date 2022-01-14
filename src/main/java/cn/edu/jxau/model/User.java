package cn.edu.jxau.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;

    private String userId;

    private String username;

    private String password;


}
