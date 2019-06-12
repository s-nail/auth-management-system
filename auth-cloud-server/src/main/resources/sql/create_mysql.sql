-- ----------------------------
-- Table structure for tsys_product
-- ----------------------------
CREATE TABLE tsys_product  (
  product_id varchar(32)  NOT NULL COMMENT '产品ID',
  licence_no varchar(128)  DEFAULT NULL COMMENT '许可证编号（GUID唯一字符串）',
  licence_type varchar(8)  DEFAULT NULL COMMENT '许可证类型（1：基础版、2：高级版）',
  user_info varchar(256)  DEFAULT NULL COMMENT '客户信息',
  product_info varchar(256)  DEFAULT NULL COMMENT '产品信息',
  begin_date varchar(8)  DEFAULT NULL COMMENT '开始时间',
  expire_date varchar(8) DEFAULT NULL COMMENT '过期时间',
  flow_control int  DEFAULT NULL COMMENT '流量控制',
  creator varchar(32)  DEFAULT NULL COMMENT '创建人',
  create_date varchar(20) NOT NULL COMMENT '创建时间',
  modify_date varchar(20) default NULL COMMENT '修改时间',
  PRIMARY KEY (product_id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品表';

-- ----------------------------
-- Table structure for tsys_product_module
-- ----------------------------
CREATE TABLE tsys_product_module  (
  module_id varchar(32)  NOT NULL COMMENT '模块ID',
  product_id varchar(32)  NOT NULL COMMENT '产品ID',
  module_no varchar(32)  NOT NULL COMMENT '模块编号',
  module_name varchar(128)  DEFAULT NULL COMMENT '模块名称',
  begin_date varchar(8)  DEFAULT NULL COMMENT '开始时间',
  expire_date varchar(8) DEFAULT NULL COMMENT '过期时间',
  max_connections int(11) default NULL  COMMENT '最大连接数',
  flow_control int  DEFAULT NULL COMMENT '流量控制',
  PRIMARY KEY (module_id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品模块表';

-- ----------------------------
-- Table structure for tsys_api
-- ----------------------------
CREATE TABLE tsys_api  (
  api_id varchar(32)  NOT NULL COMMENT '接口ID',
  module_id varchar(32)  NOT NULL COMMENT '模块ID',
  function_id varchar(32)  NOT NULL COMMENT '接口功能号',
  api_name varchar(128)  DEFAULT NULL COMMENT '接口名称',
  begin_date varchar(8)  DEFAULT NULL COMMENT '开始时间',
  expire_date varchar(8) DEFAULT NULL COMMENT '过期时间',
  flow_control int  DEFAULT NULL COMMENT '流量控制',
  PRIMARY KEY (api_id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '接口表';