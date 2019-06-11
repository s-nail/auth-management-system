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
package com.hundsun.auth.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class ExceptionPropertiesUtil {

    public static final String ERROR_PREFIX = "AUTH";
    /**
     * 错误代码
     */
    public static final String ERROR_DEFAULT = "1000";

    public static final String ERROR_PLUGIN_DATABASE = "1001";

    public static final String ERROR_PLUGIN_LOGGER = "1002";

    public static final String ERROR_PLUGIN_CACHE = "1012";

    public static final String ERROR_INPUT_INVALID = "1013";

    public static final String ERROR_DESIGN_DELETE = "1014";

    public static final String ERROR_INSERT = "1003";

    public static final String ERROR_UPDATE = "1004";

    public static final String ERROR_DELETE = "1005";

    public static final String ERROR_QUERY = "1006";
    /**
     * 异常信息配置文件路径
     */
    private static final String EXCEPTION_PROPERTIES_FILE_PATH = "errorMessageFormat.properties";

    /**
     * 异常信息配置
     */
    private static Properties exceptionProperties = new Properties();

    static {
        try {
            InputStream stream = ExceptionPropertiesUtil.class.getClassLoader().getResourceAsStream(EXCEPTION_PROPERTIES_FILE_PATH);
            exceptionProperties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 格式化异常信息
     *
     * @param code
     * @param message
     * @return
     */
    public static String format(String code, Object... message) {
        String pattern = exceptionProperties.getProperty(code);
        if (pattern != null) {
            return MessageFormat.format(pattern, message);
        } else {
            return MessageFormat.format("{0}", message);
        }

    }

    public static String getMessage(String code) {
        String errInfo = format(ERROR_PREFIX + code);
        return errInfo;
    }

}
