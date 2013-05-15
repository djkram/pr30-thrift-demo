package org.bdigital;

import org.apache.thrift.TException;

public class TweetServiceIFace implements TweetService.Iface{

	@Override
	public TweetDTO tweetById(String id) throws TException {
		TweetDTO dto = new TweetDTO();
		dto.setMensaje("Mensaje " + id);
		return dto;
	}

	@Override
	public void guardarTweet(TweetDTO tweetDTO) throws TException {
		System.out.println("Guardando dto " + tweetDTO.getMensaje());
	}

	@Override
	public void reset() throws TException {
		System.out.println("RSET!");
	}
	
}
