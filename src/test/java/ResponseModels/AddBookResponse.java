package ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.path.json.JsonPath;

public class AddBookResponse {

        @JsonProperty("Msg")
        private String msg;
        @JsonProperty("ID")
        private String id;
        @JsonProperty("msg")
        private String message;


        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getMessage() {
        return message;
    }


}
