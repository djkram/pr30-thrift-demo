package org.bdigital;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class MainCliente {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		TTransport transport = new TSocket("127.0.0.1", 8888);
		transport.open();
		TProtocol protocol = new TBinaryProtocol(transport);
		TweetService.Client cliente = new TweetService.Client(protocol);
		TweetDTO dto = cliente.tweetById("1111");
		dto.setMensaje("RT: " + dto.getMensaje());
		cliente.guardarTweet(dto);
		cliente.reset();
		transport.close();
	}

}
