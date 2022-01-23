package ma.enset.blockchain;

import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Blockchain;
import ma.enset.blockchain.entities.Transaction;
import ma.enset.blockchain.repositories.BlockRepository;
import ma.enset.blockchain.repositories.BlockchainRepository;
import ma.enset.blockchain.repositories.TransactionRepository;
import ma.enset.blockchain.services.BlockService;
import ma.enset.blockchain.services.BlockServiceImpl;
import ma.enset.blockchain.services.BlockchainService;
import ma.enset.blockchain.services.BlockchainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BlockchainApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockchainApplication.class, args);

    }

    @Bean
    CommandLineRunner start(TransactionRepository transactionRepository, BlockRepository blockRepository,
                            BlockchainRepository blockchainRepository, BlockService blockService,
                            BlockchainService blockchainService) {
        return args -> {

            /*Transaction transaction1 = new Transaction("1", new Date(), "src", "dst", 7000);
            Transaction transaction2 =  new Transaction("2", new Date(), "adressSrc", "adressDst", 3000);
            transactionRepository.save(transaction1);
            transactionRepository.save(transaction2);

            List<Transaction> transactionList  = new ArrayList<>();
            transactionList.add(transaction1);
            transactionList.add(transaction2);
            Block block1 = blockRepository.save(new Block("1", new Date(), "0", "0", transactionList,0));
            Block block2 = blockService.createBlock(transactionList,"0");

            Transaction transaction3 =   transactionRepository.save(new Transaction("3", new Date(), "adressSrc3", "adressDst3", 9000));
            List<Transaction> transactionList3  = new ArrayList<>();
            transactionList.add(transaction3);
            Block block3 = blockRepository.save(new Block("3", new Date(), "0", "0", transactionList3,0));

            Block mineBlock = blockService.mineBlock(block1,3);
            System.out.println(mineBlock.getHash());
            System.out.println(mineBlock.getNonce());



          //  blockchainRepository.save(new Blockchain("1"));
            Blockchain blockchain = blockchainService.createBlockchain();
            System.out.println(blockchain.getBlocks());
            System.out.println(blockchain.getName());
            System.out.println(blockchain.getDifficulty());


            System.out.println("----------");
            blockchain.getBlocks().add(block1);
            blockchain.getBlocks().add(block3);
            System.out.println("Get Blocks :");
            System.out.println(blockchain.getBlocks());
            System.out.println("Get Last Block :");
            System.out.println(blockchain.getBlocks().get(blockchain.getBlocks().size()-1));

           // System.out.println(blockchainService.getLastBlock());

            System.out.println("Blockchain valid : "+blockchainService.verifyBlockchain());


             */
        };


    }






}
