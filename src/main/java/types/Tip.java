package types;

public class Tip {
  private int id;
  private String picture;
  private String tip_content;
  private String rich_language;
  private String circumstances;
  private String development_goal;
  private String zill_goal;
  private int themes_id;
  private int age_group_id;

  public Tip() {

  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the picture
   */
  public String getPicture() {
    return picture;
  }

  /**
   * @param picture the picture to set
   */
  public void setPicture(String picture) {
    this.picture = picture;
  }

  /**
   * @return the age_group_id
   */
  public int getAge_group_id() {
    return age_group_id;
  }

  /**
   * @param age_group_id the age_group_id to set
   */
  public void setAge_group_id(int age_group_id) {
    this.age_group_id = age_group_id;
  }

  /**
   * @return the circumstances
   */
  public String getCircumstances() {
    return circumstances;
  }

  /**
   * @param circumstances the circumstances to set
   */
  public void setCircumstances(String circumstances) {
    this.circumstances = circumstances;
  }

  /**
   * @return the development_goal
   */
  public String getDevelopment_goal() {
    return development_goal;
  }

  /**
   * @param development_goal the development_goal to set
   */
  public void setDevelopment_goal(String development_goal) {
    this.development_goal = development_goal;
  }

  /**
   * @return the rich_language
   */
  public String getRich_language() {
    return rich_language;
  }

  /**
   * @param rich_language the rich_language to set
   */
  public void setRich_language(String rich_language) {
    this.rich_language = rich_language;
  }

  /**
   * @return the themes_id
   */
  public int getThemes_id() {
    return themes_id;
  }

  /**
   * @param themes_id the themes_id to set
   */
  public void setThemes_id(int themes_id) {
    this.themes_id = themes_id;
  }

  /**
   * @return the tip_content
   */
  public String getTip_content() {
    return tip_content;
  }

  /**
   * @param tip_content the tip_content to set
   */
  public void setTip_content(String tip_content) {
    this.tip_content = tip_content;
  }

  /**
   * @return the zill_goal
   */
  public String getZill_goal() {
    return zill_goal;
  }

  /**
   * @param zill_goal the zill_goal to set
   */
  public void setZill_goal(String zill_goal) {
    this.zill_goal = zill_goal;
  }
}