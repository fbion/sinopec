package com.sensenets.sinopec.buiness.controller;

import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.Product;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value="DemoController",tags="商品操作接口", description="DemoController")
@RequestMapping("/service/product")
@Slf4j
public class DemoController extends BaseController {

    @ApiOperation(value = "返回列表",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 401, message = "未授权，拒绝访问"),
            @ApiResponse(code = 403, message = "权限不足，禁止访问"),
            @ApiResponse(code = 404, message = "未找到资源")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public List<Product> list(){
        List<Product> productList = new ArrayList<Product>();
        return productList;
    }
    @ApiOperation(value = "查询商品根据id",response = Product.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Product showProduct(
            @PathVariable
            @ApiParam(name="商品id",value="整数类型",required=true) Integer id){
       Product product = new Product(id,"苹果");
        return product;
    }

    @ApiOperation(value = "增加商品")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(
            @RequestBody
            @ApiParam(name="商品对象",value="json类型",required=true)  Product product){
        return new ResponseEntity("增加商品成功", HttpStatus.OK);
    }

    @ApiOperation(value = "修改商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(
            @PathVariable
            @ApiParam(name="商品id",value="整数类型",required=true) Integer id,
            @RequestBody
            @ApiParam(name="商品对象",value="json类型",required=true) Product product){
        return new ResponseEntity("修改商品成功", HttpStatus.OK);
    }

    @ApiOperation(value = "删除商品")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> delete(
            @PathVariable
            @ApiParam(name="商品id",value="整数类型",required=true) Integer id){
        return new ResponseEntity("删除商品成功", HttpStatus.OK);

    }

}