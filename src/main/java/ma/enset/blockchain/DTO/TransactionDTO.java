package ma.enset.blockchain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionDTO {
    private Date transaction_date;
    private String src_adr;
    private String des_adr;
    private double montant;
}
