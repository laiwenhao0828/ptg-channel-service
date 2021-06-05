package com.ptg.ptgchannelimpl.mapper;


import com.ptg.channel.po.ClChannelSecretConfig;
import com.ptg.channel.po.ClChannelSecretConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ClChannelSecretConfigMapper {
    int countByExample(ClChannelSecretConfigExample example);

    int deleteByExample(ClChannelSecretConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClChannelSecretConfig record);

    int insertSelective(ClChannelSecretConfig record);

    List<ClChannelSecretConfig> selectByExample(ClChannelSecretConfigExample example);

    ClChannelSecretConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClChannelSecretConfig record, @Param("example") ClChannelSecretConfigExample example);

    int updateByExample(@Param("record") ClChannelSecretConfig record, @Param("example") ClChannelSecretConfigExample example);

    int updateByPrimaryKeySelective(ClChannelSecretConfig record);

    int updateByPrimaryKey(ClChannelSecretConfig record);
}