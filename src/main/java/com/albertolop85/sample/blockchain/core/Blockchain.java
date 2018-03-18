package com.albertolop85.sample.blockchain.core;

import java.util.ArrayList;
import java.util.List;

import com.albertolop85.sample.blockchain.model.Block;

/**
 * Very basic example of a Blockchain
 * @author Alberto Lopez
 *
 */
public class Blockchain {
	
	private List<Block<String>> blockchain;
	
	public Blockchain() {
		
		// Initializing a list that will contain all blocks
		blockchain = new ArrayList<Block<String>>();
		
		// Genesis Block
		blockchain.add(new Block<String>("", "Initial Block"));
	}
	
	public void addBlock(String data) {
		
		// Get last block on the chain
		Block<String> previousBlock = blockchain.get(blockchain.size() - 1);
		
		System.out.println("Adding block. Previous block with hash [" + previousBlock.getHash() + "]");
		
		// Creating a new block based on the data sent and adding it to the chain
		blockchain.add(new Block<String>(previousBlock.getHash(), data));
		
		// Retrieving added block
		Block<String> currentBlock = blockchain.get(blockchain.size() - 1);
		
		System.out.println("Generated block with hash [" + currentBlock.getHash() + "]");
	}

	public static void main(String[] args) {
		
		Blockchain blockchain = new Blockchain();
		
		blockchain.addBlock("Second Block");
		blockchain.addBlock("Third Block");
		blockchain.addBlock("Fourth Block");
	}
}
