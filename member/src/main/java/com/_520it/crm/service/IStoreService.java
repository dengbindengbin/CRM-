package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.Store;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IStoreService {
	int deleteByPrimaryKey(Long id);
    int insert(Store record);
    Store selectByPrimaryKey(Long id);
    List<Store> getParent();
    List<Store> selectAll();
    int updateByPrimaryKey(Store record);
	PageResult queryPage(QueryObject qo);
}
