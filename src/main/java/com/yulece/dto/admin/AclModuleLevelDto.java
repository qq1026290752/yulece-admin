package com.yulece.dto.admin;

import com.google.common.collect.Lists;
import com.yulece.model.admin.AdminAclModule;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class AclModuleLevelDto extends AdminAclModule {

    private List<AclModuleLevelDto> aclModuleLevelDtos = Lists.newArrayList();

    public List<AclModuleLevelDto> getAclModuleLevelDtos() {
        return aclModuleLevelDtos;
    }

    public void setAclModuleLevelDtos(List<AclModuleLevelDto> aclModuleLevelDtos) {
        this.aclModuleLevelDtos = aclModuleLevelDtos;
    }

    public static AclModuleLevelDto adapt(AdminAclModule adminAclModule){
       AclModuleLevelDto aclModuleLevelDto = new AclModuleLevelDto();
       BeanUtils.copyProperties(adminAclModule,aclModuleLevelDto);
       return aclModuleLevelDto;
    }
}
