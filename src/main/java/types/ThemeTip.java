package types;

public class ThemeTip {
    private int id;
    private String picture;
    private String tip_content;
    private String  rich_language;
    private String circumstances;
    private String development_goal;
    private int themes_id;
    private int age_group_id;
    private String zill_goal;

    public ThemeTip() {
    }

    public ThemeTip(int id, String picture, String tip_content, String rich_language, String circumstances, String development_goal, int themes_id, int age_group_id, String zill_goal) {
        this.id = id;
        this.picture = picture;
        this.tip_content = tip_content;
        this.rich_language = rich_language;
        this.circumstances = circumstances;
        this.development_goal = development_goal;
        this.themes_id = themes_id;
        this.age_group_id = age_group_id;
        this.zill_goal = zill_goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTip_content() {
        return tip_content;
    }

    public void setTip_content(String tip_content) {
        this.tip_content = tip_content;
    }

    public String getRich_language() {
        return rich_language;
    }

    public void setRich_language(String rich_language) {
        this.rich_language = rich_language;
    }

    public String getCircumstances() {
        return circumstances;
    }

    public void setCircumstances(String circumstances) {
        this.circumstances = circumstances;
    }

    public String getDevelopment_goal() {
        return development_goal;
    }

    public void setDevelopment_goal(String development_goal) {
        this.development_goal = development_goal;
    }

    public int getThemes_id() {
        return themes_id;
    }

    public void setThemes_id(int themes_id) {
        this.themes_id = themes_id;
    }

    public int getAge_group_id() {
        return age_group_id;
    }

    public void setAge_group_id(int age_group_id) {
        this.age_group_id = age_group_id;
    }

    public String getZill_goal() {
        return zill_goal;
    }

    public void setZill_goal(String zill_goal) {
        this.zill_goal = zill_goal;
    }
}
