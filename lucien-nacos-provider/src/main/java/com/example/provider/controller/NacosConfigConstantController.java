package com.example.provider.controller;

import com.example.provider.aop.annotation.OperationLog;
import com.example.provider.service.NacosConfigConstantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TestController
 * @User zhang
 * @Description 测试打印nacos配置中心常量
 * @Author Lucien
 * @Date 2020/10/14 14:25
 * @Version 1.0
 */
@Log4j2
@RestController
@RefreshScope
@RequestMapping(value = "/dev-api")
public class NacosConfigConstantController {

    @Value("${nacos.constant}")
    private String nacosConstant;
    @Resource
    private NacosConfigConstantService nacosConfigConstantService;

    @OperationLog(operEvent = "获取nacos配置的常量", operType = 1)
    @GetMapping(value = "/getNacosConstant")
    public String getNacosConstant() {
        return nacosConfigConstantService.getNacosConstant(this.nacosConstant);
    }
}