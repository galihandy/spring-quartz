package explr.spring.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by galih.a.pradana on 8/18/2016.
 */
@JsonIgnoreProperties(value = "decoratedClass")
@JsonPropertyOrder(alphabetic = true)
public interface ProfileNoDesc {
    public Integer getId();

    public String getName();
}
