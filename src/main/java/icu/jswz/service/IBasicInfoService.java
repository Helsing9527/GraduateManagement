package icu.jswz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.jswz.pojo.BasicInfo;

public interface IBasicInfoService extends IService<BasicInfo> {
    IPage<BasicInfo> getPage(Integer currentPage, Integer pageSize, BasicInfo basicInfo);
}
