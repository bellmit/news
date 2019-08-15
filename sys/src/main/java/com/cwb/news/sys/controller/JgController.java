package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.bean.TreeNode;
import com.cwb.news.sys.model.SysJg;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.sys.service.JgService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jg")
public class JgController extends BaseController<SysJg, String> {
	@Autowired
	private JgService jgService;

	@Override
	protected BaseService<SysJg, String> getBaseService() {
		return jgService;
	}

	@RequestMapping("add")
	public ApiResponse<String> add(SysJg entity) {
		return jgService.saveEntity(entity);
	}

	@RequestMapping("getOrgTree")
	public ApiResponse<List<SysJg>> getOrgTree(String jgmc) {
		return jgService.getOrgTree(jgmc);
	}

	@RequestMapping("getTree")
	public ApiResponse<List<TreeNode>> getTree(){
		return jgService.getTree();
	}

	@Override
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public ApiResponse<String> save(SysJg jg) {
		return jgService.saveEntity(jg);
	}

	@RequestMapping("getSubOrgList")
	public ApiResponse<List<SysJg>> getSubOrgList(String jgmc){
		SysYh user = getCurrentUser();
		List<SysJg> orgList = jgService.findAllSubOrg(user.getJgdm(),jgmc);
		return ApiResponse.success(orgList);
	}

}
