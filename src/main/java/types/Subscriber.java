package types;

public class Subscriber {
  private int id;
  private int facebook_id;
  private int user_type;

  public Subscriber(int id, int facebook_id, int user_type) {
    this.id = id;
    this.facebook_id = facebook_id;
    this.user_type = user_type;
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
  public int getFacebook_id() {
    return facebook_id;
  }

  /**
   * @return the user_type
   */
  public int getUser_type() {
    return user_type;
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