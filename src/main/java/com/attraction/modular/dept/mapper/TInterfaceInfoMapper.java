package com.attraction.modular.dept.mapper;

import com.attraction.modular.dept.entity.TInterfaceInfo;
import com.attraction.modular.dept.entity.TInterfaceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TInterfaceInfoMapper {
    int countByExample(TInterfaceInfoExample example);

    int deleteByExample(TInterfaceInfoExample example);

    int deleteByPrimaryKey(Integer interfaceId);

    int insert(TInterfaceInfo record);

    int insertSelective(TInterfaceInfo record);

    List<TInterfaceInfo> selectByExample(TInterfaceInfoExample example);

    TInterfaceInfo selectByPrimaryKey(Integer interfaceId);

    int updateByExampleSelective(@Param("record") TInterfaceInfo record, @Param("example") TInterfaceInfoExample example);

    int updateByExample(@Param("record") TInterfaceInfo record, @Param("example") TInterfaceInfoExample example);

    int updateByPrimaryKeySelective(TInterfaceInfo record);

    int updateByPrimaryKey(TInterfaceInfo record);
}