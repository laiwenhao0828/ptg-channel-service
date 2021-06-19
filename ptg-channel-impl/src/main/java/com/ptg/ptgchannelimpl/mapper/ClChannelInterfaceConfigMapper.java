package com.ptg.ptgchannelimpl.mapper;


import com.ptg.channel.po.ClChannelInterfaceConfig;
import com.ptg.channel.po.ClChannelInterfaceConfigExample;
import com.ptg.channel.req.ChannelParamConfig;
import com.ptg.channel.resp.ChannelRespConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ClChannelInterfaceConfigMapper {
    int countByExample(ClChannelInterfaceConfigExample example);

    int deleteByExample(ClChannelInterfaceConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClChannelInterfaceConfig record);

    int insertSelective(ClChannelInterfaceConfig record);

    List<ClChannelInterfaceConfig> selectByExample(ClChannelInterfaceConfigExample example);

    ClChannelInterfaceConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClChannelInterfaceConfig record, @Param("example") ClChannelInterfaceConfigExample example);

    int updateByExample(@Param("record") ClChannelInterfaceConfig record, @Param("example") ClChannelInterfaceConfigExample example);

    int updateByPrimaryKeySelective(ClChannelInterfaceConfig record);

    int updateByPrimaryKey(ClChannelInterfaceConfig record);

    ChannelParamConfig queryConfigByInterfaceName(@Param("interfaceName") String interfaceName);
    /**
     * 查询通道返回配置
     * */
    List<ChannelRespConfig> queryChannelRespConfig(String interfaceName);
}