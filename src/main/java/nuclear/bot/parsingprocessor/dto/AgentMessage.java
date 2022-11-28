
package nuclear.bot.parsingprocessor.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * AgentMessage
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parsingAgentName",
    "messageDateTime",
    "message"
})
@Generated("jsonschema2pojo")
public class AgentMessage {

    /**
     * The name of parsing agent
     * 
     */
    @JsonProperty("parsingAgentName")
    @JsonPropertyDescription("The name of parsing agent")
    private String parsingAgentName;
    /**
     * When message was generated
     * 
     */
    @JsonProperty("messageDateTime")
    @JsonPropertyDescription("When message was generated")
    private String messageDateTime;
    /**
     * Message from agent
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Message from agent")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The name of parsing agent
     * 
     */
    @JsonProperty("parsingAgentName")
    public String getParsingAgentName() {
        return parsingAgentName;
    }

    /**
     * The name of parsing agent
     * 
     */
    @JsonProperty("parsingAgentName")
    public void setParsingAgentName(String parsingAgentName) {
        this.parsingAgentName = parsingAgentName;
    }

    /**
     * When message was generated
     * 
     */
    @JsonProperty("messageDateTime")
    public String getMessageDateTime() {
        return messageDateTime;
    }

    /**
     * When message was generated
     * 
     */
    @JsonProperty("messageDateTime")
    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    /**
     * Message from agent
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message from agent
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgentMessage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("parsingAgentName");
        sb.append('=');
        sb.append(((this.parsingAgentName == null)?"<null>":this.parsingAgentName));
        sb.append(',');
        sb.append("messageDateTime");
        sb.append('=');
        sb.append(((this.messageDateTime == null)?"<null>":this.messageDateTime));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.message == null)? 0 :this.message.hashCode()));
        result = ((result* 31)+((this.parsingAgentName == null)? 0 :this.parsingAgentName.hashCode()));
        result = ((result* 31)+((this.messageDateTime == null)? 0 :this.messageDateTime.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentMessage) == false) {
            return false;
        }
        AgentMessage rhs = ((AgentMessage) other);
        return (((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.message == rhs.message)||((this.message!= null)&&this.message.equals(rhs.message))))&&((this.parsingAgentName == rhs.parsingAgentName)||((this.parsingAgentName!= null)&&this.parsingAgentName.equals(rhs.parsingAgentName))))&&((this.messageDateTime == rhs.messageDateTime)||((this.messageDateTime!= null)&&this.messageDateTime.equals(rhs.messageDateTime))));
    }

}
