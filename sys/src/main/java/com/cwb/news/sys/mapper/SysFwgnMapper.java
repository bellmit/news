package com.cwb.news.sys.mapper;

import com.cwb.news.sys.model.SysGn;
import com.cwb.news.util.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.FifoCache;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace(implementation=MybatisRedisCache.class, eviction=FifoCache.class)
public interface SysFwgnMapper extends Mapper<SysGn> {
}