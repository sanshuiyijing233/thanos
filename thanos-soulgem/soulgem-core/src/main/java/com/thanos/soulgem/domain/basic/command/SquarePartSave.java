package com.thanos.soulgem.domain.basic.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.basic.SquarePart;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class SquarePartSave extends Validator<SquarePartSave> {

  @NotNull
  ObjectId equipmentId;
  @NotNull
  String name;
  @NotNull
  String specifications;//规格型号
  @NotNull
  String installLocation;
  @NotNull
  String unit;
  @NotNull
  Long initialAmount;//装机数量
  @NotNull
  String technicalParameters;//技术参数

  String others;

  public SquarePart build(){
    SquarePart squarePart = new SquarePart();
    BeanUtils.copyProperties(this, squarePart);
    return squarePart;
  }


}
