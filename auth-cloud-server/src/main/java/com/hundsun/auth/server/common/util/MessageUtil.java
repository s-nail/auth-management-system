/*
 * 系统名称: 应用快速开发企业套件
 * 模块名称: 基础业务框架V2.0
 * 软件版权: 杭州恒生电子股份有限公司
 * 相关文档:
 * 修改记录:
 * 修改日期		修改人员		修改说明<BR>
 * ==========================================================
 *
 *
 * ==========================================================
 * 评审记录：
 *
 * 评审人员：
 * 评审日期：
 * 发现问题：
 */
package com.hundsun.auth.server.common.util;


import com.hundsun.auth.base.dto.ResultDto;
import com.hundsun.auth.util.ExceptionPropertiesUtil;

public class MessageUtil {
    public static ResultDto getMessage(ResultDto rs, String errNo) {
        rs.setCode("0");
        rs.setMessage(ExceptionPropertiesUtil.getMessage(errNo));
        rs.getMessage();
        return rs;
    }
}
