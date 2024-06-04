package warehouse.servicewarehouse.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_warehouse")
@Data

public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "productId", nullable = false)
    private long productId;
    @Column(name = "quantity")
    private int quantity;
}
