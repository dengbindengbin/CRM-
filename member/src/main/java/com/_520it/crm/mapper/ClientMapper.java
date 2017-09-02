package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Client;
import com._520it.crm.domain.Product;
import com._520it.crm.query.QueryObject;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Client record);
    Client selectByPrimaryKey(Long id);
    List<Client> selectAll();
    List<Client> selectToall();
    int updateByPrimaryKey(Client record);
	Long queryPageCount(QueryObject qo);
	List<Client> queryPageData(QueryObject qo);
	void insertRelation(@Param("clientId")Long clientId,@Param("productId")Long productId);
    void deleteRelation(Long clientId);
    List<Product> getProductByClientId(Long clientId);
}