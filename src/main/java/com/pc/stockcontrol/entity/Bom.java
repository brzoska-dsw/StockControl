package com.pc.stockcontrol.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;
import javax.persistence.*;

@NoArgsConstructor
@AllowPrintStacktrace
@Data
@Entity
public class Bom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long qty;

    @OneToOne
    private Part part;
}
