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



    public AgeGroup(int id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }
}
