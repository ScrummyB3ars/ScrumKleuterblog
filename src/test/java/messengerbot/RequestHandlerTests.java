package messengerbot;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

import messengerbot.RequestHandler;
import types.*;

public class RequestHandlerTests {
  private RequestHandler requestHandler;

  @Before
  public void InitializeRequestHandler() {
    requestHandler = new RequestHandler();
  }

  @Test
  public void TestSubscriberValue() {
    List<Subscriber> expectedSubs = new ArrayList<Subscriber>();
    Subscriber testSub = new Subscriber(1, "2147483647", 1);
    expectedSubs.add(testSub);
    try {
      List<Subscriber> actualSubs = requestHandler.GetSubscribers();
      assertEquals(actualSubs, expectedSubs);
    } catch (Exception e) {
      System.out.println("Can't fetch subs: " + e);
    }
  }
  @Test
  public void TestUserIsSub() {
    List<Subscriber> subList = new ArrayList<Subscriber>();
    Subscriber testSub = new Subscriber(1, "2147483647", 1);
    subList.add(testSub);

    try {

      assertEquals(requestHandler.UserIsSub("2147483647",subList), true);
    } catch (Exception e) {
      System.out.println("Failed to find user" + e);
    }
  }
}