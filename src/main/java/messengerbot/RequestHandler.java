package messengerbot;

import com.mashape.unirest.http.JsonNode;
import types.Subscriber;

import java.util.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import com.mashape.unirest.http.ObjectMapper;

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
    HttpResponse<Subscriber[]> response = Unirest.get(URL + "/subscribers").asObject(Subscriber[].class);
    Subscriber[] subscribers = response.getBody();
    return Arrays.asList(subscribers);
  }

  public void  PostSubscriber(Subscriber sub) throws UnirestException {

  }
}