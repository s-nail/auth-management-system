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
package com.hundsun.auth.server.common.base;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hundsun.auth.base.dto.ResultDto;
import com.hundsun.auth.base.service.BaseService;
import com.hundsun.auth.server.common.util.MessageUtil;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author jiayq24996
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected abstract Mapper<T> getMapper();
	
	public ResultDto save(T t) {
		ResultDto rs = new ResultDto();
		try {
			getMapper().insert(t);
		}catch(Exception e) {
			e.printStackTrace ();
			return MessageUtil.getMessage (rs, "1000");
		}
		
		return rs;
	}

	public ResultDto update(T t) {
		ResultDto rs = new ResultDto();
		try {
			getMapper().updateByPrimaryKey (t);
		}catch(Exception e) {
			e.printStackTrace ();
			return MessageUtil.getMessage (rs, "1000");
		}
		
		return rs;
	}

	public ResultDto deleteById(Serializable id) {
		ResultDto rs = new ResultDto();
		try {
			getMapper().deleteByPrimaryKey(id);
		}catch(Exception e) {
			e.printStackTrace ();
			return MessageUtil.getMessage (rs, "1000");
		}
		return rs;
	}

	public T getById(Serializable id) {
		return getMapper().selectByPrimaryKey(id);
	}

	public List<T> getList() {
		return getMapper().selectAll();
	}

	public PageInfo<T> getListByPage(int currentNum, int pageSize) {
		PageHelper.startPage(currentNum, pageSize);
		List<T> list = this.getList();
		return new PageInfo<T>(list);
	}

}
