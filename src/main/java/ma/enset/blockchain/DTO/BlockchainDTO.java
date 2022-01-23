package ma.enset.blockchain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.blockchain.entities.Block;
import ma.enset.blockchain.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class BlockchainDTO {
    private String name;
    private int difficulty;
    private int reward;
    private List<Block> blocks;

}
