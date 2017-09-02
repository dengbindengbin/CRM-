package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.Client;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IClientService {
	int deleteByPrimaryKey(Long id);
    int insert(Client record);
    Client selectByPrimaryKey(Long id);
    List<Client> selectAll();
    List<Client> selectToall();
    int updateByPrimaryKey(Client record);
	PageResult queryPage(QueryObject qo);
}
