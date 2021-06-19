package com.ptg.ptgchannelimpl.mapper;


import com.ptg.channel.po.ClChannelCodeValueConfig;
import com.ptg.channel.po.ClChannelCodeValueConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClChannelCodeValueConfigMapper {
    int countByExample(ClChannelCodeValueConfigExample example);

    int deleteByExample(ClChannelCodeValueConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClChannelCodeValueConfig record);

    int insertSelective(ClChannelCodeValueConfig record);

    List<ClChannelCodeValueConfig> selectByExample(ClChannelCodeValueConfigExample example);

    ClChannelCodeValueConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClChannelCodeValueConfig record, @Param("example") ClChannelCodeValueConfigExample example);

    int updateByExample(@Param("record") ClChannelCodeValueConfig record, @Param("example") ClChannelCodeValueConfigExample example);

    int updateByPrimaryKeySelective(ClChannelCodeValueConfig record);

    int updateByPrimaryKey(ClChannelCodeValueConfig record);
}