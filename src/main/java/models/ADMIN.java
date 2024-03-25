package models;

public class ADMIN {
    public static int Monthly_Payment=600;
    public static int Membership_6_Month=1500;
    public static int Membership_12_Month=1500;
    public static int Membership_Lifetime=1500;
    public static final String Name="GYM WORLD";

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
