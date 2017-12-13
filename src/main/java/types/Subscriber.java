package types;

public class Subscriber {
  private int id;
  private String facebook_id;
  private int age_group_id;

  public Subscriber(int id, String facebook_id, int age_group_id) {
    this.id = id;
    this.facebook_id = facebook_id;
    this.age_group_id = age_group_id;
  }

  public Subscriber() {
  }

  public Subscriber(String facebook_id, int age_group_id) {
    this.facebook_id =facebook_id;
    this.age_group_id = age_group_id;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @return the facebook_id
   */
  public String getFacebook_id() {
    return facebook_id;
  }

  /**
   * @return the user_type
   */
  public int getAge_group_id() {
    return age_group_id;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Subscriber)) {
      return false;
    }
    Subscriber other = (Subscriber) o;
    return this.getId() == other.getId() && this.getFacebook_id() == other.getFacebook_id()
        && this.getAge_group_id() == other.getAge_group_id();
  }

}