package com._520it.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.TransfersRecords;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface ITransfersRecordsService {

	void insert(@Param("record")Product record,@Param("wId") Long wId, @Param("sId")Long sId);

	List<TransfersRecords> selectAll();

	PageResult queryPage(QueryObject qo);
}
