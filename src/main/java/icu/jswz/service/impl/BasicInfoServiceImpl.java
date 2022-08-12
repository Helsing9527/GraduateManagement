package icu.jswz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.jswz.mapper.BasicInfoMapper;
import icu.jswz.pojo.BasicInfo;
import icu.jswz.service.IBasicInfoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicInfoServiceImpl extends ServiceImpl<BasicInfoMapper, BasicInfo> implements IBasicInfoService {

    @Autowired
    private BasicInfoMapper basicInfoMapper;
    @Override
    public IPage<BasicInfo> getPage(Integer currentPage, Integer pageSize, BasicInfo basicInfo) {
        LambdaQueryWrapper<BasicInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(basicInfo.getName()), BasicInfo::getName, basicInfo.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(basicInfo.getGrade()), BasicInfo::getGrade, basicInfo.getGrade());
        IPage<BasicInfo> page = new Page<>(currentPage, pageSize);
        basicInfoMapper.selectPage(page, lambdaQueryWrapper);
        return page;
    }
}
