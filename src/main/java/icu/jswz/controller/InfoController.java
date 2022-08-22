package icu.jswz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.jswz.pojo.BasicInfo;
import icu.jswz.pojo.EmployInfo;
import icu.jswz.service.IBasicInfoService;
import icu.jswz.service.IEmployInfoService;
import icu.jswz.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InfoController {

    @Autowired
    private IBasicInfoService basicInfoService;

    @Autowired
    private IEmployInfoService employInfoService;

    // 查询毕业生基本信息
    @GetMapping("/basic/{currentPage}/{pageSize}")
    public R queryBasic(@PathVariable Integer currentPage, @PathVariable Integer pageSize, BasicInfo basicInfo) {
        IPage<BasicInfo> page = basicInfoService.getPage(currentPage, pageSize, basicInfo);
        if (currentPage > page.getPages()) {
            page = basicInfoService.getPage((int) page.getPages(), pageSize, basicInfo);
        }
        return new R(true, page, null);
    }

    // 新增毕业生基本信息
    @PostMapping("/basic")
    public R createBasic(@RequestBody BasicInfo basicInfo) {
        boolean save = basicInfoService.save(basicInfo);
        if (save) {
            return new R(true, null, "成功啦~");
        }
        return new R(false, null, "服务器出差去了~重新提交吧~");
    }

    // 修改毕业生基本信息
    @PutMapping("/basic")
    public R updateBasic(@RequestBody BasicInfo basicInfo) {
        boolean update = basicInfoService.updateById(basicInfo);
        if (update) {
            return new R(true, null, "修改成功");
        }
        return new R(false, null, "服务器被炸了...修改失败...");
    }

    // 删除毕业生基本信息
    @DeleteMapping("/basic/{id}")
    public R deleteBasic(@PathVariable Integer id) {
        boolean removeById = basicInfoService.removeById(id);
        if (removeById) {
            return new R(true, null, "删除成功啦~");
        }
        return new R(false, null, "哎呀~服务器开小差了，页面自动刷新~");
    }

    // 查询毕业生就业信息
    @GetMapping("/emp/{currentPage}/{pageSize}")
    public R queryEmp(@PathVariable Integer currentPage, @PathVariable Integer pageSize, EmployInfo employInfo) {
        IPage<EmployInfo> page = employInfoService.getPage(currentPage, pageSize, employInfo);
        if (currentPage > page.getPages()) {
            page = employInfoService.getPage((int) page.getPages(), pageSize, employInfo);
        }
        return new R(true, page, null);
    }

    // 新增毕业生就业信息
    @PostMapping("/emp")
    public R createEmp(@RequestBody EmployInfo employInfo) {
        boolean save = employInfoService.save(employInfo);
        if (save) {
            return new R(true, null, "成功啦~");
        }
        return new R(false, null, "服务器出差去了~重新提交吧~");
    }

    @PutMapping("/emp")
    public R updateEmp(@RequestBody EmployInfo employInfo) {
        boolean update = employInfoService.updateById(employInfo);
        if (update) {
            return new R(true, null, "修改成功");
        }
        return new R(false, null, "服务器被炸了...修改失败...");
    }

    // 删除毕业生就业信息
    @DeleteMapping("/emp/{id}")
    public R deleteEmp(@PathVariable Integer id) {
        boolean removeById = employInfoService.removeById(id);
        if (removeById) {
            return new R(true, null, "删除成功啦~");
        }
        return new R(false, null, "哎呀~服务器开小差了，页面自动刷新~");
    }
}
