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
@Table(name = "tsys_product_module")
public class TSysProductModule {
    @Id
    @Column(name = "module_id")
    private String moduleId;

    private String productId;

    private String moduleNo;

    private String moduleName;

    private String beginDate;

    private String expireDate;

    private Integer maxConnections;

    private Integer flowControl;

}