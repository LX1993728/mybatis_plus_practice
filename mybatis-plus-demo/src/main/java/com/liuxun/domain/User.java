/**
 * @filename:User 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2020 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户实体类</P>
 * @version: V1.0
 * @author: liuxun
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

	private static final long serialVersionUID = 1576324413883L;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private Date createTime;
    
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "ID" )
	private Long id;
    
	@ApiModelProperty(name = "loginAddr" , value = "登录地址")
	private String loginAddr;
    
	@ApiModelProperty(name = "loginIp" , value = "登录IP地址")
	private String loginIp;
    
	@ApiModelProperty(name = "loginName" , value = "登录名")
	private String loginName;
    
	@ApiModelProperty(name = "nickname" , value = "昵称")
	private String nickname;
    
	@ApiModelProperty(name = "note" , value = "备注")
	private String note;
    
	@ApiModelProperty(name = "password" , value = "秘密")
	private String password;
    
	@ApiModelProperty(name = "state" , value = "状态：-1失败，0等待,1成功")
	private Integer state;
    
	@ApiModelProperty(name = "type" , value = "类型")
	private Integer type;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "updateTime" , value = "更新时间")
	private Date updateTime;
    
	@ApiModelProperty(name = "updateUid" , value = "修改人用户ID")
	private Long updateUid;
    

	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
