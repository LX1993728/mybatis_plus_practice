package com.my.utils;

import com.github.flying.cattle.mdg.entity.BasisInfo;
import com.github.flying.cattle.mdg.util.EntityInfoUtil;
import com.github.flying.cattle.mdg.util.Generator;
import com.github.flying.cattle.mdg.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2019
 *
 * <p>说明： 自动生成工具</P>
 * <p>源码地址：https://gitee.com/flying-cattle/mybatis-dsc-generator</P>
 */
public class MyGenerator {
    // 基础信息：项目名、作者、版本
    public static final String PROJECT = "my-test";
    public static final String AUTHOR = "liuxun";
    public static final String VERSION = "V1.0";
    // 数据库连接信息：连接URL、用户名、秘密、数据库名
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/mybatis_plus?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
    public static final String NAME = "root";
    public static final String PASS = "root";
    public static final String DATABASE = "mybatis_plus";
    // 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
    public static final String CLASSNAME = "User";
    public static final String TABLE = "user";
    public static final String CLASSCOMMENT = "用户";
    public static final String TIME = "2019年9月14日";
    public static final String AGILE = new Date().getTime() + "";
    // 路径信息，分开路径方便聚合工程项目，微服务项目
    public static final String FILE_URL = System.getProperty("user.dir") + "/generated_code/src/main/java/";
    public static final String BASE_URL = "com.liuxun";
    public static final String ENTITY_URL = BASE_URL + "." + "domain";
    public static final String DAO_URL = BASE_URL + "." + "mapper" ;
    public static final String XML_URL = "mapper";
    public static final String SERVICE_URL =  BASE_URL + "." + "service";
    public static final String SERVICE_IMPL_URL = SERVICE_URL + "." + "serviceImpl";
    public static final String CONTROLLER_URL =  BASE_URL + "." + "controllers";
    public static final String SWAGGER_CONFIG_URL =  BASE_URL + "." + "config";
    //是否是Swagger配置
    public static final String IS_SWAGGER = "false";

    public static void main(String[] args) {
        BasisInfo bi = new BasisInfo(PROJECT,AUTHOR,VERSION,URL,NAME,PASS,DATABASE,TIME,AGILE,ENTITY_URL,DAO_URL,XML_URL,SERVICE_URL,SERVICE_IMPL_URL,CONTROLLER_URL, "true");
        bi.setTable(TABLE);
        bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
        bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
        bi.setEntityComment(CLASSCOMMENT);
        bi.setSwaggerConfigUrl(SWAGGER_CONFIG_URL);
        try {
            bi = EntityInfoUtil.getInfo(bi);
            String fileUrl = FILE_URL;// 生成文件存放位置
            //开始生成文件
//            String aa1 = Generator.createEntity(fileUrl, bi).toString();
//            String aa2 = Generator.createDao(fileUrl, bi).toString();
//            String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
//            String aa4 = Generator.createService(fileUrl, bi).toString();
//            String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
//            String aa6 = Generator.createController(fileUrl, bi).toString();
//
//            System.out.println(aa1);
//            System.out.println(aa2); System.out.println(aa3); System.out.println(aa4);
//            System.out.println(aa5); System.out.println(aa6);
            if (Boolean.parseBoolean(bi.getIsSwagger())){
                String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();
                System.out.println(aa7);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
