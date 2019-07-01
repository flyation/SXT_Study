package com.sxt;

/**
 * @author fly
 * @date 2019/5/31
 */
@SxtTable("tb_user")
public class User {
    @SxtField(columnName = "id",type = "int",length = 10)
    private int id;
    @SxtField(columnName = "user_age",type = "int",length = 3)
    private int age;
    @SxtField(columnName = "user_name",type = "varchar",length = 10)
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
