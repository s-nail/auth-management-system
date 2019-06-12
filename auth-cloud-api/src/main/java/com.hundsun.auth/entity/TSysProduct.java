package com.hundsun.auth.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "tsys_product")
public class TSysProduct {
    @Id
    @Column(name = "product_id")
    private String productId;

    private String licenceNo;

    private String licenceType;

    private String userInfo;

    private String productInfo;

    private String beginDate;

    private String expireDate;

    private Integer flowControl;

    private String creator;

    private Long createDate;

    private Long modifyDate;

}