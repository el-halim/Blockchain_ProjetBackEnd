package ma.enset.blockchain.services;

import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Blockchain;
import ma.enset.blockchain.entities.Transaction;
import ma.enset.blockchain.repositories.BlockRepository;
import ma.enset.blockchain.repositories.BlockchainRepository;
import ma.enset.blockchain.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlockchainServiceImpl implements BlockchainService {


    @Autowired
    private BlockchainRepository blockchainRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    private BlockService blockService;
    public BlockchainServiceImpl(BlockService blockService) {
        this.blockService = blockService;
    }

    private Blockchain blockchain;


    @Override
    public Blockchain createBlockchain(String name,int difficulty,int reward) {
        Blockchain blockchain = new Blockchain();
        Block genesisBlock = blockService.createBlock(Collections.emptyList(), "0");
        blockchain.setId(UUID.randomUUID().toString());
        blockchain.setName(name);
        blockchain.getBlocks().add(genesisBlock);
        blockchain.setDifficulty(difficulty);
        blockchain.setMiningReward(reward);
        return blockchainRepository.save(blockchain);
    }
    @Override
    public double CalculSolde(String blockchainID,String addr) {
        Blockchain blockchain = blockchainRepository.findById(blockchainID).get();

        double solde = 0;

        for (Block block : blockchain.getBlocks())
        {
            for (Transaction transaction : block.getTransactions())
            {
                if(transaction.getAddressDestination().equals(addr))
                    solde+=transaction.getAmount();
                    System.out.println(solde);
            }
        }
        return solde;
    }
    @Override
    public Blockchain getBlockchaineByID(String id) {
        Blockchain blockchain = blockchainRepository.findById(id).get();
        return blockchain;
    }

    @Override
    public Block getLastBlock(String blockchainID) {
        Blockchain blockchain = blockchainRepository.findById(blockchainID).get();
        if(blockchain == null)
            return null;
        return blockchain.getBlocks().get(blockchain.getBlocks().size()-1);
    }

    @Override
    public Block mineBlock(String IdBlockChain,List<Transaction> pendingTransactions, String previousHash) {
        Blockchain blockchain = blockchainRepository.findById(IdBlockChain).get();
        Block lastBlock = getLastBlock(IdBlockChain);

        Block block = blockService.createBlock(pendingTransactions,lastBlock.getHash());
        Block minedBlock = blockService.mineBlock(block,blockchain.getDifficulty());
        blockchain.getBlocks().add(minedBlock);
        blockchainRepository.save(blockchain);
        System.out.println(block.getNonce()+"   hash block:   "+block.getHash());
        return block;

    }

    @Override
    public List<Blockchain> getAllBlockchains() {
        return blockchainRepository.findAll();
    }

    @Override
    public boolean verifyBlockchain(String idBlockchain) {
        boolean valid = true;
        Blockchain blockchain = blockchainRepository.findById(idBlockchain).get();
        List<Block> blocks = blockchain.getBlocks();
        for(int i = 0; i < blocks.size(); i++){
            if(!blocks.get(i).getHash().equals(blockService.getHashOfBlock(blocks.get(i)))){
                valid = false;
            }
            if(!blocks.get(i+1).getPreviousHash().equals(blocks.get(i).getHash())){
                valid = false;
            }
        }
        return valid;
    }




}
