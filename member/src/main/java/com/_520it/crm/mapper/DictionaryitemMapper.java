package com._520it.crm.mapper;

import com._520it.crm.domain.Dictionaryitem;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryitemMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Dictionaryitem record);
    Dictionaryitem selectByPrimaryKey(Long id);
    List<Dictionaryitem> selectAll();
    int updateByPrimaryKey(Dictionaryitem record);
	Long queryPageCount(QueryObject qo);
	List<Dictionaryitem> queryPageData(QueryObject qo);

    List<Dictionaryitem> queryByDictionId(Long id);
}