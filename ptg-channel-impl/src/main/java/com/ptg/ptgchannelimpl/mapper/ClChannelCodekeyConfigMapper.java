package com.ptg.ptgchannelimpl.mapper;


import com.ptg.channel.po.ClChannelCodekeyConfig;
import com.ptg.channel.po.ClChannelCodekeyConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClChannelCodekeyConfigMapper {
    int countByExample(ClChannelCodekeyConfigExample example);

    int deleteByExample(ClChannelCodekeyConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClChannelCodekeyConfig record);

    int insertSelective(ClChannelCodekeyConfig record);

    List<ClChannelCodekeyConfig> selectByExample(ClChannelCodekeyConfigExample example);

    ClChannelCodekeyConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClChannelCodekeyConfig record, @Param("example") ClChannelCodekeyConfigExample example);

    int updateByExample(@Param("record") ClChannelCodekeyConfig record, @Param("example") ClChannelCodekeyConfigExample example);

    int updateByPrimaryKeySelective(ClChannelCodekeyConfig record);

    int updateByPrimaryKey(ClChannelCodekeyConfig record);
}