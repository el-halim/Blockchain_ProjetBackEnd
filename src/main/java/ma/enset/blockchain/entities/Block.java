package ma.enset.blockchain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "BLOCK")
public class Block {
    @Id
    private String id;
    private Date createdAt;
    private String hash;
    private String previousHash;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "block")
    private List<Transaction> transactions = new ArrayList<>();
    private int nonce;

}
