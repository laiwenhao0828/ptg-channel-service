package com.ptg.ptgchannelimpl.mapper;


import com.ptg.channel.po.ClHttpConfig;
import com.ptg.channel.po.ClHttpConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ClHttpConfigMapper {
    int countByExample(ClHttpConfigExample example);

    int deleteByExample(ClHttpConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClHttpConfig record);

    int insertSelective(ClHttpConfig record);

    List<ClHttpConfig> selectByExample(ClHttpConfigExample example);

    ClHttpConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClHttpConfig record, @Param("example") ClHttpConfigExample example);

    int updateByExample(@Param("record") ClHttpConfig record, @Param("example") ClHttpConfigExample example);

    int updateByPrimaryKeySelective(ClHttpConfig record);

    int updateByPrimaryKey(ClHttpConfig record);
}