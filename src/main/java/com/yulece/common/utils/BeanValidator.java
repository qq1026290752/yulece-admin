package com.yulece.common.utils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yulece.common.exception.VoParamException;
import org.apache.commons.collections.MapUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 校验器
 * @author wangyichao@28ph.cn
 * @Title: BeanValidator
 * @Package com.yulece.common.utils
 * @Description:
 * @Date 创建时间2018/5/6-9:45
 **/
public class BeanValidator {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();


    public static <T> Map<String,String> validate(T t,Class... grounds){
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validateResult = validator.validate(t, grounds);
        if(validateResult.isEmpty()){
            return Collections.EMPTY_MAP;
        }else {
            LinkedHashMap<String,String> errors = Maps.newLinkedHashMap();
            Iterator<ConstraintViolation<T>> iterator = validateResult.iterator();
            while (iterator.hasNext()){
                 ConstraintViolation violation = iterator.next();
                errors.put(violation.getPropertyPath().toString(),violation.getMessage());
            }
            return errors;
        }
    }


    public static Map<String,String> validateList(Collection<?> collection){
        Map<String,String> error = Maps.newLinkedHashMap();
        Preconditions.checkNotNull(collection);
        collection.stream().map(e -> validate(e, new Class[0]))
                .collect(Collectors.toList()).forEach((e)->error.putAll(e));
        return error;

    }

    public static Map<String,String> validateObject(Object object,Object... groups){
        if(groups!= null && groups.length > 0){
            return validateList(Lists.asList(object,groups));
        }else {
            return validate(object,new Class[0]);
        }
    }

    public static void check(Object object,Object... groups) throws VoParamException {
        Map<String, String> errors = validateObject(object, groups);
        if(MapUtils.isNotEmpty(errors)){
           throw  new VoParamException(errors.toString());
        }
    }
}
