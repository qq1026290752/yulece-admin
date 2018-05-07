package com.yulece.admin.service.admin.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.yulece.admin.common.utils.LevelUtil;
import com.yulece.admin.dto.admin.DeptLevelDto;
import com.yulece.admin.model.admin.AdminDept;
import com.yulece.admin.repository.admin.DeptRepository;
import com.yulece.admin.service.admin.DeptService;
import com.yulece.admin.service.admin.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: TreeServiceImpl
 * @Package com.yulece.admin.service.admin.impl
 * @Description:
 * @Date 创建时间2018/5/7-21:02
 **/
@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private DeptRepository deptRepository;

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
        return deptLevelDtos;
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
            if(CollectionUtils.isEmpty(deptLevelList)){
                //排序
                Collections.sort(deptLevelList, deptSeqComparator);
                //把下一层加入到本层
                deptLevelDto.setDeptLevelDtos(deptLevelList);
                //开始递归下一层
                transformDeptTree(deptLevelList,nextLevel,deptLevelDtoMap);
            }
        }
    }


    private Comparator<DeptLevelDto> deptSeqComparator = new Comparator<DeptLevelDto>() {
        @Override
        public int compare(DeptLevelDto o1, DeptLevelDto o2) {
            return o1.getDeptSeq() - o2.getDeptSeq();
        }
    };
}
