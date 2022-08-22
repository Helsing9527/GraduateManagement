package icu.jswz.pojo;

import lombok.Data;

/**
 * 毕业生就业信息
 */
@Data
public class EmployInfo {
    // 序号
    private Integer id;
    // 就业时间
    private String empTime;
    // 工作单位
    private String employer;
    // 工作性质
    private String natureOfWork;
    // 职务
    private String post;
    // 地址
    private String address;
    // bid
    private Integer bid;
    // 姓名
    private String name;
}
