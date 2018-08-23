package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.OrgCondition;
import com.sensenets.sinopec.buiness.model.two.Org;
import com.sensenets.sinopec.buiness.service.IOrgService;
import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.ResponseInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

 /**
  * @ClassName: OrgController
  * @Description: 测试控制层
  * @author think
  * @date 2018年08月07日 10:40:56
  */
  
@RestController
@Api(value="OrgController", tags = "测试接口", description="OrgController")
@RequestMapping(value = "/service/org",produces = {APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class OrgController extends BaseController {

    @Autowired
    IOrgService orgService;
    
    @ApiOperation(value = "列表")
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public ResponseInfo list(Model model){
        List<Org> list = orgService.findAll();
        return this.warpObject(list);
    }


    @ApiOperation(value = "分页列表")
    @RequestMapping(value = "/listPage", method= RequestMethod.POST, produces = "application/json")
    public ResponseInfo listPage(@RequestBody OrgCondition condition){
        PageInfo<Org> page = orgService.findPage(condition);
        return this.warpPageObject(page);
    }
    
    @ApiOperation(value = "根据id查询")
    @RequestMapping(value = "/query/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseInfo findProduct(@PathVariable Long id){
        return this.warpObject(orgService.findById(id));
    }

    @ApiOperation(value = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseInfo saveProduct(@RequestBody Org org){
        return this.warpObject(orgService.save(org));
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseInfo updateProduct(@PathVariable Long id, @RequestBody Org org){
        return this.warpObject(orgService.updateById(org));
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseInfo delete(@PathVariable Long id){
        return this.warpObject(orgService.deleteById(id));
    }
    
}
