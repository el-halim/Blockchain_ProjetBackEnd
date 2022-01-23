package ma.enset.blockchain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.blockchain.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class BlockDTO {
    private String blockchainID;
    private String pres_hash;
    private String min_adr;
    private List<Transaction> transactions = new ArrayList<>();
}
