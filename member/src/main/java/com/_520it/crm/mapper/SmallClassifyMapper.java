package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.SmallClassify;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.SmallClassifyQueryObject;

public interface SmallClassifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmallClassify record);

    SmallClassify selectByPrimaryKey(Long id);

    List<SmallClassify> selectAll();
    
    List<SmallClassify> selectByClassify(Long parentId);
    
    int updateByPrimaryKey(SmallClassify record);
    
	Long queryPageCount(SmallClassifyQueryObject qo);

	List<SmallClassify> queryPageData(SmallClassifyQueryObject qo);

	void deleteRelation(Long id);

	void insertRelation(@Param("productId")Long productId,@Param("kendId") Long kendId);
    
}