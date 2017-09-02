package com._520it.crm.mapper;

import com._520it.crm.domain.Expend;
import com._520it.crm.query.ExpendQuery;

import java.util.List;

public interface ExpendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Expend record);

    Expend selectByPrimaryKey(Long id);

    List<Expend> selectAll(ExpendQuery qo);

    int updateByPrimaryKey(Expend record);
    
    Long count(ExpendQuery qo);
    
    List<Expend> queryPageResult(ExpendQuery qo);
    
    List<Expend>  selectParent();
    
    List<Expend>  selectChild(Long parentId);
}