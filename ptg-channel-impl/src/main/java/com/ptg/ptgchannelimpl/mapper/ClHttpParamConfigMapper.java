package com.ptg.ptgchannelimpl.mapper;


import com.ptg.channel.po.ClHttpParamConfig;
import com.ptg.channel.po.ClHttpParamConfigExample;
import com.ptg.channel.req.ChannelHttpParamConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ClHttpParamConfigMapper {
    int countByExample(ClHttpParamConfigExample example);

    int deleteByExample(ClHttpParamConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClHttpParamConfig record);

    int insertSelective(ClHttpParamConfig record);

    List<ClHttpParamConfig> selectByExample(ClHttpParamConfigExample example);

    ClHttpParamConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClHttpParamConfig record, @Param("example") ClHttpParamConfigExample example);

    int updateByExample(@Param("record") ClHttpParamConfig record, @Param("example") ClHttpParamConfigExample example);

    int updateByPrimaryKeySelective(ClHttpParamConfig record);

    int updateByPrimaryKey(ClHttpParamConfig record);

    List<ChannelHttpParamConfig> queryHttpParams(@Param("httpParamId") String httpParamId);
}