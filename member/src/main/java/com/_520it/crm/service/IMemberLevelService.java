package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.MemberLevel;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IMemberLevelService {
	int deleteByPrimaryKey(Long id);
    int insert(MemberLevel record);
    MemberLevel selectByPrimaryKey(Long id);
    List<MemberLevel> selectAll();
    int updateByPrimaryKey(MemberLevel record);
	PageResult queryPage(QueryObject qo);
}
