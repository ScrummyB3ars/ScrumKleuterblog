package types;

public class AgeGroup {

    private int id;
    private String group_name;

    public int getId() {
        return id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public AgeGroup() {

    }

    public AgeGroup(int id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AgeGroup)) {
            return false;
        }
        AgeGroup other = (AgeGroup) o;
        return this.getId() == other.getId() && this.getGroup_name().equals(other.getGroup_name());
    }
}
