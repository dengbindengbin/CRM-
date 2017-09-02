package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.IntegralChange;
import com._520it.crm.mapper.IntegralChangeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IIntegralChangeService;
@Service
public class IntegralChangeServiceImpl implements IIntegralChangeService {
    @Autowired
    private IntegralChangeMapper integralChangeMapper;

    public int deleteByPrimaryKey(Long id) {
        return integralChangeMapper.deleteByPrimaryKey(id);
    }

    public int insert(IntegralChange record) {
        return integralChangeMapper.insert(record);
    }

    public IntegralChange selectByPrimaryKey(Long id) {
        return integralChangeMapper.selectByPrimaryKey(id);
    }

    public List<IntegralChange> selectAll() {
        return integralChangeMapper.selectAll();
    }

    public int updateByPrimaryKey(IntegralChange record) {
        return integralChangeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPage(QueryObject qo) {
        Long count = integralChangeMapper.queryPageCount(qo);
        if(count<=0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<IntegralChange> result = integralChangeMapper.queryPageData(qo);
        PageResult pageResult = new PageResult(count,result);
        return pageResult;
    }

    @Override
    public PageResult load(Long memberId) {
        List<IntegralChange> load = integralChangeMapper.load(memberId);
        PageResult result = new PageResult(1L, load);
        return result;
    }
}
