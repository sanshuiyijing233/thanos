package com.thanos.soulgem.domain.basic;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.basic.command.EquipmentUpdate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
public class Equipment extends Aggregate{

  ObjectId companyId;
  String name;
  String category;
  String useTo;
  List<EquipmentParam> params;
  String specification;
  Long number;//设备编号
  String vendor; //厂家


  public Equipment(ObjectId companyId, String name,
      String category, String useTo, List<EquipmentParam> params,String specification,
      Long number, String vendor) {
    this.companyId = companyId;
    this.name = name;
    this.category = category;
    this.useTo = useTo;
    this.params = params;
    this.specification = specification;
    this.number = number;
    this.vendor = vendor;
  }

  /**
   * 合并修改
   */
  public void merge(EquipmentUpdate equipmentUpdate){
    this.name = equipmentUpdate.getName();
    this.category = equipmentUpdate.getCategory();
    this.useTo = equipmentUpdate.getUseTo();
    this.params = equipmentUpdate.getParams();
    this.vendor = equipmentUpdate.getVendor();
    this.number = equipmentUpdate.getNumber();
    this.specification = equipmentUpdate.getSpecification();
  }

  public void addParam(EquipmentParam param){
    params.add(param);
  }

}
