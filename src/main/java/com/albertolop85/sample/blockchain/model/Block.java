package com.albertolop85.sample.blockchain.model;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Object representing the generic block to be used in our blockchain 
 * @author Alberto Lopez
 *
 * @param <T>
 */
public class Block<T> {

	private String hash;
	private String previousHash;
	
	private long timestamp; 

	private T data;
	
	public Block(String previousBlockHash, T blockData) {
		
		previousHash = previousBlockHash;
		data = blockData;
		
		timestamp = new Date().getTime();
		
		hash = createHash(this);
	}
	
	public String getHash() {
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Block<?>)) {
			return false;
		}
		
		if (hash != null && hash.equals(((Block<?>)obj).getHash())) {
			return true;
		} else {
			return false;
		}
	}
	
	private static <T> String createHash(Block<T> block) {
		return DigestUtils.sha256Hex(
				block.previousHash + Long.toString(block.timestamp) + block.data.toString());
	}
	
	@Override
	public String toString() {
		return "Block with Hash [" + hash + "] and data [" + data + "]";
	}
}
