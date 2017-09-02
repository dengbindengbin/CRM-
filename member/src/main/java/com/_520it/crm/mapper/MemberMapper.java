package com._520it.crm.mapper;

import java.math.BigDecimal;
import java.util.List;

import com._520it.crm.domain.Member;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Member record);
    Member selectByPrimaryKey(Long id);
    List<Member> selectAll();
    int updateByPrimaryKey(Member record);
	Long queryPageCount(QueryObject qo);
	List<Member> queryPageData(QueryObject qo);

    Member load();

    Long queryMemberCount();

    Long queryBirday(String format);

    List<BigDecimal> queryTotalAmount();

    int memberByPaymentId(@Param("id") Long id,@Param("totalMoney") BigDecimal totalMoney);

    int IntegralChangeByPaymentId(@Param("id") Long id,@Param("integral") BigDecimal integral);

    int memberdeleteIntegral(Long id);

    int memberState(@Param("id") Long id,@Param("state") int leave);

    int memberUpdatePhone(@Param("id")Long id,@Param("phone") String phone);
}