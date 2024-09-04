public class User {
    private String name;
    private String member_type;
    private boolean excl_reward;

    public User(String name, String member_type, boolean excl_reward) {
        this.name = name;
        this.member_type = member_type;
        this.excl_reward = excl_reward;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMemberType() {
        return member_type;
    }
    public void setMemberType(String member_type) {
        this.member_type = member_type;
    }

    public boolean getRewardStatus() {
        return excl_reward;
    }
    public void setRewardStatus(boolean excl_reward) {
        this.excl_reward = excl_reward;
    }
}
