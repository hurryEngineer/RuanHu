package edu.nju.data.entity;

/**
 * Created by Dora on 2016/7/20.
 */
public class CommonUser {

    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CommonUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
