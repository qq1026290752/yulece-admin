package com.yulece.service.admin.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.yulece.common.utils.LevelUtil;
import com.yulece.dto.admin.AclModuleLevelDto;
import com.yulece.dto.admin.DeptLevelDto;
import com.yulece.model.admin.AdminAclModule;
import com.yulece.model.admin.AdminDept;
import com.yulece.repository.admin.AclModelRepository;
import com.yulece.repository.admin.DeptRepository;
import com.yulece.service.admin.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: TreeServiceImpl
 * @Package com.yulece.service.admin.impl
 * @Description:
 * @Date 创建时间2018/5/7-21:02
 **/
@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private AclModelRepository aclModelRepository;

    @Override
    public List<DeptLevelDto> deptTree() {
        //获取所有部门列表
        List<AdminDept> adminDepts = deptRepository.findAll();
        //准备存放所有数据
        List<DeptLevelDto> deptLevelDtos = Lists.newArrayList();

        for(AdminDept adminDept :adminDepts){
            DeptLevelDto deptLevelDto = DeptLevelDto.adapt(adminDept);
            deptLevelDtos.add(deptLevelDto);
        }
        return deptToTree(deptLevelDtos);
    }

    @Override
    public List<AclModuleLevelDto> aclModuleTree() {
        //获取全部权限模块列表
        List<AdminAclModule> adminAclModules = aclModelRepository.findAll();
        List<AclModuleLevelDto> aclModuleLevelDtos = Lists.newArrayList();
        for (AdminAclModule aclModule:adminAclModules){
            aclModuleLevelDtos.add(AclModuleLevelDto.adapt(aclModule));
        }
        return aclModuleToTree(aclModuleLevelDtos);
    }

    private List<AclModuleLevelDto> aclModuleToTree(List<AclModuleLevelDto> aclModuleLevelDtos) {
        if(CollectionUtils.isEmpty(aclModuleLevelDtos)){
            return Lists.newArrayList();
        }
        Multimap<String,AclModuleLevelDto> aclModuleLevelDtoMultimap = ArrayListMultimap.create();
        List<AclModuleLevelDto> rootTree = Lists.newArrayList();
        for (AclModuleLevelDto aclModuleLevelDto:aclModuleLevelDtos){
            if (aclModuleLevelDto.getModuleLevel().equals(LevelUtil.ROOT)){
                rootTree.add(aclModuleLevelDto);
            }
        }
        Collections.sort(rootTree,aclModuleLevelDtoComparator);
        transformAclModuleTree(rootTree,LevelUtil.ROOT,aclModuleLevelDtoMultimap);
        return rootTree;
    }



    private List<DeptLevelDto> deptToTree(List<DeptLevelDto> deptLevelDtos){
        //判断集合是否为空
        if(CollectionUtils.isEmpty(deptLevelDtos)){
            return Lists.newArrayList();
        }

        Multimap<String,DeptLevelDto> deptLevelDtoMap = ArrayListMultimap.create();
        List<DeptLevelDto> rootList = Lists.newArrayList();

        for (DeptLevelDto deptLevelDto:deptLevelDtos){
            deptLevelDtoMap.put(deptLevelDto.getDeptLevel(),deptLevelDto);
            if(LevelUtil.ROOT.equals(deptLevelDto.getDeptLevel())){
                rootList.add(deptLevelDto);
        }
        }
        //同一层级下 按照seq从大到小排序
        Collections.sort(rootList, deptSeqComparator);
        //循环递归树
        transformDeptTree(rootList,LevelUtil.ROOT,deptLevelDtoMap);
        return rootList;
    }

    private void transformDeptTree(List<DeptLevelDto> deptLevelDtos,String level,Multimap<String,DeptLevelDto> deptLevelDtoMap){
        for (int i= 0;i < deptLevelDtos.size();i++){
            //循环遍历每个元素
            DeptLevelDto deptLevelDto = deptLevelDtos.get(i);
            //处理当前层数据拿到下一层数据
            String nextLevel = LevelUtil.calculateLevel(level, deptLevelDto.getDeptId());
            //拿到下一层数据
            List<DeptLevelDto> deptLevelList = (List<DeptLevelDto>) deptLevelDtoMap.get(nextLevel);
            //下一层排序
            if(!CollectionUtils.isEmpty(deptLevelList)){
                //排序
                Collections.sort(deptLevelList, deptSeqComparator);
                //把下一层加入到本层
                deptLevelDto.setDeptLevelDtos(deptLevelList);
                //开始递归下一层
                transformDeptTree(deptLevelList,nextLevel,deptLevelDtoMap);
            }
        }
    }

    private void transformAclModuleTree(List<AclModuleLevelDto> rootTree, String level, Multimap<String, AclModuleLevelDto> aclModuleLevelDtoMultimap) {
        for (int i = 0 ;i<rootTree.size();i++){
            //得到当前的AclModuleLevelDto
            AclModuleLevelDto aclModuleDto = rootTree.get(i);
            //拿到下一层级的数据level
            String nextLevel = LevelUtil.calculateLevel(level,aclModuleDto.getModuleId());
            //拿到下一层级的数据
            List<AclModuleLevelDto> moduleDtos = (List<AclModuleLevelDto>)aclModuleLevelDtoMultimap.get(nextLevel);
            //判断是否存在下一层级
            if(!CollectionUtils.isEmpty(moduleDtos)){
                //對下一層級排序
                Collections.sort(moduleDtos,aclModuleLevelDtoComparator);
                //将本层级加入下一层级
                aclModuleDto.setAclModuleLevelDtos(moduleDtos);
                //开始递归下一层
                transformAclModuleTree(moduleDtos,nextLevel,aclModuleLevelDtoMultimap);

            }
        }

    }

    private Comparator<DeptLevelDto> deptSeqComparator = new Comparator<DeptLevelDto>() {
        @Override
        public int compare(DeptLevelDto o1, DeptLevelDto o2) {
            return o1.getDeptSeq() - o2.getDeptSeq();
        }
    };
    private Comparator<AclModuleLevelDto> aclModuleLevelDtoComparator = new Comparator<AclModuleLevelDto>() {
        @Override
        public int compare(AclModuleLevelDto o1, AclModuleLevelDto o2) {
            return o1.getModuleSeq() - o2.getModuleSeq();
        }
    };
}
