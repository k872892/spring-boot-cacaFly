package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String message;
	//private String error;
    //private Value value;

    public Quote() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
		System.out.printf("fwwewwfw\nwweewwew\nwwewwewweewwe\n%s\n",message);
        //this.message = "hi";
    }
/*
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }*/

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + message + '\'' +
                
                '}';
    }
}