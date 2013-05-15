package org.bdigital;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

public class MainSerializacionManual {

	/**
	 * Serialització manual
	 * 
	 * @param args
	 * @throws TException 
	 */
	public static void main(String[] args) throws TException {

		TweetDTO dtoOriginal = new TweetDTO();
		dtoOriginal.setId("10000");
		dtoOriginal.setScreenName("Javier Moreno");
		dtoOriginal.setMensaje("q ase hola");
		
		TSerializer serializer = new TSerializer(
				new TBinaryProtocol.Factory());
		byte[] bits = serializer.serialize(dtoOriginal);
		
		TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory()); 
		TweetDTO dtoFinal = new TweetDTO();
		
		dtoFinal.clear();
		deserializer.deserialize(dtoFinal, bits);
		
		System.out.println(dtoFinal.getMensaje());
	}

}
