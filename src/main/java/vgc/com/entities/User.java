package vgc.com.entities;


import vgc.com.model.UserNameProfile;

import javax.persistence.*;


@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "UserNameProfile",
                classes = @ConstructorResult(
                        targetClass = UserNameProfile.class,
                        columns = {
                                @ColumnResult(name = "user_id", type = Integer.class),
                                @ColumnResult(name = "username", type = String.class),
                                @ColumnResult(name = "user_avatar", type = String.class),
                                @ColumnResult(name = "user_fullname", type = String.class),
                                @ColumnResult(name = "user_birthday", type = String.class),
                                @ColumnResult(name = "user_gender", type = Integer.class),
                                @ColumnResult(name = "user_email", type = String.class),
                                @ColumnResult(name = "user_city", type = String.class),
                                @ColumnResult(name = "user_phone", type = String.class),
                                @ColumnResult(name = "user_point", type = Integer.class)
                        }
                )
        )
})
@NamedNativeQuery(name = "getUserNameProfile", resultSetMapping = "UserNameProfile",
        query = "SELECT `user_id`,`username`,`user_avatar`,`user_fullname`,DATE_FORMAT(`user_birthday`, \"%d/%m/%Y\") as `user_birthday`,`user_gender`,`user_email`,`user_city`,`user_phone`,`user_point` FROM `users` WHERE `user_id` = ?1")

@Entity
@Table(name = "users" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "username")
    private String username;

    private String password;
    private String avatar;
    private String fullname;
    private String birthday;
    private int gender;
    private String email;
    private String city;
    private String phone;
    private int point;

    public User() {
    }

    public User(int user_id, String username, String password, String avatar, String fullname, String birthday, int gender, String email, String user_city, String phone, int point) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.city = user_city;
        this.phone = phone;
        this.point = point;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
