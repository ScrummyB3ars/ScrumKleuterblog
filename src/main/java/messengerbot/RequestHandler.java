package messengerbot;

import com.mashape.unirest.http.JsonNode;
import types.AgeGroup;
import types.Subscriber;

import java.util.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import com.mashape.unirest.http.ObjectMapper;

import static com.mashape.unirest.http.Unirest.get;

public class RequestHandler {
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

    HttpResponse<Subscriber[]> response = get(URL + "/subscribers").asObject(Subscriber[].class);
    Subscriber[] subscribers = response.getBody();
    return Arrays.asList(subscribers);

  }

  public List<AgeGroup> GetAgeGroups() throws UnirestException {
    HttpResponse<AgeGroup[]> response = get(URL + "/age_groups").asObject(AgeGroup[].class);
    AgeGroup[] ageGroups = response.getBody();
    return Arrays.asList(ageGroups);
  }

  public void AddSubscriber(Subscriber sub) throws UnirestException {
    HttpResponse<JsonNode> response = Unirest.post("/addSubscriber").header("accept", "application/json")
        .field("facebook_id", sub.getFacebook_id()).field("age_group", sub.getAge_group_id()).asJson();
  }

  public boolean UserIsSub(String recipientId, List<Subscriber> sub) {
    return sub.stream().anyMatch(subscriber -> subscriber.getFacebook_id().equals(recipientId));
  }

}