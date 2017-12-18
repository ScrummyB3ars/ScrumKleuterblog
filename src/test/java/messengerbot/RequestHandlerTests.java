package messengerbot;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.lang.Object;

import messengerbot.RequestHandler;
import types.*;

public class RequestHandlerTests {
  private RequestHandler requestHandler;

  @Before
  public void InitializeRequestHandler() {
    requestHandler = new RequestHandler();
  }

  //  @Test
  //  public void TestSubscriberValue() {
  //    List<Subscriber> expectedSubs = new ArrayList<Subscriber>();
  //
  //    expectedSubs.add(new Subscriber(1, "05245486", 0));
  //    expectedSubs.add(new Subscriber(2, "0965875", 1));
  //    expectedSubs.add(new Subscriber(3, "5879654", 1));
  //
  //    try {
  //      List<Subscriber> actualSubs = requestHandler.GetSubscribers();
  //      assertEquals(actualSubs, expectedSubs);
  //    } catch (Exception e) {
  //      System.out.println("Can't fetch subs: " + e);
  //    }
  //  }

  @Test
  public void TestUserIsSub() {
    List<Subscriber> subList = new ArrayList<Subscriber>();
    Subscriber testSub = new Subscriber(1, "2147483647", 1);
    subList.add(testSub);

    try {

      assertEquals(requestHandler.UserIsSub("2147483647", subList), true);
    } catch (Exception e) {
      System.out.println("Failed to find user" + e);
    }
  }

  @Test
  public void TestSubscribeUser() {

    try{

        Subscriber sub = new Subscriber("69",0);
        Subscriber addsub = requestHandler.AddSubscriber(sub);

        assertEquals(addsub.getFacebook_id(), sub.getFacebook_id());
      }
      catch (Exception e){

        System.out.println(e);
      }
  }
  @Test
  public void TestDeleteSubscribeUser() {

    try{
      final List<Subscriber> subList= requestHandler.GetSubscribers();
      Subscriber sub = new Subscriber("69");
      requestHandler.DeleteSubscriber(sub);

      assertEquals(requestHandler.UserIsSub(sub.getFacebook_id(), subList), false);
    }
    catch (Exception e){

      System.out.println(e);
    }
  }
  @Test
  public void TestGetThemeTip(){
    try{
      ThemeTip themeTip = requestHandler.GetRandomThemeTip();
      System.out.println(themeTip.getPicture());

    }catch (Exception e){
      System.out.println(e);
    }
  }
  @Test
  public void TestGetInteractionTip(){
    try{
      InteractionTip themeTip = requestHandler.GetRandomIteractionTip();
      System.out.println(themeTip.getTip_content());

    }catch (Exception e){
      System.out.println(e);
    }
  }

  @Test
  public void TestAgeGroup() {
    try {
      assertEquals(requestHandler.GetAgeGroups().get(0).getId(), 0);
    } catch (Exception e) {
      System.out.println("Failed to get age group" + e);
    }
  }
}