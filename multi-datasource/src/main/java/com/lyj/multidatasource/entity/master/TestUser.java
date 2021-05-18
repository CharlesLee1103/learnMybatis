package com.lyj.multidatasource.entity.master;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author charlesliyongjie
 * @since 2021-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 职称职别
     */
    private String title;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生时间
     */
    private LocalDate dateOfBirth;

    /**
     * 1:已删除,0:未删除
     */
    private Boolean deleted;

    private LocalDateTime sysCreateTime;

    private String sysCreateUser;

    private LocalDateTime sysUpdateTime;

    private String sysUpdateUser;

    private Long recordVersion;


}
