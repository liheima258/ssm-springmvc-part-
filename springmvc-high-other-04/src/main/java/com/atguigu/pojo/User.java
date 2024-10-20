package com.atguigu.pojo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class User {

    // 添加注释 来进行参数校验 通过校验 则正常运行 未通过校验 则会报异常
    //age >= 10
    @Min(10)
    private int age;

    //3 <= name.length <= 6
    @Length(min = 3,max = 10)
    private String name;

    //邮箱格式
    @Email
    private String email;

}

