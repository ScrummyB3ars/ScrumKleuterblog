package types;

public class InteractionTip {
    private int id;
    private  String tip_content;
    private int add_rich_language;
    private int type_id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTip_content() {
        return tip_content;
    }

    public int getAdd_rich_language() {
        return add_rich_language;
    }

    public int getType_id() {
        return type_id;
    }



    public InteractionTip(int id, String tip_content, int add_rich_language, int type_id) {
        this.id = id;
        this.tip_content = tip_content;
        this.add_rich_language = add_rich_language;
        this.type_id = type_id;
    }

    public InteractionTip() {

    }



}
