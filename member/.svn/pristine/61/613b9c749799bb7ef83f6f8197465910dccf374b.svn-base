package com._520it.crm.mapper;

import com._520it.crm.domain.Store;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Store record);
    Store selectByPrimaryKey(Long id);
    List<Store> getParent();
    List<Store> selectAll();
    int updateByPrimaryKey(Store record);
	Long queryPageCount(QueryObject qo);
	List<Store> queryPageData(QueryObject qo);
}