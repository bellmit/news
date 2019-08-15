package com.cwb.news.sys.service;

import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysZdlm;
import com.cwb.news.util.bean.ApiResponse;

import java.util.List;

/**
 * auther chenwei
 * create at 2018/2/27
 */
public interface ZdlmService extends BaseService<SysZdlm,String>{
    ApiResponse<String> add(SysZdlm zdxm);
    ApiResponse<String> removeWithCheck(String id);
    ApiResponse<String> removesWithCheck(List<String> ids);
    void setZdxms(List<SysZdlm> zdlmList);
}
