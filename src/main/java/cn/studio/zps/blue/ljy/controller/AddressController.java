package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Address;
import cn.studio.zps.blue.ljy.service.AddressService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("addAddress")
    @ResponseBody
    public Map<String,Object> addAddress(@RequestBody Address address){
        if(addressService.addAddress(address)){
            return Response.getResponseMap(0,"添加成功",null);
        }else{
            return Response.getResponseMap(1,"添加失败",null);
        }
    }
    @RequestMapping("deleteAddress")
    @ResponseBody
    public Map deleteAddress(@RequestParam("addressID") int addressID){
        if(addressService.deleteAddress(addressID)){
            return Response.getResponseMap(0,"删除成功",null);
        }else{
            return Response.getResponseMap(1,"删除失败",null);
        }
    }
    @RequestMapping("getAddress")
    @ResponseBody
   public Map<String,Object> getAddress(@RequestParam(name = "limit",required = false) Integer limit ,
                                        @RequestParam(name = "page" , required = false) Integer page,
                                        @RequestParam(name = "name" , required = false) String name){
       if(limit==null||page==null) {
           page=null;
           limit=null;
       } else {
           page=(page-1)*limit;
       }
       Map map = addressService.getAllAddress(name, page, limit);
       map.put("code",0);
       map.put("msg","");
       return map;
    }

    @RequestMapping("updateAddress")
    @ResponseBody
    public Map updateAddress(@RequestBody Address address){
        if(addressService.updateAddress(address)){
            return Response.getResponseMap(0,"更新成功",null);
        }else{
            return Response.getResponseMap(1,"更新失败",null);
        }
    }

    /*
    前端接口
     */
    @RequestMapping("getAllAddress")
    @ResponseBody
    public List getAddressUI(){
       return addressService.getAddressUI();
    }
}
