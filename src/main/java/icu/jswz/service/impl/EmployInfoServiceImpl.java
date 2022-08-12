package icu.jswz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.jswz.mapper.EmployInfoMapper;
import icu.jswz.pojo.EmployInfo;
import icu.jswz.service.IEmployInfoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployInfoServiceImpl extends ServiceImpl<EmployInfoMapper, EmployInfo> implements IEmployInfoService {

    @Autowired
    private EmployInfoMapper employInfoMapper;

    @Override
    public IPage<EmployInfo> getPage(Integer currentPage, Integer pageSize, EmployInfo employInfo) {
        LambdaQueryWrapper<EmployInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        IPage<EmployInfo> page = new Page<>(currentPage, pageSize);
        employInfoMapper.selectPage(page, lambdaQueryWrapper);
        return page;
    }
}
