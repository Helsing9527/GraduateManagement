package icu.jswz.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 毕业生基本信息
 */
@Data
public class BasicInfo {
    // 序号
    private Integer id;
    // 姓名
    private String name;
    // 性别
    private String gender;
    // 民族
    private String nation;
    // 籍贯
    private String hometown;
    // 毕业时间
    private String graduationTime;
    // 年级
    private String grade;
    // 专业
    private String discipline;
    // 政治面貌
    private String politicalStatus;
}
