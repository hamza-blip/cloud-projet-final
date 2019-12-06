package sender;

import javax.jms.*;
import javax.jms.QueueConnectionFactory;

import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySender {

	public static void main(String[] args) {
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
			QueueConnection queueConnection = factory.createQueueConnection();

			// Open a session without transaction and acknowledge automatic
			QueueSession session = (QueueSession) queueConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Start the connection
			queueConnection.start();

			// Create a sender
			QueueSender sender = session.createSender(queue);

			// Create a message
			TextMessage message = session.createTextMessage("Hello message broker");

			// Send the message
			sender.send(message, DeliveryMode.NON_PERSISTENT, 0, 1000L);
			sender.send(message, DeliveryMode.NON_PERSISTENT, 9, 1000L);

			// Close the session
			session.close();

			// Close the connection
			queueConnection.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
