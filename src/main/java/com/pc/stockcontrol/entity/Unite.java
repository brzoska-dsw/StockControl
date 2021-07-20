package com.pc.stockcontrol.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllowPrintStacktrace
@Data
@Entity
public class Unite {

    @Id
    @Column(nullable = false)
    private String uniteNo;
    private String shortNo;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "unite_no")
    private List<Bom> bomList;

}
