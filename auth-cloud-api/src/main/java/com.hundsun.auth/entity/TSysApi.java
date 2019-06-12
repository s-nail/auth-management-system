package com.hundsun.auth.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tsys_api")
public class TSysApi {
    @Id
    @Column(name = "function_id")
    private String functionId;

    private String moduleId;

    private String apiName;

    private String beginDate;

    private String expireDate;

    private Integer flowControl;
}