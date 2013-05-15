package org.bdigital;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class MainServer {

	/**
	 * @param args
	 * @throws TTransportException 
	 */
	public static void main(String[] args) throws TTransportException {

		System.out.println("Arrancando servidor");
		
		TServerSocket transporte = new TServerSocket(8888);
		TweetServiceIFace tweetServiceIFace = new TweetServiceIFace();
		TweetService.Processor<TweetServiceIFace> processor = 
				new TweetService.Processor<TweetServiceIFace>(tweetServiceIFace);
		TServer server = new TThreadPoolServer(
				new TThreadPoolServer.Args(transporte).processor(processor));
		server.serve();
		
		System.out.println("System ready.");
	}

}
