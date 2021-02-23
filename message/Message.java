package message;

public class Message {
	private MessageType type;
	private Object body;

	/*
	 * Constructor
	 * @param type the message type.
	 * @param body the message body.
	 */
	public Message(MessageType type, Object body)
	{
		this.type = type;
		this.body = body;
	}

	/**
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}


	/**
	 * @return the body
	 */
	public Object getBody() {
		return body;
	}

}
