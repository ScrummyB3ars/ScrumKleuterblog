package types;

public class Subscriber {
  private int id;
  private String facebook_id;
  private int age_group;

  public Subscriber(int id, String facebook_id, int age_group) {
    this.id = id;
    this.facebook_id = facebook_id;
    this.age_group = age_group;
  }

  public Subscriber() {
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
  public int getUser_type() {
    return age_group;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Subscriber)) {
      return false;
    }
    Subscriber other = (Subscriber) o;
    return this.getId() == other.getId() && this.getFacebook_id() == other.getFacebook_id()
        && this.getUser_type() == other.getUser_type();
  }
}