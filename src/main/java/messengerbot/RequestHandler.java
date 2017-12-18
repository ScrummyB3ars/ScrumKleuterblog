package messengerbot;

import com.mashape.unirest.http.JsonNode;

import jdk.nashorn.internal.scripts.JO;
import types.*;

import java.io.InputStream;
import java.util.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import com.mashape.unirest.http.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.mashape.unirest.http.Unirest.get;

public class RequestHandler {
  private static final Logger logger = LoggerFactory.getLogger(MessengerPlatformCallbackHandler.class);
  private final static String URL = "https://api-toddlr.herokuapp.com";

  /**
   * Constructor, sets the objectmapper for unirest
   */
  public RequestHandler() {

    // sets the object mapper
    Unirest.setObjectMapper(new ObjectMapper() {
      private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

      public <T> T readValue(String value, Class<T> valueType) {
        try {
          return jacksonObjectMapper.readValue(value, valueType);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      public String writeValue(Object value) {
        try {
          return jacksonObjectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  /**
   * Returns a list of subscribers
   * @return a list of strings, the sender-id's
   */
  public List<Subscriber> GetSubscribers() throws UnirestException {
    HttpResponse<Subscriber[]> response = Unirest.get(URL + "/subscribers").asObject(Subscriber[].class);
    Subscriber[] subscribers = response.getBody();
    return Arrays.asList(subscribers);
  }

  /**
   * Returns a list of tips
   * @return a list of tips
   */
  public List<Tip> GetTips() throws UnirestException {
    HttpResponse<Tip[]> response = Unirest.get(URL + "/tips").asObject(Tip[].class);
    Tip[] tips = response.getBody();
    return Arrays.asList(tips);
  }

  /**
   * Gets a random tip from the list
   */
  public Tip GetRandomTip() {
    try {
      List<Tip> tips = GetTips();
      return tips.get((new Random()).nextInt(tips.size()));
    } catch (UnirestException e) {
      return null;
    }
  }
  public ThemeTip GetRandomThemeTip() throws UnirestException {
    return get(URL + "/theme_tips/random").asObject(ThemeTip.class).getBody();
  }


  public List<AgeGroup> GetAgeGroups() throws UnirestException {
    HttpResponse<AgeGroup[]> response = get(URL + "/age_groups").asObject(AgeGroup[].class);
    AgeGroup[] ageGroups = response.getBody();
    return Arrays.asList(ageGroups);
  }

  public Subscriber AddSubscriber(Subscriber sub) throws UnirestException {
    HttpResponse<Subscriber> response = Unirest.post(URL +"/subscribers/add").header("Content-Type", "application/json").body(sub)
        .asObject(Subscriber.class);
    return response.getBody();

  }
  public void DeleteSubscriber(Subscriber sub) throws UnirestException {


    HttpResponse<JsonNode> response = Unirest.delete(URL + "/subscribers/delete").header("Content-Type", "application/json")
            .body(sub).asJson();

  }

  public boolean UserIsSub(String recipientId, List<Subscriber> sub) {
    return sub.stream().anyMatch(subscriber -> subscriber.getFacebook_id().equals(recipientId));
  }

}