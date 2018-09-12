package com.liupeiqing.spring.cloud.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Java Persistence API定义了一种定义，可以将常规的普通Java对象（有时被称作POJO）映射到数据库。
 * 这些普通Java对象被称作Entity Bean。
 * 除了是用Java Persistence元数据将其映射到数据库外，Entity Bean与其他Java类没有任何区别。
 * @Entity注释指名这是一个实体Bean，@Table注释指定了Entity所要映射带数据库表，其中@Table.name()用来指定映射表的表名。
 * 如果缺省@Table注释，系统默认采用类名作为映射表的表名。实体Bean的每个实例代表数据表中的一行数据，行中的一列对应实例中的一个属性。
 *
 * @Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息，属性如下：
 * 1）name：映射的列名。如：映射tbl_user表的name列，可以在name属性的上面或getName方法上面加入；
 * 2）unique：是否唯一；
 * 3）nullable：是否允许为空；
 * 4）length：对于字符型列，length属性指定列的最大字符长度；
 * 5）insertable：是否允许插入；
 * 6）updatetable：是否允许更新；
 * 7）columnDefinition：定义建表时创建此列的DDL；
 * 8）secondaryTable：从表名。如果此列不建在主表上（默认是主表），该属性定义该列所在从表的名字。
 * @Id注释指定表的主键，它可以有多种生成方式：
 *
 * 1）TABLE：容器指定用底层的数据表确保唯一；
 * 2）SEQUENCE：使用数据库德SEQUENCE列莱保证唯一（Oracle数据库通过序列来生成唯一ID）；
 * 3）IDENTITY：使用数据库的IDENTITY列莱保证唯一；
 * 4）AUTO：由容器挑选一个合适的方式来保证唯一；
 * 5）NONE：容器不负责主键的生成，由程序来完成。
 *
 * @GeneratedValue注释定义了标识字段生成方式。
 *
 * @Temporal注释用来指定java.util.Date或java.util.Calender属性与数据库类型date、time或timestamp中的那一种类型进行映射。
 *
 * @Temporal(value=TemporalType.TIME)
 */

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //自增
    private Long id;

    @Column
    private String username;

    @Column
    private Integer age;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
