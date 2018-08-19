package com.thanos.soulgem.domain.common;

import com.thanos.soulgem.domain.exception.ApplicationException;
import com.thanos.soulgem.domain.exception.IllegalInputException;
import com.thanos.soulgem.domain.exception.ResultCase;
import com.thanos.soulgem.domain.exception.ResultCase.Id;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.ValidatorFactory;

/**
 * Create by zhangzheng on 8/4/18
 * Email:zhangzheng@youzan.com
 */
public abstract class Validator<T> {


  public void validate(){
    try {
      Set<ConstraintViolation<T>> constraintViolations =  Validation.buildDefaultValidatorFactory().getValidator().validate(
          (T)this);
      StringBuffer buf = new StringBuffer();
      for(ConstraintViolation<T> violation: constraintViolations) {
        buf.append(violation.getPropertyPath().toString()).append(" ");
        buf.append(violation.getMessage() + "\n");
      }
      throw new IllegalInputException(buf.toString());
    }catch (IllegalArgumentException | ValidationException e){
      throw new ApplicationException(Id.internal_error,e.getMessage());
    }
  }


}