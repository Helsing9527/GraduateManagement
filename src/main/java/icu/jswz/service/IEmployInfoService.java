package icu.jswz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.jswz.pojo.EmployInfo;

public interface IEmployInfoService extends IService<EmployInfo> {
    IPage<EmployInfo> getPage(Integer currentPage, Integer pageSize, EmployInfo employInfo);
}
